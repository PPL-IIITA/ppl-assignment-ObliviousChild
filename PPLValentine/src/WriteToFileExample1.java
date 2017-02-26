import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteToFileExample1 {

    
	static Random r=new Random();
    
	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

	                
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
            System.out.println(temp2);
            bw.write(temp2);
            bw.newLine();
        }
            
            
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
        
    static void girls() throws IOException
    {
        FileWriter fw = new FileWriter("girlsfunc.txt");
        BufferedWriter bw = new BufferedWriter(fw);
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
            System.out.println(temp2);
            bw.write(temp2);
            bw.newLine();
        }
        //fw.close();
        //bw.close();
    }
    

}