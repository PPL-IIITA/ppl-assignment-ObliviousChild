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
public class Q6
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
        boys_attr = input.boycreator();             // to be sorted by attr
        boys_rich = boys_attr.clone();              // to be sorted by budget
        boys_iq = boys_attr.clone();                // to be sorted by iq
        girls = input.girlcreator();
        gifts = input.giftcreator();
        Boy b=null;
        int i,j=0;
        int numcouples;
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
        
        Comparator<Gift> giftByPrice = Comparator.comparingInt(Gift::getPrice);
        Arrays.sort(gifts,giftByPrice);
        numcouples = j;
        
        Comparator<Couple> coupleByHapp = Comparator.comparingDouble(Couple::getHapp);
        //Comparator<Couple> coupleByComp = Comparator.comparingInt(Couple::getComp);
        
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
        if (k>j) 
        {
            System.out.println("k is more than number of couples");
            return;
        }
        Arrays.sort(couples,0,j,coupleByHapp);
        
        //System.out.println("\n"+k+" happiest couples are: \n");
    for (int t=10;t>0;t--)
    {
        for (i=0; i<numcouples; i++)
        {
            c = couples[i];
            c.bf.gift(gifts,bw);
            //c.gf.setHappiness();
            //System.out.println(c.gf +"    "+c.gf.happ);
        }
        Arrays.sort(couples,0,numcouples,coupleByHapp);
        for (i=0; i<k; i++)
        {
            c = couples[i];
            c.gf.breakup();
            c.bf.breakup();
            System.out.println(c.gf.name+" and "+c.bf.name+" broke up. ");
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write(TS+" "+c.gf.name+" and "+c.bf.name+" broke up. ");
            bw.newLine();
        }
        
        for (i=0, j=numcouples-1; i<k; i++)
        {
            c = couples[i];
            g = c.gf;
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
                bw.newLine();
                c.bf=b;
            }
            else
            {
                couples[i] = couples[j];
                couples[i] = null;
                j--;
                numcouples--;
            }
        }
        
    }
        /*System.out.println();
        
        for (i=0; i<numcouples; i++)
            System.out.println(couples[i]);
        */
        
        if (bw != null)bw.close();
        if (fw != null)fw.close();
    
    }
}
