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
public class Essential extends Gift
{
    Essential(int p, int v)
    {
        super(p,v);
    }
    
    @Override
    char getType()
    {
        return 'e';
    }
}
