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
public class Luxury extends Gift
{
    int diff;
    
    Luxury(int p, int v, int l, int d)
    {
        super(p,v);
        diff=d;
    }
    
    @Override
    char getType()
    {
        return 'l';
    }
}
