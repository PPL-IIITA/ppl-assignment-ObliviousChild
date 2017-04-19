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
 * @author Megha
 */
public class BestK {
    
    
    int k = 4;
    /**
     * Provides k best items from ArrayList of items
     * @param <T> type of item
     * @param source ArrayList from which k best items to be fetched
     * @param cmp Comparator used for sorting
     * @return ArrayList of k best items
     */
    public <T> ArrayList<T> findKBest(ArrayList<T> source, Comparator<T> cmp) 
    {
        //k = 20;
        Collections.sort(source,cmp);
        ArrayList<T> res = null;
        try
        {
            res= new ArrayList<>(source.subList(0, k));
        }
        catch (Exception Ex)
        {
            try
            {
                throw new kOutOfBounds(k,source.size());
            }
            catch (kOutOfBounds ex)
            {
                Exceptions.catcher(ex);
                k = source.size();
                res= new ArrayList<>(source.subList(0, k));
            }
        }
        return res;
    }
}
