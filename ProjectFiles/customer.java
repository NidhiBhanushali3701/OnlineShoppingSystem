import java.util.*;
import java.util.Vector;
public class customer 
{

	String customerName;
	long customerPhoneNo;
	String customerEmail;
	String customerAddress;
	long customerCredits;
	long customerID;
	int customerSize;
  	char customerGender;
	String customerPassword;
	String prevOrders;
	
	customer(String customerName,long customerID,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,int customerSize,char customerGender,String customerPassword, String prevOrders)
	{
		this.customerID=customerID;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.customerCredits=customerCredits;
		this.customerEmail=customerEmail;
		this.customerSize=customerSize;
		this.customerGender=customerGender;
		this.customerPassword=customerPassword;
		this.prevOrders=prevOrders;
	}
	customer()
	{
		customerID=0;
		customerEmail="";
		customerName="";
		customerAddress="";
		customerCredits=0;
		customerSize=0;
		customerGender='\0';
		customerPassword="";
		prevOrders="";
	}
	
	public static Vector<customer> cust=new Vector<customer>();
	static Scanner s=new Scanner(System.in);
	public static void main(String args[]) 
	{
		

		int op=0;
		
		
		loop1: while(op!=3)
		{
			
			System.out.println("MENU\n1)Sign Up\n2)Log In\n3)Exit\n");
			op=s.nextInt();

			switch(op)
			{
				case 1:
				signUp();
				break;
				case 2:
				logIn();
				//break loop1;
				case 3:
				break;
				default:
				System.out.println("Option not valid");
			}
		}
	}

	public static void signUp()
	{
		
		System.out.println("Enter Your Details:\n");
		
		System.out.println("Email ID:");
		String email=s.next();

		boolean accountExists=check(email,"");
		int op=0;
		if(accountExists)
		{
			
				System.out.println("You already have an account with this email Id\n1)Log in?\n2)Create new account with different Email ID\n");
				op=s.nextInt();
				switch(op)
				{
					case 1:logIn();
					break;
					case 2:signUp();
					break;
					default:
					System.out.println("Please enter a valid option");
				}
					
		}
		else
		{
			create(email);
		}
	}
	public static void create(String email)
	{
		
		
		System.out.println("Name:");
		String name=s.next();
		System.out.println("Address:");
		String add=s.next();
		System.out.println("Phone Number:");
		long phone=s.nextLong();
		System.out.println("Password:");
		String pass=s.next();
		customer c=new customer(name,0,phone,0,add,email,0,'N',pass, "No Orders yet");
		cust.add(c);
		System.out.println("Account created successfully\n");//go to store menu
	}

	public static void logIn()
	{
		int op=0;
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID:");
		String email=s.next();
		System.out.println("Password:");
		String pass=s.next();
		boolean validInfo=check(email,pass);
		if(validInfo)
		{
			System.out.println("You are logged in");
			//store menu
		}
		else
		{
			
			while(op!=1 || op!=2)
			{
				System.out.println("Wrong email ID/Password\n1)Try Again\n2)Sign Up\n");
				op=s.nextInt();
				switch(op)
				{
					case 1:logIn();
					break;
					case 2:
					signUp();
					break;
					default:
					System.out.println("Please enter a valid option");
				}
			}
		}
	}

	public static boolean check(String e,String n)
	{
		boolean b;
		b=true;
		if(cust.size()==0)
		b=false;
		for(int i=0;i<cust.size();i++)
		{
			
			
			if(e.equals(cust.get(i).customerEmail))
			{			
				
				if(n!="")
				{
					if(n.equals(cust.get(i).customerPassword))
					{
						b=true;						
						return b;
					}
					else
					{
						b=false;						
					}					
				}
				else
				{
					b=true;					
					return b;
				}
			}
			else
			{
				b=false;				
			}
		}
		
		return b;
	}
}
