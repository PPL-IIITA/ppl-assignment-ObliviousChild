/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplvalentine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 *
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

    public static void gifting (String a, String b, int price, int e, int l, int u)
    {
        try 
        {
            Timestamp TS = new Timestamp(System.currentTimeMillis());
            bw.write( TS+" :GIFTING\t "+b+" gifted "+a+" gifts of total price "+price+". Essential: "+e+", Luxury: "+l+", Utility: "+u);
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
            bw.write( TS+" :NEWGIRL\t "+g );
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
}

