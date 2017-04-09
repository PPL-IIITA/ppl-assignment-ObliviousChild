/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 *
 * @author Megha
 */
public abstract class Boy 
{    
    String name;
    int attr;
    int budget;
    int iq;
    //int type;
    Girl gf;
    int attrreq;
    int wallet;
    double happ;
    int e,l,u;
    private int originalBudget;
    
    Boy (String n, int a, int r, int b, int i)
    {
        //type=t;
        name=n;
        attr=a;
        budget=b;
        iq=i;
        attrreq=r;
        gf=null;
        wallet=budget;
        happ=0;
        e=0;
        l=0;
        u=0;
        originalBudget = budget;
    }
    
    int getNegAttr()
    {
        return -attr;
    }
    int getNegBudget()
    {
        return -budget;
    }
    int getNegIq()
    {
        return -iq;
    }
    int getOriginalBudget()
    {
        return originalBudget;
    }
    abstract void gift (Gift gifts[], BufferedWriter bw) throws IOException;
        
    abstract double happiness ();
    
    Girl choose (Girl girls[])
    {
        for (Girl g: girls)                 //pass sorted array
        {
            if (g.bf==null && budget>=g.maincost && g.attr>=attrreq)
            {
                gf = g;
                g.bf = this;
                break;
            }
        }
        return gf;
    }
    
    void log(BufferedWriter bw) throws IOException
    {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write(TS+" "+name+" gifted "+gf.name+" gifts of total cost "+(budget-wallet)+" essential: "+e+" luxury: "+l+" utility: "+u);
            bw.newLine();
    }
    
    @Override
    public String toString()
    {
        return (name + " attr "+attr+" rich "+budget+" iq "+iq);
    }
    
}
