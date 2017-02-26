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
public class Gift 
{
    final int price;
    final int value;
    int luxrate=0;
    int diff=0;
    int utilvalue=0;
    int utilclass=0;
    
    Gift(int p, int v)
    {
        price=p;
        value=v;
    }
    
    Gift(int p, int v, int l, int d)
    {
        price=p;
        value=v;
        luxrate=l;
        diff=d;
    }
    
    Gift(int p, int v, int uv, int uc, int utility)
    {
        price=p;
        value=v;
        utilvalue=uv;
        utilclass=uc;
    }
    
    int getPrice()
    {
        return price;
    }
    
    int getValue()
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return ("Price "+price+" Value "+value+" Luxury Rating "+luxrate);
    }
}
