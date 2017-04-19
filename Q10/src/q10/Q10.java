/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Megha
 */
public class Q10 
{
    public static ArrayList<Boy> boys = new ArrayList<>();
    public static ArrayList<Girl> girls = new ArrayList<>();
    public static ArrayList<Couple> couples = new ArrayList<>();
    public static ArrayList<Gift> gifts = new ArrayList<>();
    
    public static void main(String[] args)
    {
        handleInput();
        allotBfs();
        performGifting();
        int k = setk(args);
        kbestCouples(k);
        Logger.close();
    }
    
    /**
     * prints k happiest and k most compatible couples
     * @param k 
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
                    throw new kLargerThanNoOfCouples(k,noofcouples);
                } 
                catch (kLargerThanNoOfCouples ex1) 
                {
                    Exceptions.catcher(ex1);
                    k = noofcouples;
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
     * allow all girls to choose bfs as per logic. random out of best k.
     */
    public static void allotBfs()
    {
        Boy b=null;
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
    
        for (Girl g: girls)
        {
            switch(g.choice)
            {
                case 0:
                    b = g.choose (boys,compareByAttr);
                    break;
                case 1:
                    b = g.choose (boys,compareByBudget);
                    break;
                case 2:
                    b = g.choose (boys,compareByIq);
                    break;
            }
            if (b!=null)
            {
                System.out.println(g.name+" got committed to "+b.name);
                Logger.commit(g.name,b.name);
                couples.add(new Couple(g,b));
                boys.remove(b);
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
     * perform gifting for all couples as per logic. random out of best k.
     */
    public static void performGifting()
    {
        Comparator<Gift> compareByPrice= Comparator.comparingInt(Gift::getPrice);
        Comparator<Gift> compareByValue= Comparator.comparingInt(Gift::getValue);
        ArrayList<Gift> giftsss = new  ArrayList<>();
        Collections.sort(gifts,compareByPrice); 
        for (Couple c:couples)
        {
            giftsss.addAll(gifts);
            c.bf.gift(giftsss,compareByPrice,compareByValue);
        }
    }
    
    /**
     * creates initial data structures for pre generated random girls, boys and gifts
     */
    public static void handleInput()
    {
        try 
        {
            InputHandler input = new InputHandler();
            input.boycreator(boys);
            input.girlcreator(girls);
            input.giftcreator(gifts);
            Logger.configure();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
        }
    }
}
