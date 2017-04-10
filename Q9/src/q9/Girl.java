/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Mac
 */
public abstract class Girl 
{
    String name;
    final int attr;
    final int maincost;
    final int iq;
    int gifts;
    final int choice;
    //int type;
    int sumprice;
    Boy bf;
    Boy exbf;
    double happ;
    BestK bestk = new BestK();
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
    
    abstract double happiness();
    
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
    
    Boy choose (ArrayList<Boy> boys, Comparator<Boy> cmp1, Comparator<Boy> cmp2)                    
    {
        if (bf!=null)
            return null;
        int i;
        
        boys = bestk.findKBest(boys, cmp1);
        Collections.sort(boys, cmp2);
        
        for(Boy b: boys)
        {
            if (b.gf==null && b.budget>=maincost && attr>=b.attrreq)
            {
                bf = b;
                b.gf = this;
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
}
