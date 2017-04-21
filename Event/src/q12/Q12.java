/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import E.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    
    public static void main(String[] args)
    {
        handleInput();
        System.out.println(gifts.size());
        setupAndGifting();
        
        breakUpLessHappyCouples();
        int k = setk(args);
        kbestCouples(k);
        Logger.close();
    }
    
    /**
     * finds k happiest and k most compatible couples
     * @param k as inputted, or 5 if not inputted. sets to noofcouples if out of range
     */
    public static void kbestCouples(int k)
    {
        Comparator<Couple> coupleByHapp = Comparator.comparingDouble(Couple::getHapp);
        Comparator<Couple> coupleByComp = Comparator.comparingInt(Couple::getComp);
        Collections.sort(couples,coupleByHapp);
        Couple c;
        System.out.println("\n"+k+" happiest couples are: \n");
        int j = couples.size();
        for (int i=j-1; i>=j-k; i--)
        {
            c = couples.get(i);
            System.out.println(c.gf.name+" and "+c.bf.name+" with happiness "+c.getHapp());
        }
        System.out.println();
        System.out.println(k+" most compatible couples are: \n");
        Collections.sort(couples,coupleByComp);
        for (int i=j-1; i>=j-k; i--)
        {
            c = couples.get(i);
            System.out.println(c.gf.name+" and "+c.bf.name+" with compatibility "+c.getComp());
        }
    }
    
    /**
     * sets k (k happiest couples) as inputted, or 5 otherwise. or to noofcouples if value exceeds noofcouples
     * @param args command line input
     * @return value of k
     */
    public static int setk(String args[])
    {
        int k;
        Girl g;
        int noofcouples = couples.size();
        try
        {
            k = Integer.parseInt(args[0]);
            try
            {
            g = couples.get(k-1).gf;
            }
            catch (NullPointerException ex)
            {
                try 
                {
                    throw new kLargerThanNoOfCouples(k,5);
                } 
                catch (kLargerThanNoOfCouples ex1) 
                {
                    Exceptions.catcher(ex1);
                    k = 5;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            try {
                throw new NoArgumentSupplied(" k ",5);
            }
            catch(NoArgumentSupplied exp)
            {
                Exceptions.catcher(exp);
                k = 5;
            }
        }
        return k;
    }
    
    /**
     * allows all girls to choose bfs
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
                c = new Couple(g,b);
                couples.add(c);
                b.gift(gifts);
                c.setHapp();
                System.out.println(g.getHappiness());
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

    private static void breakUpLessHappyCouples() 
    {
        int barrier = 50;
        ArrayList<Couple> toremove = new ArrayList<>();
        for (Couple c:couples)
        {
            if (c.gf.getHappiness()<barrier)
            {
                //trigger breakup
                Breakup breakup = new Breakup(c);
                toremove.add(c);
            }
        }
        for (Couple c: toremove)
            couples.remove(c);
        for (Couple c: toadd)
            couples.add(c);
        toadd.clear();
    }
static ArrayList<Couple> toadd = new ArrayList<>();
     
}
