/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Megha
 */
public class Q7 
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    static GfFinder finder = null;
    static int howToFind;
    
    public static void main(String[] args) throws FileNotFoundException
    {
        handleInput();
        setHowToFind(args);
        setFinder();
        allotBfs();
        findGf();
    }
    
    /**
     * sets howToFind as inputted, otherwise randomly
     * @param args 
     */
    public static void setHowToFind(String args[])
    {
        try
        {
            howToFind = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            try 
            {
                throw new NoArgumentSupplied(" howToFind ","randomly");
            }
            catch(NoArgumentSupplied exp)
            {
                Exceptions.catcher(exp);
                Random r=new Random();
                howToFind = r.nextInt(3);
            }
        }
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
     * creates object of required type of finder according to value of howToFind
     */
    public static void setFinder()
    {
        switch(howToFind)
        {
            case 0:
                finder = new GfInArray();
                System.out.println("Using Unsorted Array. Linear Search.\n");
                break;
            case 1:
                finder = new GfInSortedArray();
                System.out.println("Using Sorted Array. Binary Search.\n");
                break;
            case 2:
                finder = new GfInHashtable();
                System.out.println("Using Hashtable.\n");
                break;
        }
    }
    
    /**
     * finds gf of all boys using finder object
     */
    public static void findGf()
    {
        NaiveCouple nc;
        for (int i=0; i<50; i++)
        {
            nc = finder.getGf(boys_attr[i].name);
            try 
            {
                if (nc==null)
                throw new SingleGuy(boys_attr[i].name);
            } 
            catch (SingleGuy ex) 
            {
                Exceptions.catcher(ex);
                continue;
            }
            System.out.println(nc);
        }
    }
    
    /**
     * allots boyfriends to all girls in order of input
     */
    public static void allotBfs()
    {
        Girl g;
        Boy b = null;
        NaiveCouple nc;
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
                Logger.commit(g.name, b.name);
                nc = new NaiveCouple(g.name,b.name);
                finder.addCouple(nc);
            }
            else
            {
                try
                {
                throw new BfNotFound(g.name);
                }
                catch (BfNotFound ex1)
                {
                    Exceptions.catcher(ex1);
                }
            }
        }
    }
}    
    