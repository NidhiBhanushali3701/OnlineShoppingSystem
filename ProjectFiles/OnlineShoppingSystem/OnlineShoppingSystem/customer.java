package OnlineShoppingSystem;
import java.util.*;
import java.sql.*;

public class customer implements person
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
	long customerTotalBill;
	Vector<product> customerCart = new Vector<product>();
	Vector<product> customerWishList = new Vector<product>();

	customer(String customerName,long customerID,long customerPhoneNo,long customerCredits,String customerAddress,String customerEmail,int customerSize,char customerGender,String customerPassword, String prevOrders,long customerTotalBill)
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
		this.customerTotalBill=customerTotalBill;
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
		customerTotalBill=0;
		customerCredits=((long)(customerTotalBill*0.01));
	}

	public void customerPayment()
	{
		System.out.println("SELECT PAYING OPTION ");
		System.out.println("1. COD ");
		System.out.println("2. NET BANKING");
		System.out.println("3. CARDS");
		System.out.println("4. CREDIT POINTS");
	}
	public static void main(String args[]) 
	{
		System.out.println("customer");
	}
}