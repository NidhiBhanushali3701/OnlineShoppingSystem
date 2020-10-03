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
		customerID=this.customerID;
		customerEmail=this.customerEmail;
		customerName=this.customerName;
		customerAddress=this.customerAddress;
		customerCredits=this.customerCredits;
		customerEmail=this.customerEmail;
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
