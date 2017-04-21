/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

/**
 * used in catching exceptions
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