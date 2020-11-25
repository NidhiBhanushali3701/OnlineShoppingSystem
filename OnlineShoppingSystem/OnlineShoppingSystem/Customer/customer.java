package OnlineShoppingSystem.Customer;

import OnlineShoppingSystem.Product.*;
import OnlineShoppingSystem.TnE.*;
import java.util.*;
import java.sql.*;
import java.util.regex.*;
import java.io.*;

public class customer 
{
	String customerName;
	long customerPhoneNo;
	String customerEmail;
	String customerAddress;
	public long customerCredits;
	String customerPassword;
	public long customerTotalBill;
	public int customerDeliveryStatus;
	long customerID;
	deliveredThread delivered_thread ; //= new deliveredThread(0);
	public Vector<product> prevOrders=new Vector<product>();	
	public Vector<product> customerOrders=new Vector<product>();
	public Vector<product> customerCart = new Vector<product>();
	public Vector<product> customerWishList = new Vector<product>();
	Vector<customer> cust=new Vector<customer>();
	
	static Scanner s=new Scanner(System.in);
	Scanner scanner;
	File file;
	FileWriter fileWriter;
    FileReader fileReader;
	Console console = System.console();
	String pathOfCD="C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\Customer\\customerData.csv";
	public Object buyProducts;
	customer(String customerName,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,String customerPassword,long customerID,long customerTotalBill)
	{
		this.customerPhoneNo=customerPhoneNo;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.customerCredits=customerCredits;
		this.customerEmail=customerEmail;
		this.customerPassword=customerPassword;
		this.customerTotalBill=customerTotalBill;
		this.customerID=customerID;
		this.delivered_thread = new deliveredThread(0);
	}
	public customer()
	{
		customerEmail="";
		customerName="";
		customerPhoneNo=0;
		customerAddress="";
		customerCredits=0;
		customerPassword="";
		customerTotalBill=0;
		customerCredits=((long)(customerTotalBill*0.01));
		customerDeliveryStatus=0;
		customerID=0;
	}
	
	public static void main(String args[]) 
	{
		customer C = new customer();
		C.customMenu();
    }
	
	public void logIn()
	{
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID : ");
		String email=s.next();
		System.out.println("Password : ");
		String password;
		//char[] pass = console.readPassword("Password : ");
		password=s.next();
		int ch=-1;
		int logged = 0;
		String customerDetails[] = new String[8];
		try
		{
			file= new File(pathOfCD);
			scanner = new Scanner(file);

			while(scanner.hasNextLine())
			{
               	customerDetails = scanner.nextLine().split(",");
                /*System.out.println(customerDetails.length+" length");
                for(int i=0;i<customerDetails.length;i++)
                {
                    System.out.print(customerDetails[i]+" ");
                }
                System.out.println("");
				*/
				//System.out.println("-\t-\t-\t- EMAIL = " + email+" , "+ customerDetails[4] + "-\t-\t-\t- EMAIL = "+pass+" , "+customerDetails[7]);
				if(email.equalsIgnoreCase(customerDetails[4]) && password.toString().equals(customerDetails[7]))
				{
					System.out.println("SUCCESSFULL LOGIN !!");
					logged = 1;
					break;
					/*
					delivered_thread = new deliveredThread(0);
					customer loggedInCustomer = new customer(customerDetails[2],Long.parseLong(customerDetails[3]),Long.parseLong(customerDetails[6]),customerDetails[5],customerDetails[4],customerDetails[7],0);
					//delivered_thread.thisCustomer=new customer(customerDetails[2],Long.parseLong(customerDetails[3]),Long.parseLong(customerDetails[6]),customerDetails[5],customerDetails[4],customerDetails[7],0);
					delivered_thread.thisCustomer = loggedInCustomer;
					//accountSettings aS= new accountSettings(aS, email, pass);
					customerDashBoard cDB = new customerDashBoard(loggedInCustomer);
					cDB.displayCustomerDashBoard(loggedInCustomer);
					//aS.settingsmenu(validInfo);
					//store menu
					//SrNo0,ID1,Name2,Phone No3,Email4,Address5,Credits6,Password7,
					*/
				}
				
			}
			if(logged==1)
				{
					delivered_thread = new deliveredThread(0);
					customer loggedInCustomer = new customer(customerDetails[2],Long.parseLong(customerDetails[3]),Long.parseLong(customerDetails[6]),customerDetails[5],customerDetails[4],customerDetails[7],Long.parseLong(customerDetails[1]),0);
					//delivered_thread.thisCustomer=new customer(customerDetails[2],Long.parseLong(customerDetails[3]),Long.parseLong(customerDetails[6]),customerDetails[5],customerDetails[4],customerDetails[7],0);
					delivered_thread.thisCustomer = loggedInCustomer;
					//accountSettings aS= new accountSettings(aS, email, pass);
					customerDashBoard cDB = new customerDashBoard(loggedInCustomer);
					cDB.displayCustomerDashBoard(loggedInCustomer);
					//aS.settingsmenu(validInfo);
					//store menu
					//SrNo0,ID1,Name2,Phone No3,Email4,Address5,Credits6,Password7,
				}
				else
				{
					while(ch!=1 || ch!=2 || ch!=0)
					{
						System.out.println(" Wrong < email ID / Password > \n1) Try Again\n2) Sign Up\n0) exit".toUpperCase());
						ch=s.nextInt();
						switch(ch)
						{
							case 1:
								logIn();
							break;
							case 2:
								signUp();
							break;
							case 0:
								System.out.println("Exiting...");
								System.exit(0);
							break;
							default:
								System.out.println("Please enter a valid option".toUpperCase());
						}
					}
				}
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void signUp()
    {
        s = new Scanner(System.in);
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID:");
		String email=s.next();
		//System.out.println("Password:");
		//pass=s.next();
		String customerDetails[] = new String[8];
        int accFound=0;
        int i=0;
        try
		{
			file= new File(pathOfCD);
			scanner = new Scanner(file);

			while(scanner.hasNextLine())
			{
                customerDetails = scanner.nextLine().split(",");
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
                System.out.println("\n1) Log in?\n2) Create new account with different Email ID\n0) EXIT\n".toUpperCase());
				//op=s.nextInt();
				switch(s.nextInt())
				{
					case 1:
					logIn();
					break;
					case 2:
					signUp();
					break;
					case 0:
					break;
					default:
					System.out.println("Please enter a valid option");
				}
            }
            else
            {
				customer thisCustomer = create(email,i);
                fileWriter = new FileWriter(pathOfCD,true);
                fileWriter.write(Integer.toString(i)+","+Integer.toString(i)+","+ thisCustomer.customerName+","+Long.toString(thisCustomer.customerPhoneNo)+","+thisCustomer.customerEmail+","+thisCustomer.customerAddress+","+thisCustomer.customerCredits+","+thisCustomer.customerPassword+","+"\n");
				accountSettings aS= new accountSettings(thisCustomer);
				fileWriter.close();
				delivered_thread = new deliveredThread(0);
				delivered_thread.thisCustomer=thisCustomer;
				aS.displayCustomerDashBoard(thisCustomer);
				aS.settingsmenu(thisCustomer);
            }
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void customMenu() 
	{
		customer c=new customer();
		cust.add(c);

		int op=0;
		while(op!=3)
		{
			
			System.out.println("\n\tMENU\n1) Sign Up\n2) Log In\n0) Exit\n".toUpperCase());
			op=s.nextInt();

			switch(op)
			{
				case 1:
				//signUp();
				signUp();
				break;
				case 2:
				//logIn();
				logIn();
				//break loop1;
				case 0:
				System.exit(0);
				break;
				default:
				System.out.println("INVALID OPTION");
			}
		}
		s.close();
	}

	public customer create(String email,int customerNo)
	{
		s.nextLine();
		long phone=0;
		String password="";
		//char[] pass_;
		String regexStr = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"; 
		Pattern pattern = Pattern.compile(regexStr); 
		System.out.println("Name:");
		String name=s.nextLine();
		System.out.println("Address:");
		String add=s.nextLine();
		boolean validity=false;
		while(!validity)
		{
			try
			{		
				System.out.println("Phone Number:");
				phone=s.nextLong();
				if(phone<1000000000)
					throw new phonenumberException("Please enter a valid phone number(10 digits)");
				else 
					validity=true;
			}
			catch(phonenumberException e)
			{
				System.out.println(e);			
			}
		}
		validity=false;
		s.nextLine();
		while(!validity)
		{
			try
			{
				System.out.println("Password(valid password should contain min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number): ");
				//password=console.readPassword("Password(valid password should contain min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number):");
				password=s.nextLine();
				//pass=pass_.toString();
				Matcher matcher = pattern.matcher(password);
				if(!matcher.matches())
					throw new passwordException("Please enter a valid password(min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number)");
				else 
					validity=true;
			}
			catch(passwordException e)
			{
				System.out.println(e);			
			}
		}
		
		customer c=new customer(name,phone,0,add,email,password,customerNo,0);
		cust.add(c);
		return c;
		/*customer thisCustomer=c;
		System.out.println("Account created successfully\n");//go to store menu
		
		accountSettings aS= new accountSettings(thisCustomer);
		delivered_thread = new deliveredThread(0);
		delivered_thread.thisCustomer=thisCustomer;
		aS.displayCustomerDashBoard(thisCustomer);
		aS.settingsmenu(thisCustomer);
		*/
		
	}
	public void customerPayment(customer thisCustomer)
	{
		//buy()
		buyProducts buyedProd = new buyProducts(thisCustomer);
		buyedProd.buymenu(thisCustomer);

	}
}