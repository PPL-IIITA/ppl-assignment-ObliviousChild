/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import E.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
/**
 *
 * @author Megha
 */
public class Q12 
{
    public static ArrayList<Boy> singleBoys = new ArrayList<>();
    public static ArrayList<Girl> girls = new ArrayList<>();
    public static ArrayList<Couple> couples = new ArrayList<>();
    public static ArrayList<Gift> gifts = new ArrayList<>();
    public static ArrayList<Couple> toremove = new ArrayList<>();
    public static ArrayList<Couple> toadd = new ArrayList<>();

    
    public static void main(String[] args)
    {
        handleInput();
        setupAndGifting();
        monthlyProceedings();
        Logger.close();
    }
    
    /**
     * Initially sets up all couples
     */
    public static void setupAndGifting()
    {
        Boy b=null;
        Couple c=null;
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
    
        for (Girl g: girls)
        {
            switch(g.choice)
            {
                case 0:
                    b = g.choose (singleBoys,compareByAttr);
                    break;
                case 1:
                    b = g.choose (singleBoys,compareByBudget);
                    break;
                case 2:
                    b = g.choose (singleBoys,compareByIq);
                    break;
            }
            if (b!=null)
            {
                System.out.println(g.name+" got committed to "+b.name);
                Logger.commit(g.name,b.name);
                singleBoys.remove(b);
                c = new Couple(g,b);
                couples.add(c);
                b.gift(gifts);
                c.setHapp();
                System.out.println(c.happiness);
                System.out.println();
            }
            else
            {
                try
                {
                    throw new BfNotFound(g.name);
                }
                catch(BfNotFound ex)
                {
                    Exceptions.catcher(ex);
                }
            }
        }
    }

    /**
     * prints all couples per month and credits balances of all boys
     */
    public static void monthlyProceedings() 
    {
        Random r = new Random();
        Breakup breakup;
        double j;
        double happ[] = new double[12];
        for(int i=0,threshold=500; i<12; i++,threshold+=100)
        {   
            Logger.newMonth();
            System.out.println("\nMONTH "+(i+1));
            System.out.println("Couples at present:");
            int k = 0;
            for (Couple c: couples)
            {
                System.out.print(c);
                System.out.println("   "+c.getHapp());
                happ[k++] = c.getHapp();
            }
            System.out.println();
            
            for(Boy b: singleBoys)
            {
                j = r.nextInt(4);
                if (j==0) j=1/2;
                b.credit(j);
            }
            for(Couple c: couples)
            {
                j = r.nextInt(4);
                if (j==0) j=1/2;
                c.bf.credit(j,c,threshold);
            }
            updateCouples();
        }
    }
    
    /**
     * creates initial data structures for pre generated random girls, singleBoys and gifts
     */
    public static void handleInput()
    {
        try 
        {
            InputHandler input = new InputHandler();
            input.boycreator(singleBoys);
            input.girlcreator(girls);
            input.giftcreator(gifts);
            Comparator<Gift> byPrice = Comparator.comparingInt(Gift::getPrice);
            gifts.sort(byPrice);
            Logger.configure();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
        }
    }

    /**
     * updates list of couples at end of a month to account for breakups and accepted proposals
     */
    public static void updateCouples() 
    {
        
            for (Couple c: toremove)
                couples.remove(c);
            for (Couple c: toadd)
            {
                couples.add(c);
            }
            toadd.clear();
            toremove.clear();
    }
     
}
