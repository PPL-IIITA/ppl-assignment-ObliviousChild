/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Mac
 */
public abstract class Girl 
{
    public String name;
    public final int attr;
    public final int maincost;
    public final int iq;
    int gifts;
    final int choice;
    //int type;
    int sumprice;
    public Boy bf;
    public Boy exbf;
    double happ;
    
    Girl(String n, int a, int c, int i, int ch)
    {
        //type=t;
        name=n;
        attr=a;
        maincost=c;
        iq=i;
        choice=ch;          //preferrence of boyfriend, rich, iq or hot
        bf=null;
    }
    
    abstract void gift(Gift g);
    
    public abstract double happiness();
    
    abstract char getType();
    
    double getHappiness()
    {
        return happ;
    }
    
    int getNegAttr()
    {
        return -attr;
    }
    
    int getMcost()
    {
        return maincost;
    }
    
    void breakup()
    {
        exbf = bf;
        bf = null;
        happ = 0;
        sumprice = 0;
        gifts = 0;
    }
    
    Boy choose (ArrayList<Boy> singleBoys, Comparator<Boy> cmp)                    
    {
        if (bf!=null)
            return null;
        int i;
        singleBoys.sort(cmp);
        for(Boy b: singleBoys)
        {
            if (b.gf==null && b.budget>=maincost && attr>=b.attrreq)
            {
                bf = b;
                b.gf = this;
                singleBoys.remove(b);
                break;
            }
        }
        return bf;
    }
    
    @Override
    public String toString()
    {
        return (" Name "+name+" Attractiveness "+attr+" Maintenance Cost "+maincost+" Intelligence "+iq+" Choice "+choice);
    }

    public boolean qualified(Boy b) 
    {
        return (b.gf==null && b.budget>=maincost && attr>=b.attrreq && b!=exbf);
    }
    
    /**
     * probability of acceptance = 30%
     * @param b
     * @return 
     */
    public boolean proposed(Boy b)
    {
        Random r = new Random(10);
        return (r.nextInt()<=2);
    }
}
