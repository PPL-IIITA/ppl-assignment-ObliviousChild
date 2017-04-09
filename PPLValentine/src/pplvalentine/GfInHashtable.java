/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.util.Hashtable;

/**
 *
 * @author Megha
 */
public class GfInHashtable extends GfFinder
{

    Hashtable<String, NaiveCouple> hashtable = new Hashtable<String, NaiveCouple>();
    @Override
    void addCouple(NaiveCouple nc) 
    {
        hashtable.put(nc.boy, nc);
    }

    @Override
    NaiveCouple getGf(String boy) 
    {
        NaiveCouple nc = hashtable.get(boy);
        return nc;
    }
    
}
