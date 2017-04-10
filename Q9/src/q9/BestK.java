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
    
    /**
     * Provides k best items from ArrayList of items
     * @param <T> type of item
     * @param source ArrayList from which k best items to be fetched
     * @param cmp Comparator used for sorting
     * @param k value of k for k best items
     * @return ArrayList of k best items
     */
    
    int k = 5;
    public <T> ArrayList<T> findKBest(ArrayList<T> source, Comparator<T> cmp) 
    {
        Collections.sort(source,cmp);
        ArrayList<T> res = new ArrayList<T>(source.subList(0, k-1));
        return res;
    }
    
}
