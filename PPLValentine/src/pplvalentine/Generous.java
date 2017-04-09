/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Megha
 */
public class Generous extends Boy
{
    Generous(String n, int a, int r, int b, int i)
    {
        super(n,a,r,b,i);
    }
    
    @Override
    double happiness()
    {
        if (gf==null) return -1;
        happ = gf.happiness();
        return happ;
    }

    @Override
    void gift(Gift[] gifts, BufferedWriter bw) throws IOException 
    {
        if (gf==null)                   // gifts sorted by price, 60 gifts
            return;
        int target;
        int i;l=0;u=0;e=0;
        budget = getOriginalBudget();
        wallet = budget;                //reset wallet amount to budget every time before gifting begins
        int n=gifts.length;
        int mcost = gf.maincost;
        Gift g;
        
        for (i=0; i<n; i++)
        {
            g = gifts[i];
            if (g.price>wallet && mcost>0) break;       //break if macost has been covered but next gift is not within available wallet amount
            wallet-=g.price;            // go on picking gifts until maintainence cost is reached
            mcost-=g.price;
            gf.gift(g);
            switch (g.getType())        // count number of each type of gifts simultaneously
            {
                case 'l':   l++;    break;
                case 'u':   u++;    break;
                case 'e':   e++;    break;
            }
            //wallet might go into negative. If so, it means that budget needs to be updated and gifting process is complete. Proceed to logging.
            if (wallet<=0)
            {
                budget-=wallet;
                wallet=0;
                log(bw);
                return;
            }
        }
        
        log(bw);
    }
}
