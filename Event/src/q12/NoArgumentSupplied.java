/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;


/**
 * is thrown when a command line argument is not supplied
 * @author Megha
 */
public class NoArgumentSupplied extends Exception
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
