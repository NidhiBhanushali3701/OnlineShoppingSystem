package OnlineShoppingSystem;

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
  
	customer()
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
		System.out.println("customer");
	}
}