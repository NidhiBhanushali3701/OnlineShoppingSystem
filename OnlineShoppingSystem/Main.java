package OnlineShoppingSystem;
import java.util.*;
import java.sql.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

public class Main {
    Scanner scanner,ob;
    File file;
    FileWriter fileWriter;
    FileReader fileReader;
	String pathOfCD="C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\customerData.csv";

    public static void main(String a[])
    {
        /*deliveredThread d = new deliveredThread(0);
        try
        {
            d.start();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        d.start();
        */
        Main m=new Main();
        //m.login();
        m.signup();
    }
    public void login()
	{
        ob = new Scanner(System.in);
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID:");
		String email=ob.next();
		System.out.println("Password:");
		String pass=ob.next();

		try
		{
			file= new File(pathOfCD);
			scanner = new Scanner(file);

			while(scanner.hasNext())
			{
                String customerDetails[] = scanner.nextLine().split(",");
                /*System.out.println(customerDetails.length+" length");
                for(int i=0;i<customerDetails.length;i++)
                {
                    System.out.print(customerDetails[i]+" ");
                }
                System.out.println("");
                */
				if(email.equalsIgnoreCase(customerDetails[4]) && pass.equals(customerDetails[7]))
				{
                    System.out.println("SUCCESSFULL!!");
                    break;
                }
                else{
                    System.out.println("no re");
                }
			}
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

    }
    public void signup()
    {
        String Name="ABC XYZ",address="P Q R";
        long phoneNo=984726382,credits=0;
        ob = new Scanner(System.in);
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID:");
		String email=ob.next();
		System.out.println("Password:");
        String pass=ob.next();
        int accFound=0;
        int i=0;
        try
		{
			file= new File(pathOfCD);
			scanner = new Scanner(file);

			while(scanner.hasNext())
			{
                String customerDetails[] = scanner.nextLine().split(",");
                /*System.out.println(customerDetails.length+" length");
                for(int i=0;i<customerDetails.length;i++)
                {
                    System.out.print(customerDetails[i]+" ");
                }
                System.out.println("");
                */
				if(email.equalsIgnoreCase(customerDetails[4]))
				{
                    System.out.println(" ACCOUNT EXISTS !!");
                    accFound=1;
                    break;
                }
                i++;
            }
            if(accFound==1)
            {
                login();
            }
            else
            {
                fileWriter = new FileWriter(pathOfCD,true);
                fileWriter.write("\n"+Integer.toString(i)+","+Integer.toString(i)+","+ Name+Long.toString(phoneNo)+","+email+","+address+","+credits+","+pass+","+"\n");
                fileWriter.close();
            }
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    }
}
