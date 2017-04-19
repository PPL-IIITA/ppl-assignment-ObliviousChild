/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

/**
 *
 * @author Megha
 */
public class Couple 
{
    Girl gf;
    Boy bf;
    double happiness;
    int compatibility;
    
    Couple(Girl g, Boy b)
    {
        gf=g;
        bf=b;
        happiness=0;
        compatibility=0;
    }
    
    void setHapp()
    {
        happiness = gf.happiness() + bf.happiness();
    }
    
    double getHapp()
    {
        setHapp();
        return happiness;
    }
    
    void setComp()
    {
        compatibility = bf.budget-gf.maincost + Math.abs(bf.attr-gf.attr) +Math.abs(bf.iq-gf.iq);
    }
    
    int getComp()
    {
        if (compatibility==0)
            setComp();
        return compatibility;
    }
    
    @Override
    public String toString()
    {
        return gf.name+"  "+bf.name;
    }
}
