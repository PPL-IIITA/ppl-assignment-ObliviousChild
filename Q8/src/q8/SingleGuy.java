/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

/**
 * is thrown when we are looking for the girlfriend of a single guy
 * @author Megha
 */
public class SingleGuy extends Exception
{
    SingleGuy(String b)
    {
        super("Poor guy "+b+" is single.");
    }
}