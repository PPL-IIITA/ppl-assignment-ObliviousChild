/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;


/**
 * is thrown when a command line input is greater than maximum possible value
 * @author Megha
 */
public class kOutOfBounds extends Exception
{
    kOutOfBounds(int k, int bound)
    {
        super("Set value = "+k+" is greater than maximum possible value = "+bound);
    }
}