/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Random;

/**
 *
 * @author Megha
 */
public class NewGirlInTown extends EventObject
{
    ArrayList<q12.Boy> listeners;
    public NewGirlInTown(q12.Girl source) 
    {
        super(source);
        System.out.println(toString());
        q12.Logger.newgirl(source);
        listeners = q12.Q12.singleBoys;
        handleSelf();
    }

    private void handleSelf() 
    {
        Random r = new Random();
        int t;
        q12.Boy b = null;
        for (int i = 0, size = listeners.size(); i<size; i++)
        {
            t = r.nextInt(size);
            b = listeners.get(t);
            if (b.handleNewGirlEvent((q12.Girl)source))
            {
                //raise Gifting Event
                break;
            }
        }
    }
    
    public String toString()
    {
        return "I am a newGirlInTown event.";
    }
}
