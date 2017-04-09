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
public class Q5 
{
    static Boy boys_attr[];
    static Boy boys_rich[];
    static Boy boys_iq[];
    static Girl girls_mcost[];
    static Girl girls_attr[];
    static Gift gifts[];
    static Couple couples[] = new Couple[12];
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // TODO code application logic here
        //Q3.main(args);
        if (args.length>0 && args[0].equals("1"))
            Q1.main(args);
            
        InputHandler input = new InputHandler();
        boys_attr = input.boycreator();                 //by attr
        boys_rich = boys_attr.clone();                 //by budget
        boys_iq = boys_attr.clone();                 //by iq
        girls_mcost = input.girlcreator();
        girls_attr = girls_mcost.clone();
        gifts = input.giftcreator();
        Boy b=null;
        int i,j=0;
        Girl g=null;
        Couple c=null;
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
        Comparator<Girl> compareGirlByAttr= Comparator.comparingInt(Girl::getNegAttr);
        Comparator<Girl> compareGirlByMcost= Comparator.comparingInt(Girl::getMcost);
        
        Arrays.sort(boys_attr,compareByAttr);
        Arrays.sort(boys_rich,compareByBudget);
        Arrays.sort(boys_iq,compareByIq);
        Arrays.sort(girls_mcost,compareGirlByMcost);
        Arrays.sort(girls_attr,compareGirlByAttr);
        
        //Arrays.sort(myTypes, (a,b) -> a.name.compareTo(b.name));
        //Comparator<String> = Comparator.comparing(String::length);
        //Comparator<Integer> byString = Comparator.comparing(String::valueOf);
        
        FileWriter fw = new FileWriter("log.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (i=0; i<50; i++)
        {
            if (i<12)
            {
            g = girls_mcost[i];
            if (g.bf!=null)
                    System.out.println(g.name+" is already taken");
            else{ switch(g.choice)
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
                System.out.println(g.name+ " did not find anyone");
                //bw.write("girl index " +i+ " did not find anyone");
            }
            bw.newLine();
            }}
            if (j==12)  break;
            b = boys_attr[i];
            if (b.gf!=null)
            {
                System.out.println(b.name+" is already taken");
                continue;
            }
            g = b.choose(girls_attr);
            if (g!=null)
            {
                System.out.println(b.name+" got committed to "+g.name);
                Timestamp TS = new Timestamp(System.currentTimeMillis());
                bw.write(TS+" "+b.name+" got committed to "+g.name);
                bw.newLine();
                couples[j++] = new Couple(g,b);
            }
            else
            {
                System.out.println(b.name+ " did not find anyone");
                //bw.write(+ " did not find anyone");
            }
            if (j==12)  break;
        }
        if (bw != null)bw.close();
        if (fw != null)fw.close();
    }
}    
    