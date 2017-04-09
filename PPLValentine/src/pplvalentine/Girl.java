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
    int attr;
    int maincost;
    int iq;
    int gifts;
    int choice;
    //int type;
    int sumprice;
    Boy bf;
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
    
    Boy choose (Boy[] boys)                    
    {
        int i;                                  // send appropriate sorted array, implement in main
        for (Boy b : boys)                     // ignore begin = index of first single boy
        {
            if (b.gf==null && maincost<=b.budget && attr>=b.attrreq)
            {
                b.gf = this;
                //System.out.println(b.gf);
                bf = b;
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
