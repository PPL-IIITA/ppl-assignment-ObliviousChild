/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import L.*;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Megha
 */
public abstract class Boy //implements L.NewGirlListener
{    
    String name;
    final int attr;
    int budget;
    final int iq;
    //int type;
    Girl gf;
    Girl exgf;
    final int attrreq;
    int wallet;
    double happ;
    int e,l,u;
    private final int originalBudget;
    int giftsCheckedUptoIndex;
    
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
    abstract void gift (ArrayList<Gift> gifts);
        
    abstract double happiness ();
    
    void breakup()
    {
        exgf = gf;
        gf = null;
        happ = 0;
    }
    
    Girl choose (Girl girls[])
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
    
/*    void giftingVersion2 (Gift gifts[], BufferedWriter bw) throws IOException 
    {
        int i = giftsCheckedUptoIndex;
        int n = gifts.length;
        Gift g;
        for (; (i<n && !(l!=0 && e!=0 && u!=0)); i++)
        {
            g = gifts[i];
            switch (g.getType())
            {
                case 'l':
                    if (l!=0)   {gf.gift(g);log(bw);}
                    break;
                case 'e':
                    if (e!=0)   {gf.gift(g);log(bw);}
                    break;
                case 'u':
                    if (u!=0)   {gf.gift(g);log(bw);}
                    break;
            }
        }
    }
  */  
    void log()
    {
        Logger.gifting(name,gf.name,budget-wallet,e,l,u);
    }
    
    @Override
    public String toString()
    {
        return (name + " attr "+attr+" rich "+budget+" iq "+iq);
    }

    public boolean handleNewGirlEvent(Girl g) 
    {
        if (g.qualified(this))
        {
            Random r=new Random();
            if(r.nextInt(5)==1)
            {
            g.bf = this;
            gf = g;
            Q12.singleBoys.remove(this);
            Q12.toadd.add(new Couple(g,this));
            Logger.commit(name, gf.name);
            return true;
            }
        }
        return false;
    }
    
}
