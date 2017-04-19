/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

/**
 * is thrown when a boy cannot find a girlfriend
 * @author Megha
 */
public class GfNotFound extends Exception
{
    GfNotFound(String b)
    {
        super("404 Gf not found for "+b);
    }
}
