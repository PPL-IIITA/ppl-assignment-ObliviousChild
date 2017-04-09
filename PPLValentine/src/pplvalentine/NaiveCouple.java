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
public class NaiveCouple implements Comparable<NaiveCouple>
{
    String girl;
    String boy;
    
    NaiveCouple(String g, String b)
    {
        girl = g;
        boy = b;
    }
    
    @Override
    public int compareTo(NaiveCouple nc)
    {
        return this.boy.compareTo(nc.boy);
    }
    
    @Override
    public String toString()
    {
        return girl+" is with "+boy;
    }
}
