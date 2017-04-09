/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.util.Arrays;
/**
 *
 * @author Megha
 */
public class GfInSortedArray extends GfFinder
{
    NaiveCouple couples[] = new NaiveCouple[12]; 
    int len = 0;
    
    @Override
    void addCouple(NaiveCouple nc) 
    {
        couples[len] = nc;
        len++;
        Arrays.sort(couples, 0, len);
    }

    @Override
    NaiveCouple getGf(String boy) 
    {
        NaiveCouple nc = new NaiveCouple("girl",boy);
        int i = Arrays.binarySearch(couples, 0, len, nc);
        if (i<0)
            return null;
        return couples[i];
    }
    
}
