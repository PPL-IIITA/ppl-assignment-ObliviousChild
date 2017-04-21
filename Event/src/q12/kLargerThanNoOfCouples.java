/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;


/**
 * is thrown when input for k(k best couples) is more than number of couples
 * @author Megha
 */
public class kLargerThanNoOfCouples extends Exception
{
    kLargerThanNoOfCouples(int k, int n)
    {
        super("Cannot find "+k+" couples. There are only "+n+" couples formed.");
    }
}
