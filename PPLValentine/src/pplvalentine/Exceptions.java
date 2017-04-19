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
public class Exceptions
{
    public static void catcher(Exception ex)
    {
        System.out.println();
        System.out.println(ex);
        System.out.println();
        Logger.exception(ex.toString());
    }
}

/**
 * is thrown when a girl cannot find a boyfriend
 * @author Megha
 */
class BfNotFound extends Exception
{
    BfNotFound(String g)
    {
        super("404 Bf not found for "+g);
    }
}

/**
 * is thrown when a boy cannot find a girlfriend
 * @author Megha
 */
class GfNotFound extends Exception
{
    GfNotFound(String b)
    {
        super("404 Gf not found for "+b);
    }
}

/**
 * is thrown when input for k(k best couples) is more than number of couples
 * @author Megha
 */
class kLargerThanNoOfCouples extends Exception
{
    kLargerThanNoOfCouples(int k, int n)
    {
        super("Cannot find "+k+" couples. There are only "+n+" couples formed.");
    }
}

/**
 * is thrown when a command line argument is not supplied
 * @author Megha
 */
class NoArgumentSupplied extends Exception
{
    NoArgumentSupplied(String argument, String defaultValue)
    {
        super("No argument supplied for"+argument+". Setting"+argument+"= "+defaultValue);
    }
    
    NoArgumentSupplied(String argument, int defaultValue)
    {
        super("No argument supplied for"+argument+". Defaulting"+argument+"= "+defaultValue);
    }
}

/**
 * is thrown when a command line input is greater than maximum possible value
 * @author Megha
 */
class kOutOfBounds extends Exception
{
    kOutOfBounds(int k, int bound)
    {
        super("Set value = "+k+" is greater than maximum possible value = "+bound);
    }
}

/**
 * is thrown when we are looking for the girlfriend of a single guy
 * @author Megha
 */
class SingleGuy extends Exception
{
    SingleGuy(String b)
    {
        super("Poor guy "+b+" is single.");
    }
}