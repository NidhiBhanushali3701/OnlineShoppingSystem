package OnlineShoppingSystem;
import java.util.*;

class admin implements person
{
    public static Scanner ob = new Scanner(System.in);
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

	admin(String customerName,long customerID,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,int customerSize,char customerGender,String customerPassword, String prevOrders)
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
  
	admin()
	{
		customerAddress="";
		customerEmail="";
		customerName="";
		customerCredits=0;
		customerPhoneNo=0;
		customerID=0;
		customerSize=0;
		customerGender='\0';
		customerPassword="";
		prevOrders="";
		
	}

	public static void main(String args[]) 
	{
		System.out.println("customer - admin ");
    }
    

}