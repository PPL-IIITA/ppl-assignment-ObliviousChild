/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

/**
 *
 * @author Megha
 */
public class GfInArray extends GfFinder
{
    NaiveCouple couples[] = new NaiveCouple[12]; 
    int len = 0;
    
    @Override
    public void addCouple(NaiveCouple nc) 
    {
        couples[len] = nc;
        len++;
    }

    @Override
    public NaiveCouple getGf(String boy) 
    {
        for (int i=0; i<len; i++)
            if (couples[i].boy.equals(boy))
                return couples[i];
        return null;
    }
    
    
}
