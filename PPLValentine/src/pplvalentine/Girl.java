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
public class Girl 
{
    String name;
    int attr;
    int maincost;
    int iq;
    int gifts;
    int choice;
    int type;
    int sumprice;
    Boy bf;
    double happ;
    
    Girl(int t, String n, int a, int c, int i, int ch)
    {
        type=t;
        name=n;
        attr=a;
        maincost=c;
        iq=i;
        choice=ch;          //preferrence of boyfriend, rich, iq or hot
        bf=null;
    }
    
    void gift(Gift g)
    {
        sumprice+=g.price;
        switch(type)
        {
            case 0:
                gifts+=g.price;
                if (g.luxrate!=0)
                    gifts+=g.price;
                break;
            case 1:
                gifts+=g.price + g.value;
                break;
            case 2:
                gifts+=g.price;
        }
        
    }
    
    double happiness()
    {
        if (sumprice<maincost)
            return 0;
        int gift = gifts-maincost;
        switch (type)
        {
            case 0:
                happ= Math.log(gift);
                break;
            case 1:
                happ= gift;
                break;
            case 2:
                happ= Math.pow(1.2,gift);
        }
        return happ;
    }
    
    Boy choose (Boy[] boys)                    // send appropriate sorted array, implement in main
    {
        int i;
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
        return ("Type "+type+" Name "+name+" Attractiveness "+attr+" Maintenance Cost "+maincost+" Intelligence "+iq+" Choice "+choice);
    }
}
