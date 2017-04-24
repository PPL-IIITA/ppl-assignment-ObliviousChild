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
public class Q5 
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls_mcost[];
    static Girl girls_attr[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    
    public static void main(String[] args)
    {
        if (args.length>0 && args[0].equals("1"))
        {
            Q1.main(args);
            return;
        }
        handleInput();
        formCouples();
    }
    
    /**
     * forms couples by allowing girls and boys to choose alternately. girls are ordered by maintenance cost, and boys by attractiveness
     */
    public static void formCouples()
    {
        int i, j=0;
        Girl g = null;
        Boy b = null;
        
        for (i=0; i<50; i++)
        {
            if (i<12)
            {
            g = girls_mcost[i];
            if (g.bf!=null);
            else
            { switch(g.choice)
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
            }}
            if (j==12)  break;
            b = boys_attr[i];
            if (b.gf!=null)
                continue;
            g = b.choose(girls_attr);
            if (g!=null)
            {
                System.out.println(b.name+" got committed to "+g.name);
                Logger.commit(b.name,g.name);
                couples[j++] = new Couple(g,b);
            }
            else
            {
                try
                {
                throw new GfNotFound(b.name);
                }
                catch (GfNotFound ex)
                {
                    Exceptions.catcher(ex);
                }
            }
            if (j==12)  break;
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
            boys_attr = input.boycreator();                 //by attr
            boys_rich = boys_attr.clone();                 //by budget
            boys_iq = boys_attr.clone();                 //by iq
            girls_mcost = input.girlcreator();
            girls_attr = girls_mcost.clone();
            gifts = input.giftcreator();
            Boy b=null;
            int i,j=0;
            Girl g=null;
            Couple c=null;
            Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
            Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
            Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
            Comparator<Girl> compareGirlByAttr= Comparator.comparingInt(Girl::getNegAttr);
            Comparator<Girl> compareGirlByMcost= Comparator.comparingInt(Girl::getMcost);

            Arrays.sort(boys_attr,compareByAttr);
            Arrays.sort(boys_rich,compareByBudget);
            Arrays.sort(boys_iq,compareByIq);
            Arrays.sort(girls_mcost,compareGirlByMcost);
            Arrays.sort(girls_attr,compareGirlByAttr);
            Logger.configure();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input File not found.");
        }
    }
    
}    
    