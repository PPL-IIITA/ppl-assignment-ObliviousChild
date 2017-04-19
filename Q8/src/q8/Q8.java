/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Megha
 */
public class Q8 
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    static int noofcouples;
    static GiftSelector gifter;

    public static void main(String[] args)
    {
        handleInput();
        int howToGift = setHowToGift(args);
        setGifter(howToGift);
        allotBfs();
        int k = setk(args);
        performGifting();
        kbest(k);
    }
    
    /**
     * performs Gifting 
     */
    public static void performGifting()
    {
        Couple c = null;
        for (int i=0; i<noofcouples; i++)
        {
            c = couples[i];
            gifter.gift(c.bf,gifts);
        }
    }

    /**
     * creates GiftSelector object of required type
     * @param howToGift 1 denotes new method, otherwise old method
     */
    public static void setGifter(int howToGift)
    {
        if (howToGift==1)
        {
            gifter = new NewGifting();
            System.out.println("Gifting using new method\n");
        }
        else 
        {
            gifter = new OldGifting();
            System.out.println("Gifting using old method\n");
        }
    }
    
    /**
     * finds k happiest and k most compatible couples
     * @param k as inputted, or 5 if not inputted. sets to noofcouples if out of range
     */
    private static void kbest(int k) 
    {
        int i,j=noofcouples;
        Couple c; Girl g;
        try
        {
            g = couples[k-1].gf;
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
        Comparator<Couple> coupleByHapp = Comparator.comparingDouble(Couple::getHapp);
        Comparator<Couple> coupleByComp = Comparator.comparingInt(Couple::getComp);
        Arrays.sort(couples,0,noofcouples,coupleByHapp);
        System.out.println("\n"+k+" happiest couples are: \n");
        for (i=j-1; i>=j-k; i--)
        {
            c = couples[i];
            System.out.println(c.gf.name+" and "+c.bf.name+" with happiness "+c.getHapp());
        }
        System.out.println();
        System.out.println(k+" most compatible couples are: \n");
        Arrays.sort(couples,0,noofcouples,coupleByComp);
        for (i=j-1; i>=j-k; i--)
        {
            c = couples[i];
            System.out.println(c.gf.name+" and "+c.bf.name+" with compatibility "+c.getComp());
        }
    }
    
    /**
     * sets howToGift according to command line input
     * @param args command line input
     * @return value of howToGift
     */
    public static int setHowToGift(String args[])
    {
        int k;
        try
        {
            k = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            try 
            {
                throw new NoArgumentSupplied(" k ",0);
            }
            catch(NoArgumentSupplied exp)
            {
                Exceptions.catcher(exp);
                k = 0;
            }
        }
        return k;
    }
    
    /**
     * sets k (k happiest couples) as inputted, or 5 otherwise
     * @param args command line input
     * @return value of k
     */
    public static int setk(String args[])
    {
        int k;
        try
        {
            k = Integer.parseInt(args[1]);
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
     * allots boyfriends to all girls in order of input
     */
    public static void allotBfs()
    {
        Boy b=null;
        int i,j=0;
        Girl g=null;
        Couple c=null;
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
        
        Arrays.sort(boys_attr,compareByAttr);
        Arrays.sort(boys_rich,compareByBudget);
        Arrays.sort(boys_iq,compareByIq);
        
        for (i=0; i<12; i++)
        {
            g = girls[i];
            switch(g.choice)
            {
                case 0:
                    b = g.choose(boys_attr);
                    break;
                case 1:
                    b = g.choose(boys_rich);
                    break;
                case 2:
                    b = g.choose(boys_iq);
                    break;
            }
            if (b!=null)
            {
                System.out.println(g.name+" got committed to "+b.name);
                Logger.commit(g.name,b.name);
                couples[j++] = new Couple(g,b);
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
        noofcouples = j;
    }
    
    /**
     * creates initial data structures for pre generated random girls, boys and gifts
     */
    public static void handleInput()
    {
        try
        {
            InputHandler input = new InputHandler();
            boys_attr = input.boycreator();             // to be sorted by attr
            boys_rich = boys_attr.clone();              // to be sorted by budget
            boys_iq = boys_attr.clone();                // to be sorted by iq
            girls = input.girlcreator();
            gifts = input.giftcreator();
            Comparator<Gift> giftByPrice = Comparator.comparingInt(Gift::getPrice);
            Arrays.sort(gifts,giftByPrice);
            Logger.configure();
            
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
        }
    }
}
