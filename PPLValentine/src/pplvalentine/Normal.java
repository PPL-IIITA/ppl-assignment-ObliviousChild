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
public class Normal extends Girl
{
    Normal(String n, int a, int c, int i, int ch)
    {
        super(n,a,c,i,ch);
    }
    
    @Override
    void gift(Gift g)
    {
        sumprice+=g.price;
        gifts+=g.price + g.value;
    }
    
    @Override
    double happiness()
    {
        if (bf==null) return -1;
        if (sumprice<maincost)
            return 0;
        int gift = gifts-maincost;
        happ= gift;
        return happ;
    }

    @Override
    char getType() 
    {
        return 'n';
    }
    
}
