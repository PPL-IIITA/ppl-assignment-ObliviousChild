/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author Megha
 */
public class Q4
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    static int noofcouples;
    static int k;
    
    public static void main(String[] args)
    {
        // TODO code application logic here
        handleInput();
        allotBfs();
        performGifting();
        setk(args);
        breakup(k);
        Logger.close();
    }

    /**
     * sets k (k happiest couples) as inputted, or 5 otherwise
     * @param args command line input
     */
    public static void setk(String args[])
    {
        try
        {
            k = Integer.parseInt(args[0]);
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
    }
    
    /**
     * breaks up k least happy couples, then finds new bfs for single girls
     * @param k k least happy couples
     */
    public static void breakup(int k)
    {
        // TODO code application logic here
        Comparator<Couple> coupleByHapp = Comparator.comparingDouble(Couple::getHapp);
        int i,j;
        Couple c;
        Boy b = null;
        Girl g;
        
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
                //java.util.logging.Logger.getLogger(Q4.class.getName()).log(Level.SEVERE, null, ex1);
                Exceptions.catcher(ex1);
                k = noofcouples;
            }
        }
        Arrays.sort(couples,0,noofcouples,coupleByHapp);
        for (i=0; i<k; i++)
        {
            c = couples[i];
            c.gf.breakup();
            c.bf.breakup();
            System.out.println(c.gf.name+" and "+c.bf.name+" broke up. ");
            Logger.breakup(c.gf.name, c.bf.name);
        }
        
        for (i=0, j=noofcouples-1; i<k; i++)
        {
            c = couples[i];
            g = c.gf;
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
                Logger.commit(g.name, b.name);
                c.bf=b;
            }
            else
            {
                try
                {
                    throw new BfNotFound(g.name);
                }
                catch(BfNotFound ex){
                    Exceptions.catcher(ex);
                }
                couples[i] = couples[j];
                couples[i] = null;
                j--;
                noofcouples--;
            }
        }
        System.out.println();
    }
    
    /**
     * creates initial data structures for pre generated random girls, boys and gifts
     */
    public static void handleInput() 
    {
        InputHandler input = new InputHandler();
        try 
        {
            boys_attr = input.boycreator();             // to be sorted by attr
            boys_rich = boys_attr.clone();              // to be sorted by budget
            boys_iq = boys_attr.clone();                // to be sorted by iq
            girls = input.girlcreator();
            gifts = input.giftcreator();
            Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
            Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
            Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
            Arrays.sort(boys_attr,compareByAttr);
            Arrays.sort(boys_rich,compareByBudget);
            Arrays.sort(boys_iq,compareByIq);
            Logger.configure();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
        }
    }
    
    /**
     * allots boyfriends to all girls in order of input
     */
    public static void allotBfs() 
    {
        Girl g; Boy b=null; int j=0;
        for (int i=0; i<12; i++)
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
        noofcouples=j;
    }

    /**
     * performs gifting for all couples
     */
    public static void performGifting() 
    {
        Comparator<Gift> giftByPrice = Comparator.comparingInt(Gift::getPrice);
        Arrays.sort(gifts,giftByPrice);
        Couple c = null;
        for (int i=0; i<noofcouples; i++)
        {
            c = couples[i];
            c.bf.gift(gifts);
        }
    }

}
