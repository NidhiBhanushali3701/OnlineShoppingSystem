public class customer 
{

	String customerName;
	long customerPhoneNo;
	String customerEmail;
	String customerAddress;
	long customerCredits;
	long customerID;
  
	customer(String customerName,long customerID,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail)
	{
		this.customerID=customerID;
		this.customerEmail=customerEmail;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.customerCredits=customerCredits;
		this.customerEmail=customerEmail;
	}
  
	customer()
	{
		customerAddress="";
		customerEmail="";
		customerName="";
		customerCredits=0;
		customerPhoneNo=0;
		customerID=0;
	}
}
