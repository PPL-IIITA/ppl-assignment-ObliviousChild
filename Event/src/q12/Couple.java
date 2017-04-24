/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

/**
 * Listener to BREAKUP and GIFTING events
 * @author Megha
 */
public class Couple implements L.BreakupListener,L.GiftingListener
{
    public Girl gf;
    public Boy bf;
    public double happiness;
    int compatibility;
    
    Couple(Girl g, Boy b)
    {
        gf=g;
        bf=b;
        happiness=0;
        compatibility=0;
    }
    
    public void setHapp()
    {
        happiness = gf.happiness() + bf.happiness();
    }
    
    public double getHapp()
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
        return gf.name+" and "+bf.name;
    }

    /**
     * handler for BREAKUP event. Raises NewGirlInTown event.
     */
    @Override
    public void handleBreakup() 
    {
        System.out.println(gf.name+" and "+bf.name+" are breaking up. Happiness of gf = "+gf.getHappiness());
        gf.breakup();
        bf.breakup();
        //Q12.couples.remove(this);
        Q12.singleBoys.add(bf);
        Logger.breakup(gf.name, bf.name);
        E.NewGirlInTown newSingleGirl = new E.NewGirlInTown(gf);
    }
}
