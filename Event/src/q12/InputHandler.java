/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * returns data structures from input files
 * @author Mac
 */
public class InputHandler 
{
    int t1,t2,t3,t4,t5,t6,t7,count,i;
        String temp, str;
        Scanner sc;
        File in;
        Gift gifts[] = new Gift[60];
        Girl girls[];
        Boy boys[];
        
        void giftcreator (ArrayList<Gift> gifts) throws FileNotFoundException
        {
            in = new File("gifts.txt");
            sc = new Scanner(in);
            Gift g;
            for (i=0; i<20; i++)
            {
                t1=sc.nextInt();
                t2=sc.nextInt();
                g = new Gift(t1,t2,0,0,0,0,'e');
                gifts.add(g);
            }
            for (i=20; i<40; i++)
            {
                t1=sc.nextInt();
                t2=sc.nextInt();
                t3=sc.nextInt();
                t4=sc.nextInt();
                g = new Gift(t1,t2,t3,t4,0,0,'l');
                gifts.add(g);
            }
            for (i=40; i<60; i++)
            {
                t1=sc.nextInt();
                t2=sc.nextInt();
                t3=sc.nextInt();
                t4=sc.nextInt();
                g = new Gift(t1,t2,0,0,t3,t4,'u');
                gifts.add(g);
            }
            //return gifts;
        }
        
        ArrayList<Girl> girlcreator (ArrayList<Girl> girls) throws FileNotFoundException
        {
            in = new File("girls.txt");
            sc = new Scanner(in);
            count = 12;
            Girl g=null;
            //girls = new Girl[12];                     // first one third are type 0, next 1, next 2
            for (i=0; i<count; i++)
            {
                t1=sc.nextInt();
                temp=sc.next();
                t2=sc.nextInt();
                t3=sc.nextInt();
                t4=sc.nextInt();
                t5=sc.nextInt();
                switch(t1)
                {
                    case 0:
                        //choosy
                        g = new Choosy(temp,t2,t3,t4,t5);
                        break;
                    case 1:
                        //normal
                        g = new Normal(temp,t2,t3,t4,t5);
                        break;
                    case 2:
                        //Desperate
                        g = new Desperate(temp,t2,t3,t4,t5);
                        break;
                }
                girls.add(g);
            }
            return girls;
        }
        
        ArrayList<Boy> boycreator (ArrayList<Boy> boys) throws FileNotFoundException
        {
            in = new File("boys.txt");
            sc = new Scanner(in);
            count=50;
            Boy b=null;
            //boys = new Boy[50];
            for (i=0; i<count; i++)
            {
                t1=sc.nextInt();    //type of boy
                temp=sc.next();     //name
                t2=sc.nextInt();    //attractiveness
                t3=sc.nextInt();    //required attractivenes
                t4=sc.nextInt();    //budget
                t5=sc.nextInt();    //intelligence
                switch(t1)
                {
                    case 0:
                        //miser
                        b = new Miser(temp,t2,t3,t4,t5);
                        break;
                    case 1:
                        //generous
                        b = new Generous(temp,t2,t3,t4,t5);
                        break;
                    case 2:
                        //geek
                        b = new Geek(temp,t2,t3,t4,t5);
                        break;
                }
                boys.add(b);
            }
            return boys;
        }
}
