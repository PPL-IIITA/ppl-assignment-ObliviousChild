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
public class Q1 
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
        handleInput();
        allotBfs();
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
            Logger.configure();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
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
            else
            {
                try
                {
                throw new BfNotFound(g.name);
                }
                catch (BfNotFound ex)
                {
                    Exceptions.catcher(ex);
                }
            }
        }
        noofcouples=j;
    }

}    
    