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
		this.customerEmail=customerEmail;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.customerCredits=customerCredits;
		this.customerEmail=customerEmail;
		this.customerSize=customerSize;
		this.customerGender=customerGender;
		this.customerPassword=customerPassword;
		this.prevOrders=prevOrders;
	}
  
	
	public static Vector<customer> cust=new Vector<customer>();

	public static void main(String args[]) 
	{
		Scanner s=new Scanner(System.in);

		int op=0;
		int n;
		while(op!=6)
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
				break;
				case 3:
				break;
				default:
				System.out.println("Option not valid");
			}
		}
	}

	public static signUp()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your Details:\n");
		
		System.out.println("Email ID:\n");
		String email=s.nextLine();

		boolean accountExists=check(email,0);
		int op=0;
		if(accountExists)
		{
			while(op!=1 || op!=2)
			{
				System.out.println("You already have an account with this email Id\n1)Log in?\n2)Create new account with different Email ID\n");
				op=nextInt();
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
		}
		else
		{
			create(email);
		}
	}
	public static void create(String email)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your Details:\n");
		System.out.println("Name:\n");
		String name=s.nextLine();
		System.out.println("Address:\n");
		String add=s.nextLine();
		System.out.println("Phone Number:\n");
		long phone=s.nextLong();
		System.out.println("Password:\n");
		String pass=s.nextLine();
		customer c=new customer(name,0,phone,0,add,email,0,'N',pass, "No Orders yet");
		v.add(c);
		System.out.println("Account created successfully\n");//go to store menu
	}

	public static void logIn()
	{
		int op=0;
		System.out.println("Enter the following details:\n");
		System.out.println("Email ID:\n");
		String email=s.nextLine();
		System.out.println("Password:\n");
		String pass=s.nextLine();
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
				op=nextInt();
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
}
