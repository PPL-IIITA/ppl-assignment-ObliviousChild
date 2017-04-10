/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

/**
 *
 * @author Mac
 */
public class Gift 
{
    final int price;
    final int value;
    final int luxrate;
    final int diff;
    final int utilvalue;
    final int utilclass;
    final char type;
    
    Gift(int p, int v, int l, int d, int uv, int uc, char t)
    {
        price=p;
        value=v;
        luxrate=l;
        diff=d;
        utilvalue=uv;
        utilclass=uc;
        type=t;
    }
    
    int getPrice()
    {
        return price;
    }
    
    int getValue()
    {
        return -value;
    }
    
    char getType()
    {
        return type;
    }
    
    @Override
    public String toString()
    {
        return ("Price "+price+" Value "+value+" Luxury Rating "+luxrate);
    }
}
