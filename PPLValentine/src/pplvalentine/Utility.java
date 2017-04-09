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
public class Utility extends Gift
{
    int utilvalue;
    int utilclass;

    Utility(int p, int v, int uv, int uc)
    {
        super(p,v);
        utilvalue=uv;
        utilclass=uc;
    }
    
    @Override
    char getType()
    {
        return 'u';
    }
}
