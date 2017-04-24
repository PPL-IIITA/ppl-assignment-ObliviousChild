/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import E.*;
import L.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * listener to NewGirlInTown event
 * @author Megha
 */
public abstract class Boy implements L.NewGirlListener
{    
    String name;
    public final int attr;
    public int budget;
    public final int iq;
    //int type;
    public Girl gf;
    public Girl exgf;
    public final int attrreq;
    public int wallet;
    double happ;
    int e,l,u;
    private final int originalBudget;
    int giftsCheckedUptoIndex;
    public int walletBeforeGifting;
    
    Boy (String n, int a, int r, int b, int i)
    {
        //type=t;
        name=n;
        attr=a;
        budget=b;
        iq=i;
        attrreq=r;
        gf=null;
        wallet=0;
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
    abstract public void gift (ArrayList<Gift> gifts);
        
    abstract double happiness ();
    
    /**
     * credits into single boy's wallet
     */
    public void credit(double i)
    {
        
        wallet+=i*originalBudget;
        walletBeforeGifting = wallet;
        
    }
    /**
     * credits into committed boy's wallet
     */
    public void credit(double i, Couple c,int threshold)
    {
        wallet+=i*originalBudget;
        walletBeforeGifting = wallet;
        
        Breakup breakup;
                Gifting gifting = new Gifting (c);
                if (c.getHapp()<threshold)
                {
                    breakup = new Breakup(c);
                    Q12.toremove.add(c);
                }
            
            
    }
    
    void breakup()
    {
        exgf = gf;
        gf = null;
        happ = 0;
    }
    
    public Girl choose (Girl girls[])
    {
        if (gf!=null)
            return null;
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
    
    void log()
    {
        Logger.gifting(name,gf.name,walletBeforeGifting-wallet,gf.happiness()+happiness());
    }
    
    @Override
    public String toString()
    {
        return (name + " attr "+attr+" rich "+budget+" iq "+iq);
    }

    /**
     * proposes to new girl, triggers gifting event on new couple if accepted
     * @param g the newly single girl
     * @return 
     */
    @Override
    public boolean handleNewGirlEvent(Girl g) 
    {
        if (g.qualified(this))
        {
        if (g.proposed(this))
        {
            Random r=new Random();
            if(r.nextInt(5)==1)
            {
            g.bf = this;
            gf = g;
            Q12.singleBoys.remove(this);
            Couple c = new Couple(g,this);
            Q12.toadd.add(c);
            Logger.proposalAccepted(name, gf.name);
            Gifting gifting = new Gifting(c);
            //trigger gifting
            return true;
            }
        }
        else
            Logger.proposalRejected(name, g.name);
        }
        return false;
    }
    
}
