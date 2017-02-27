/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mac
 */
public class InputCreator
{
    static FileWriter fw;
    static PrintWriter pw;
    static BufferedWriter bw;
    static Random r=new Random();
    static File f;
    
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
    
    static void gifts() throws IOException
    {
        fw = new FileWriter("gifts.txt");
        bw = new BufferedWriter(fw);
        int count = 20;
        int t1,t2,t3,t4;
        
        for (int i=0; i<count; i++)
        {
            t1= i+1;
            t2= r.nextInt(20);
            //System.out.print("yyyyyyyyyyyyy\n");
            bw.write(t1+" "+t2);
            //System.out.println(t1+" "+t2);
            bw.newLine();
        }
        for (int i=0; i<count; i++)
        {
            t1= i+1;
            t2= r.nextInt(20);
            t3= i+1;
            t4= i+1;
            bw.write(t1+" "+t2+" "+t3+" "+t4);
            bw.newLine();
        }
        //System.out.print("yyyyyyyyyyyyy\n");
        for (int i=0; i<count; i++)
        {
            t1= i+1;
            t2= r.nextInt(20);
            t3= i+1;
            t4= i+1;
            bw.write(t1+" "+t2+" "+t3+" "+t4);
            bw.newLine();
        }

    }
    
    static void girls() throws IOException
    {
        fw = new FileWriter("girls.txt");
        bw = new BufferedWriter(fw);
        int count=12;
        int t1,t2,t3,t4,t5,i,j;
        String temp,temp2;
        String randname="qwertyuiopasdfghjklzxcvbnmqwer";
        for (i=0,j=0; i<count; i++, j++)
        {
            j=j%3;
            t1 = j;                             //type
            temp = randname.substring(i,i+5);
            t2 = r.nextInt(9)+1;                //attr
            t3 = r.nextInt(450)+50;             //maintenance cost E [50,500]
            t4 = r.nextInt(100)+100;            //iq
            t5 = r.nextInt(3);                  //choice of boyfriend
            temp2 = t1+" "+temp+" "+t2+" "+t3+" "+t4+" "+t5;
            //System.out.println(temp2);
            bw.write(temp2);
            bw.newLine();
        }
        //fw.close();
        //bw.close();
    }
    
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
            t3 = r.nextInt(3)-1+t2;                     //attrreq
            t4 = r.nextInt(450)+50;                     //budget
            t5 = r.nextInt(100)+100;                    //iq
            bw.write(t1+" "+temp+" "+t2+" "+t3+" "+t4+" "+t5);
            bw.newLine();
        }
        //fw.close();
        //bw.close();
    }
}
