/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

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
    
    Boy choose (Boy[] boys)                    
    {
        if (bf!=null)
            return null;
        int i;                                  // send appropriate sorted array, implement in main
        for (Boy b : boys)                     // ignore begin = index of first single boy
        {
            if (b.gf==null && maincost<=b.budget && attr>=b.attrreq && b!=exbf)
            {
                b.gf = this;
                //System.out.println(b.gf);
                bf = b;
                break;
            }
            //if (b.name.equals("defgh"))
              //  System.out.println("I am stupid I rejected this guy budget = "+b.budget)
        }
        return bf;
    }
    
    @Override
    public String toString()
    {
        return (" Name "+name+" Attractiveness "+attr+" Maintenance Cost "+maincost+" Intelligence "+iq+" Choice "+choice);
    }
}
