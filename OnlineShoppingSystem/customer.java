package CustomerPackage;
import java.util.*;
import java.util.Vector;
class customer 
{

	String customerName;
	int customerPhoneNo;
	String customerEmail;
	String customerAddress;
	long customerCredits;
	String customerID;	
	String customerPassword;
	String prevOrders;
	
	Vector<product> customerCart = new Vector<product>();
	Vector<product> CustomerWishList = new Vector<product>();
	
	
	customer(String customerName,int customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,String customerPassword, String prevOrders)
	{
		this.customerPhoneNo=customerPhoneNo;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.customerCredits=customerCredits;
		this.customerEmail=customerEmail;
		this.customerPassword=customerPassword;
		this.prevOrders=prevOrders;
	}
	customer()
	{
		customerID="";
		customerEmail="";
		customerName="";
		customerPhoneNo=0;
		customerAddress="";
		customerCredits=0;
		customerPassword="";
		prevOrders="";
	}
	
	public static Vector<customer> cust=new Vector<customer>();
	
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args)
	{
		customMenu();
	}
	public static void customMenu() 
	{
		customer c=new customer("",0,0,"","","","No Orders yet");
		cust.add(c);

		int op=0;
		
		
		while(op!=3)
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
				System.exit(0);
				break;
				default:
				System.out.println("Option not valid");
			}
		}
		s.close();
	}

	public static void signUp()
	{
		
		System.out.println("Enter Your Details:\n");
		
		System.out.println("Email ID:");
		String email=s.next();

		int accountExists=check(email,"");
		int op=0;
		if(accountExists!=0)
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
		int phone=s.nextInt();
		System.out.println("Password:");
		String pass=s.next();
		customer c=new customer(name,phone,0,add,email,pass, "No Orders yet");
		cust.add(c);
		System.out.println("Account created successfully\n");//go to store menu
		accountSettings.settingsmenu(cust.size()-1);
	}

	public static void logIn()
	{
		int op=0;
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID:");
		String email=s.next();
		System.out.println("Password:");
		String pass=s.next();
		int validInfo=check(email,pass);
		if(validInfo!=0)
		{
			System.out.println("You are logged in");
			accountSettings.settingsmenu(validInfo);
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

	public static int check(String e,String n)
	{
		int b;
		b=1;
		if(cust.size()==0)
		b=0;
		for(int i=0;i<cust.size();i++)
		{
			
			
			if(e.equals(cust.get(i).customerEmail))
			{			
				
				if(n!="")
				{
					if(n.equals(cust.get(i).customerPassword))
					{
						b=i;						
						return b;
					}
					else
					{
						b=0;						
					}					
				}
				else
				{
					b=i;					
					return b;
				}
			}
			else
			{
				b=0;				
			}
		}
		
		return b;
	}
	
	
