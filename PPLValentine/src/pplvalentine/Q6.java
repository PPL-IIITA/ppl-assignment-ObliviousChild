/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

/**
 *
 * @author Megha
 */
public class Q6 
{
    static int t;
    static int k;
    
    /**
     * uses methods of question 4 to perform gifting and breakups 't' number of times
     * @param args 
     */
    public static void main(String args[])
    {
        Q4.handleInput();
        Q4.allotBfs();
        setk(args);
        Q4.performGifting();
        
        setT(args);
        
        for (int i=0; i<t; i++)
        {
            Q4.breakup(k);
            Q4.performGifting();
        }
    }
    
    /**
     * sets k (k happiest couples) as inputted, or 5 otherwise
     * @param args command line input
     */
    public static void setk(String args[])
    {
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
    }
    
    /**
     * sets t (frequency of gifting) as inputted, or 10 otherwise
     * @param args command line input
     */
    public static void setT(String args[])
    {
        try
        {
            t = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            try {
                throw new NoArgumentSupplied(" t (frequency of gifting)  ",10);
            }
            catch(NoArgumentSupplied exp)
            {
                Exceptions.catcher(exp);
                t = 10;
            }
        }
    }
    
}
