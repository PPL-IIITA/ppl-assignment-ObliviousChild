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
 * @author Mac
 */
public class Boy 
{
    String name;
    int attr;
    int budget;
    int iq;
    int type;
    Girl gf;
    int attrreq;
    int wallet;
    double happ;
    
    Boy (int t, String n, int a, int r, int b, int i)
    {
        type=t;
        name=n;
        attr=a;
        budget=b;
        iq=i;
        attrreq=r;
        gf=null;
        wallet=b;
        happ=0;
    }
    
    int getAttr()
    {
        return -attr;
    }
    int getBudget()
    {
        return -budget;
    }
    int getIq()
    {
        return -iq;
    }
    
    void gift (Gift gifts[], BufferedWriter bw) throws IOException                      // gifts sorted by price, 60 gifts, n=60, pass 60
    {
        if (gf==null)
            return;
        int target;
        int i,l=0,u=0,e=0;
        int n=60;
        int mcost = gf.maincost;
        Gift g;
                
        for (i=0; i<n; i++)
        {
            g = gifts[i];
            if (mcost<=0) break;
            wallet-=g.price;
            mcost-=g.price;
            gf.gift(g);
            if (g.luxrate!=0)
                l++;
            else if (g.utilclass!=0)
                u++;
            else 
                e++;
        }
        if (wallet<0)
        {
            budget-=wallet;
            wallet=0;
        }
        // have reached maintenance cost and updated buddget if necessary
        // miser, job done
        // generous, reach just under budget
        // geek, procure additional luxury gift
        
        if (wallet==0)
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write(TS+" "+name+" gifted "+gf.name+" gifts of total cost "+(budget-wallet)+" essential: "+e+" luxury: "+l+" utility: "+u);
            bw.newLine();
            return;
        }
            //return;
        
        switch (type) 
        {
            case 0:
                Timestamp TS = new Timestamp(System.currentTimeMillis());
                bw.write(TS+" "+name+" gifted "+gf.name+" gifts of total cost "+(budget-wallet)+" essential: "+e+" luxury: "+l+" utility: "+u);
                bw.newLine();
                return;
            case 1:
                target = budget-gf.maincost;
                for (;i<n;i++)
                {
                    g = gifts[i];
                    if (g.price<=wallet)
                    {
                        gf.gift(g);
                        wallet-=g.price;
                        target-=g.price;
                        if (g.luxrate!=0)
                            l++;
                        else if (g.utilclass!=0)
                            u++;
                        else 
                            e++;
                    }
                    else
                    {
                        TS = new Timestamp(System.currentTimeMillis());
                        bw.write(TS+" "+name+" gifted "+gf.name+" gifts of total cost "+(budget-wallet)+" essential: "+e+" luxury: "+l+" utility: "+u);
                        bw.newLine();
                        return;
                    }
                }
                break;
            case 2:
                for (;i<n;i++)
                {
                    g = gifts[i];
                    if (g.price>wallet)
                        break;
                    if (g.luxrate!=0)
                    {
                        if (g.price<=wallet)
                        {
                            gf.gift(g);
                            l++;
                        }
                        break;
                    }
                }
        }
        Timestamp TS = new Timestamp(System.currentTimeMillis());
        bw.write(TS+" "+name+" gifted "+gf.name+" gifts of total cost "+(budget-wallet)+" essential: "+e+" luxury: "+l+" utility: "+u);
        bw.newLine();
        
    }
    
    double happiness ()
    {
        if (gf!=null)
            switch(type)
            {
                case 0:
                    happ = wallet;
                    break;
                case 1:
                    happ = gf.happiness();
                    break;
                case 2:
                    happ = gf.iq;
            }
        return happ;
    }
    
    Girl choose (Girl girls[])
    {
        for (Girl g: girls)
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
    
    @Override
    public String toString()
    {
        return ("type" + type + name + " attr "+attr+" rich "+budget+" iq "+iq);
    }
}