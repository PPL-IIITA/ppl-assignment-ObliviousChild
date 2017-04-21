/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Megha
 */

class Event101 extends EventObject
{
    public Event101(Object source) 
    {
        super(source);
        handleself();
    }
    @Override
    public String toString()
    {
        return "I am Event101";
    }
    void handleself()
    {
        Listener101.handle(source);
    }
}

class Listener101 implements EventListener
{
    static void handle(Object source) 
    {
        Girl g = (Girl) source;
        g.breakup();
        System.out.println("Event handled.");
    }
}

public class mainEventRaiseKarunga 
{
    static Girl g;
    public static void main(String args[])
    {
        Q12.handleInput();
        g = Q12.girls.get(0);
        raise();
    }
    static void raise()
    {
        Event101 nayaEvent = new Event101(g);
    }
}
