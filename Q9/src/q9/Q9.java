/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Megha
 */
public class Q9 
{
    public static ArrayList<Boy> boys = new ArrayList<>();
    public static ArrayList<Girl> girls = new ArrayList<>();
    public static ArrayList<Couple> couples = new ArrayList<>();
    public static ArrayList<Gift> gifts = new ArrayList<>();
    public static ArrayList<Gift> giftsss = new ArrayList <>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // TODO code application logic here
        
        InputHandler input = new InputHandler();
        input.boycreator(boys);
        input.girlcreator(girls);
        input.giftcreator(gifts);
        Boy b=null;
        int i,j=0;
        //Girl g=null;
        //Couple c=null;
        Comparator<Boy> compareByAttr= Comparator.comparingInt(Boy::getNegAttr);
        Comparator<Boy> compareByBudget= Comparator.comparingInt(Boy::getNegBudget);
        Comparator<Boy> compareByIq= Comparator.comparingInt(Boy::getNegIq);
        
        Comparator<Gift> compareByPrice= Comparator.comparingInt(Gift::getPrice);
        Comparator<Gift> compareByValue= Comparator.comparingInt(Gift::getValue);
        
//Gift g;
                
        FileWriter fw = new FileWriter("log.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int k = 5;
        for (Girl g: girls)
        {
            switch(g.choice)
            {
                case 0:
                    b = g.choose (boys,compareByAttr,compareByBudget);
                    break;
                case 1:
                    b = g.choose (boys,compareByBudget,compareByIq);
                    break;
                case 2:
                    b = g.choose (boys,compareByIq,compareByAttr);
                    break;
            }
            if (b!=null)
            {
                System.out.println(g.name+" got committed to "+b.name);
                Timestamp TS = new Timestamp(System.currentTimeMillis());
                bw.write(TS+" "+g.name+" got committed to "+b.name);
                bw.newLine();
                couples.add(new Couple(g,b));
                boys.remove(b);
                //couples[j++] = new Couple(g,b);
            }
            else
            {
                System.out.println(g.name+ " did not find anyone");
                //bw.write("girl index " +i+ " did not find anyone");
            }
            //bw.newLine();
        }
        
        Collections.sort(gifts,compareByPrice); 
        for (Couple c:couples)
        {
            giftsss.addAll(gifts);
            //Collections.copy(giftsss,gifts);
            c.bf.gift(giftsss,compareByPrice,compareByValue,bw);
        }
        
        Comparator<Couple> coupleByHapp = Comparator.comparingDouble(Couple::getHapp);
        Comparator<Couple> coupleByComp = Comparator.comparingInt(Couple::getComp);
        
        //int k;
        try
        {
            k = Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            k = 5;
        }
        if (k>couples.size()) 
        {
            System.out.println("k is more than number of couples");
            return;
        }
        Collections.sort(couples,coupleByHapp);
        Couple c;
        System.out.println("\n"+k+" happiest couples are: \n");
        j = couples.size();
        for (i=j-1; i>=j-k; i--)
        {
            c = couples.get(i);
            System.out.println(c.gf.name+" and "+c.bf.name+" with happiness "+c.getHapp());
        }
        
        System.out.println();
        
        System.out.println(k+" most compatible couples are: \n");
        Collections.sort(couples,coupleByComp);
        for (i=j-1; i>=j-k; i--)
        {
            c = couples.get(i);
            System.out.println(c.gf.name+" and "+c.bf.name+" with compatibility "+c.getComp());
        }
        
        if (bw != null)bw.close();
        if (fw != null)fw.close();
    
    }
}
