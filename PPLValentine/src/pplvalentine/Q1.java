/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Megha
 */
public class Q1 
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // TODO code application logic here
        
        InputHandler input = new InputHandler();
        boys_attr = input.boycreator();                 //by attr
        boys_rich = boys_attr.clone();                 //by budget
        boys_iq = boys_attr.clone();                 //by iq
        girls = input.girlcreator();
        gifts = input.giftcreator();
        Boy b=null;
        int i,j=0;
        Girl g=null;
        Couple c=null;
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
        
        Arrays.sort(boys_attr,compareByAttr);
        Arrays.sort(boys_rich,compareByBudget);
        Arrays.sort(boys_iq,compareByIq);
        
        //Arrays.sort(myTypes, (a,b) -> a.name.compareTo(b.name));
        //Comparator<String> = Comparator.comparing(String::length);
        //Comparator<Integer> byString = Comparator.comparing(String::valueOf);
        
        FileWriter fw = new FileWriter("log.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (i=0; i<12; i++)
        {
            g = girls[i];
            switch(g.choice)
            {
                case 0:
                    b = g.choose(boys_attr);
                    break;
                case 1:
                    b = g.choose(boys_rich);
                    break;
                case 2:
                    b = g.choose(boys_iq);
                    break;
            }
            if (b!=null)
            {
                System.out.println(g.name+" got committed to "+b.name);
                Timestamp TS = new Timestamp(System.currentTimeMillis());
                bw.write(TS+" "+g.name+" got committed to "+b.name);
                couples[j++] = new Couple(g,b);
            }
            else
            {
                System.out.println("girl index " +i+ " did not find anyone");
                bw.write("girl index " +i+ " did not find anyone");
            }
            bw.newLine();
        }
        if (bw != null)bw.close();
        if (fw != null)fw.close();
    }
}    
    