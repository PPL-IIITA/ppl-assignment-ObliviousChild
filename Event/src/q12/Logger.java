/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Performs logging of all events
 * @author Mac
 */
public class Logger 
{
    static FileWriter fw;
    static BufferedWriter bw;
    
    public static void configure()
    {
        try 
        {
            fw = new FileWriter("log.txt");
            bw = new BufferedWriter(fw);
        }
        catch (IOException ex) {}
    }
    
    public static void commit (String a, String b)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :COMMITMENT\t "+a+" and "+b);
            bw.newLine();
        } 
        catch (IOException ex) {}
    }
    
    public static void breakup (String a, String b)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :BREAKUP\t "+a+" and "+b);
            bw.newLine();
        } 
        catch (IOException ex) {}
    }

    public static void gifting (String a, String b, int price, double happ)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :GIFTING\t "+a+" gifted "+b+" gifts of total price "+price+". Couple is happy "+happ);
            bw.newLine();
        } 
        catch (IOException ex) {}
    }
    
    public static void exception (String s)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :EXCEPTION\t "+s );
            bw.newLine();
        } 
        catch (IOException ex) {}
    }
    
    public static void newgirl (Girl g)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :NEWGIRL\t "+g.name );
            bw.newLine();
        } 
        catch (IOException ex) {}
    }
    
    public static void newboy (Boy b)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :NEWBOY\t "+b );
            bw.newLine();
        } 
        catch (IOException ex) {}
    }
    
    public static void close()
    {
        try 
        {
            bw.close();
            fw.close();
        } 
        catch (IOException ex) {}
    }

    static void proposalAccepted(String b, String g) 
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :PROPOSAL_ACCEPTED\t "+b + " proposed to "+g );
            System.out.println(g +" accepted proposal of "+b);
            bw.newLine();
        } 
        catch (IOException ex) {}
    }

    static void proposalRejected(String b, String g) 
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :PROPOSAL_REJECTED\t "+b + " proposed to "+g );
            System.out.println(g +" rejected proposal of "+b);
            bw.newLine();
        } 
        catch (IOException ex) {}
    }

    static void newMonth() 
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :NEXT_MONTH\t ");
            bw.newLine();
            bw.newLine();
        } 
        catch (IOException ex) {}
    }
}

