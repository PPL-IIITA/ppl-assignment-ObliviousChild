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
public class Breakup extends EventObject implements hasListener
{
    ArrayList<q12.Couple> listeners = new ArrayList<>(); 
    
    public Breakup(q12.Couple source) 
    {
        super(source);
        System.out.println(toString());
        addListener(source);
        handleSelf();
        System.out.println();
    }

    public void handleSelf() 
    {
        for (q12.Couple c:listeners)
        {
            c.handleBreakup();
        }
        //raised new girl
    }

    @Override
    public void addListener(Object t) 
    {
        q12.Couple c = (q12.Couple)t;
        listeners.add(c);
    }
    
    public String toString()
    {
        q12.Couple c = (q12.Couple)source;
        return "I am a Breakup event on "+c;
    }

}
