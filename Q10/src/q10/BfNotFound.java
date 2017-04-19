/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

/**
 * is thrown when a girl cannot find a boyfriend
 * @author Megha
 */
public class BfNotFound extends Exception
{
    BfNotFound(String g)
    {
        super("404 Bf not found for "+g);
    }
}
