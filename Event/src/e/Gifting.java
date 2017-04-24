/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E;

import java.util.ArrayList;
import java.util.EventObject;

/**
 *
 * @author Megha
 */
public class Gifting extends EventObject implements hasListener
{
    ArrayList<q12.Couple> listeners = new ArrayList<>(); 
    
    public Gifting(q12.Couple source) 
    {
        super(source);
        System.out.println(toString());
        addListener(source);
        handleSelf();
        System.out.println();
    }

    @Override
    public void addListener(Object t) 
    {
        q12.Couple b = (q12.Couple)t;
        listeners.add(b);
    }

    public void handleSelf() 
    {
        Breakup breakup;
        for (q12.Couple c: listeners)
        {
            c.bf.gift(q12.Q12.gifts);
        }
    }
    
    public String toString()
    {
        return "I am a Gifting event on "+(q12.Couple)source;
    }
}
