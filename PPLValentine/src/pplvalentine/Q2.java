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
public class Q2 
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
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getIq);
        
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
            switch(g.type)
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
        
        Comparator<Gift> giftByPrice = Comparator.comparingInt(Gift::getPrice);
        Arrays.sort(gifts,giftByPrice);
        
        for (i=0; i<j; i++)
        {
            c = couples[i];
            c.bf.gift(gifts,bw);
            //c.gf.happiness();
            //System.out.println(c.gf +"    "+c.gf.happ);
        }
        
        Comparator<Couple> coupleByHapp = Comparator.comparingDouble(Couple::getHapp);
        Comparator<Couple> coupleByComp = Comparator.comparingInt(Couple::getComp);
        
        int k;
        //if (args[0]!=null)
        try
        {
            k = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            k = 5;
        }
        //else k=5;
        Arrays.sort(couples,0,j,coupleByHapp);
        
        System.out.println("\n"+k+" happiest couples are: \n");
        for (i=j-1; i>=j-k; i--)
        {
            c = couples[i];
            System.out.println(c.gf.name+" and "+c.bf.name+" with happiness "+c.getHapp());
        }
        
        System.out.println();
        
        System.out.println(k+" most compatible couples are: \n");
        Arrays.sort(couples,0,j,coupleByComp);
        for (i=j-1; i>=j-k; i--)
        {
            c = couples[i];
            System.out.println(c.gf.name+" and "+c.bf.name+" with compatibility "+c.getComp());
        }
        
        if (bw != null)bw.close();
        if (fw != null)fw.close();
    
    }
}