/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * generates random input files
 * @author Mac
 */
public class InputCreator
{
    static FileWriter fw;
    static BufferedWriter bw;
    static Random r=new Random();
    
    public static void main(String[] args)
    {
        try 
        {
            boys();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
	} 
        finally 
        {
            try 
            {
                if (bw != null)bw.close();
                if (fw != null)fw.close();
            } catch (IOException ex) 
            {
                ex.printStackTrace();
            }
	}
        try 
        {
            gifts();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
	} 
        finally 
        {
            try 
            {
                if (bw != null)bw.close();
                if (fw != null)fw.close();
            } catch (IOException ex) 
            {
                ex.printStackTrace();
            }
	}
        try 
        {
            girls();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
	} 
        finally 
        {
            try 
            {
                if (bw != null)bw.close();
                if (fw != null)fw.close();
            } catch (IOException ex) 
            {
                ex.printStackTrace();
            }
	}
    }
    
    /**
     * * 60 gifts
     * 20 of each type
     * @throws IOException 
     */
    static void gifts() throws IOException
    {
        fw = new FileWriter("gifts.txt");
        bw = new BufferedWriter(fw);
        int count = 20;
        int t1,t2,t3,t4;
        
        for (int i=0; i<count; i++)                         //first 20 essential gifts
        {
            t1= i+1;
            t2= r.nextInt(20);
            bw.write(t1+" "+t2);
            bw.newLine();
        }
        for (int i=0; i<count; i++)                         //next 20 luxury gifts
        {
            t1= i+1;
            t2= r.nextInt(20);
            t3= i+1;
            t4= i+1;
            bw.write(t1+" "+t2+" "+t3+" "+t4);
            bw.newLine();
        }
        for (int i=0; i<count; i++)                         //last 20 utility gifts
        {
            t1= i+1;
            t2= r.nextInt(20);
            t3= i+1;
            t4= i+1;
            bw.write(t1+" "+t2+" "+t3+" "+t4);
            bw.newLine();
        }

    }
    
    /**
     * 12 girls
     * unique random string names in CAPITALS
     * 4 of each type
     * maintenance cost between 50 to 450
     * iq between 100 to 200
     * attractiveness between 1 to 9
     * @throws IOException 
     */
    static void girls() throws IOException
    {
        fw = new FileWriter("girls.txt");
        bw = new BufferedWriter(fw);
        int count=12;
        char type;
        char types[] = {'c','n','d'};
        int t1,t2,t3,t4,t5,i,j;
        String temp,temp2;
        String randname="QWERTYUIOPASDFGHJKLZXCVBNMQWER";
        for (i=0,j=0; i<count; i++, j++)
        {
            j=j%3;
            type = types[j];                             //type
            temp = randname.substring(i,i+5);
            t2 = r.nextInt(9)+1;                //attr
            t3 = r.nextInt(450)+50;             //maintenance cost E [50,500]
            t4 = r.nextInt(100)+100;            //iq
            t5 = r.nextInt(3);                  //choice of boyfriend
            temp2 = j+" "+temp+" "+t2+" "+t3+" "+t4+" "+t5;
            //System.out.println(temp2);
            bw.write(temp2);
            bw.newLine();
        }
        //fw.close();
        //bw.close();
    }
    
    /**
     * 50 boys
     * unique random string names
     * budget between 50 to 450
     * iq between 100 to 200
     * attractiveness between 1 to 9
     * attractiveness required <= own attractiveness + 2
     * @throws IOException 
     */
    static void boys() throws IOException
    {
        fw = new FileWriter("boys.txt");
        bw = new BufferedWriter(fw);
        int count=50;
        int t1,t2,t3,t4,t5,i,j,k;
        String temp;
        String randname="abcdefghijklmnopqrstuvwxyzqwertyuiopasdfghjklzxvbnmqwer";
        for (i=0,j=0; i<count; i++, j++)
        {
            j=j%3;
            t1 = j;                                     //type
            temp = randname.substring(i,i+5);
            t2 = r.nextInt(9)+1;                        //attr
            t3 = r.nextInt(t2+3)%10;                    //attrreq
            t4 = r.nextInt(450)+50;                     //budget
            t5 = r.nextInt(100)+100;                    //iq
            bw.write(t1+" "+temp+" "+t2+" "+t3+" "+t4+" "+t5);
            bw.newLine();
        }
        //fw.close();
        //bw.close();
    }
}
