package OnlineShoppingSystem;
import java.util.*;
import java.sql.*;
import java.util.regex.*;
import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.Product.*;
import OnlineShoppingSystem.TnE.*;
import java.io.*;

public class Main {
    Scanner scanner,ob;
    File file;
    FileWriter fileWriter;
    FileReader fileReader;
	String pathOfCD="C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\customerData.csv";

    public static void main(String a[])
    {
        customer startC = new customer();
        startC.customMenu();
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
        * //
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
                // *System.out.println(customerDetails.length+" length");
                for(int i=0;i<customerDetails.length;i++)
                {
                    System.out.print(customerDetails[i]+" ");
                }
                System.out.println("");
                * //
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
                * //
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
        */
    }
}

//here
/*
    public void checkStatus(customer thisCustomer,int flagDelivered)
    { 
        //this.flagDelivered=flagDelivered;
        if(flagDelivered!=0 || thisCustomer.customerDeliveryStatus!=0)
        {
            for(int pI=0;pI<thisCustomer.customerCart.size();pI++)
            {
                thisCustomer.prevOrders.add(thisCustomer.customerOrders.get(pI));
            }
            thisCustomer.customerOrders.clear();
        }
    }

    public void search()
    {
        int ch;
        do{
            System.out.println(" WHAT TYPE OF PRODUCT YOU WANT TO SEARCH IN ?");
            System.out.println("\t1. MEDICAL");
            System.out.println("\t2. HOME");
            System.out.println("\t3. GROOMING");
            System.out.println("\t4. GROCCERY");
            System.out.println("\t5. ELECTRONICS");
            System.out.println("\t6. CLOTHING");
            System.out.println("\t0. BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch =  ob.nextInt();
            String s;
            product searchProduct;

            switch(ch)
            {
                case 1:
                    searchProduct = new  MedicalProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 2:
                    searchProduct = new  HomeProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                    
                break;
                case 3:
                    searchProduct = new  GrommingProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 4:
                    searchProduct = new  GrocceryProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 5:
                    searchProduct = new  ElectronicProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 6:
                    searchProduct = new  ClothingProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);       //this will give the respective product type dashboard
                break;
                case 0:
                System.out.println(" GOING TO DASHBORAD ");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }
        while(ch!=0);
    }
    public void viewPreviousProducts(customer thisCustomer,int flag)
    {
        if(thisCustomer.customerDeliveryStatus!=0 || flag!=0)
        {
            for(int pI=0;pI<thisCustomer.customerCart.size();pI++)
            {
                thisCustomer.prevOrders.add(thisCustomer.customerOrders.get(pI));
            }
            thisCustomer.customerOrders.clear();
        }
        if(thisCustomer.prevOrders.size()>0)
        {
            System.out.println("\t\t >> YOUR DELIVERED PRODUCTS");
            for(product p:thisCustomer.prevOrders)
            {
                System.out.println(p.productName+"\t\t"+p.productCost);
            }
        }
        else{
            System.out.println("\t >> YOU HAVEN'T BOUGHT ANYTHING ADD & BUY BEST PRODUCT AT BEST POSSIBLE PRICES :)");
        }
        System.out.println("");
    }
*/


