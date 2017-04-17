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
public class Q3 
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    static int noofcouples;
    
    public static void main(String[] args)
    {
        // TODO code application logic here
        handleInput();
        
        Boy b=null;
        int i,j=0;
        
        allotBfs();
        performGifting();
        int k;
        try
        {
            k = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            k = 5;
        }
        
        kbest(k);
        Logger.close();
    }

    private static void handleInput() 
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
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
        }
    }

    private static void kbest(int k) 
    {
        int i,j=noofcouples;
        Couple c;
        if (k>noofcouples) 
        {
            System.out.println("k is more than number of couples");
            return;
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

    private static void allotBfs() 
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
        }
        noofcouples=j;
    }

    private static void performGifting() 
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
