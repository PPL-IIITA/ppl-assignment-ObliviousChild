/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Megha
 */
public class NewGifting extends GiftSelector
{
    @Override
    void gift(Boy b, Gift[] gifts) 
    {
        b.gift(gifts);
        giftingVersion2(b, gifts);
    }
    
    void giftingVersion2 (Boy b, Gift gifts[])
    {
        int i = b.giftsCheckedUptoIndex;
        int n = gifts.length;
        Gift g;
        for (; (i<n && !(b.l!=0 && b.e!=0 && b.u!=0)); i++)
        {
            g = gifts[i];
            switch (g.getType())
            {
                case 'l':
                    if (b.l!=0)   {b.gf.gift(g);b.log();}
                    break;
                case 'e':
                    if (b.e!=0)   {b.gf.gift(g);b.log();}
                    break;
                case 'u':
                    if (b.u!=0)   {b.gf.gift(g);b.log();}
                    break;
            }
        }
    }
    
    
}
