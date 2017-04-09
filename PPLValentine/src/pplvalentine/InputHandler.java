/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
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
        
        Gift[] giftcreator() throws FileNotFoundException
        {
            in = new File("gifts.txt");
            sc = new Scanner(in);
            for (i=0; i<20; i++)
            {
                t1=sc.nextInt();
                t2=sc.nextInt();
                gifts[i] = new Essential(t1,t2);
            }
            for (i=20; i<40; i++)
            {
                t1=sc.nextInt();
                t2=sc.nextInt();
                t3=sc.nextInt();
                t4=sc.nextInt();
                gifts[i] = new Luxury(t1,t2,t3,t4);
            }
            for (i=40; i<60; i++)
            {
                t1=sc.nextInt();
                t2=sc.nextInt();
                t3=sc.nextInt();
                t4=sc.nextInt();
                gifts[i] = new Utility(t1,t2,t3,t4);
            }
            return gifts;
        }
        
        Girl[] girlcreator() throws FileNotFoundException
        {
            in = new File("girls.txt");
            sc = new Scanner(in);
            count = 12;
            girls = new Girl[12];                     // first one third are type 0, next 1, next 2
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
                        girls[i] = new Choosy(temp,t2,t3,t4,t5);
                        break;
                    case 1:
                        //normal
                        girls[i] = new Normal(temp,t2,t3,t4,t5);
                        break;
                    case 2:
                        //Desperate
                        girls[i] = new Desperate(temp,t2,t3,t4,t5);
                        break;
                }
            }
            return girls;
        }
        
        Boy[] boycreator() throws FileNotFoundException
        {
            in = new File("boys.txt");
            sc = new Scanner(in);
            count=50;
            boys = new Boy[50];
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
                        boys[i] = new Miser(temp,t2,t3,t4,t5);
                        break;
                    case 1:
                        //generous
                        boys[i] = new Generous(temp,t2,t3,t4,t5);
                        break;
                    case 2:
                        //geek
                        boys[i] = new Geek(temp,t2,t3,t4,t5);
                        break;
                }
            }
            return boys;
        }
}
