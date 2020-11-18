package CustomerPackage;
import java.util.*;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class phonenumberException extends Exception
{
	public phonenumberException(String m)
{
super(m);
}
}

class passwordException extends Exception
{
	public passwordException(String m)
{
super(m);
}
}
class customer 
{

	String customerName;
	long customerPhoneNo;
	String customerEmail;
	String customerAddress;
	long customerCredits;
	String customerPassword;
	long customerTotalBill;
	Vector<product> prevOrders=new Vector<product>();	
	Vector<product> customerCart = new Vector<product>();
	Vector<product> customerWishList = new Vector<product>();
	
	
	customer(String customerName,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,String customerPassword, long customerTotalBill;)
	{
	
		this.customerPhoneNo=customerPhoneNo;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.customerCredits=customerCredits;
		this.customerEmail=customerEmail;
		this.customerPassword=customerPassword;
		this.customerTotalBill=customerTotalBill;
	}
	customer()
	{
		
		customerEmail="";
		customerName="";
		customerPhoneNo=0;
		customerAddress="";
		customerCredits=0;
		customerPassword="";
		customerTotalBill=0;
		customerCredits=((long)(customerTotalBill*0.01));
	}
	
	public static Vector<customer> cust=new Vector<customer>();
	
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args)
	{
		customMenu();
	}
	public static void customMenu() 
	{
		customer c=new customer("",0,0,"","","",0);
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
		s.nextLine();
		System.out.println("Enter Your Details:\n");
		
		System.out.println("Email ID:");
		String email=s.nextLine();

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
		s.nextLine();
		long phone=0;
		String pass="";
		String regexStr = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"; 
		Pattern pattern = Pattern.compile(regexStr); 
		System.out.println("Name:");
		String name=s.nextLine();
		System.out.println("Address:");
		String add=s.nextLine();
		boolean validity=false;
		while(!validity){
		try{		
		System.out.println("Phone Number:");
		phone=s.nextLong();
		if(phone<1000000000)throw new phonenumberException("Please enter a valid phone number(10 digits)");
		else validity=true;

		}
		catch(phonenumberException e)
		{
			System.out.println(e);			
		}
		
		}
		validity=false;
		s.nextLine();
		while(!validity){
		try{
		System.out.println("Password(valid password should contain min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number):");
		pass=s.nextLine();
		Matcher matcher = pattern.matcher(pass);
		if(!matcher.matches())throw new passwordException("Please enter a valid password(min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number)");
		else validity=true;
		}
		catch(passwordException e)
		{
			System.out.println(e);			
		}
		}
		
		customer c=new customer(name,phone,0,add,email,pass,0);
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
}
	
	
