/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

/**
 *
 * @author Mac
 */
public abstract class Gift 
{
    final int price;
    final int value;
    Gift(int p, int v)
    {
        price=p;
        value=v;
    }
    
    int getPrice()
    {
        return price;
    }
    
    int getValue()
    {
        return value;
    }
    
    abstract char getType();
    
    /*@Override
    public String toString()
    {
    return ("Price "+price+" Value "+value+);
    }*/
}
