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
public abstract class Boy 
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
    abstract void gift (Gift gifts[]);
        
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
    
    void log()
    {
            Logger.gifting(name, gf.name, budget-wallet, l, e, u);
    }
    
    @Override
    public String toString()
    {
        return (name + " attr "+attr+" rich "+budget+" iq "+iq);
    }
    
}
