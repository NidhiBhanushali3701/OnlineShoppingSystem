package OnlineShoppingSystem;
import java.util.*;
import java.sql.*;

public abstract class product
{
	public static Scanner ob = new Scanner(System.in);
	long productID;
	String productName;
	long productBuyerID;
	String productBuyerName;
	long productCost;
	long productSellerID;
	String productSellerName;
	String productDescription;

	product(long productID,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
	{
		this.productID = productID;
		this.productCost = productCost;
		this.productBuyerID = productBuyerID;
		this.productBuyerName = productBuyerName;
		this.productName = productName;
		this.productSellerID = productSellerID;
		this.productSellerName = productSellerName;
		this.productDescription = productDescription;
	}

	product() {
		productID = 0;
		productCost=0;
		productBuyerID=0;
		productBuyerName="";
		productName="";
		productSellerID=0;
		productSellerName="";
		productDescription="";
	}

	public abstract void showProduct(customer thisCustomer);		//we will show the respective product here 
	public static void main(String args[]) 
	{
		System.out.println("Product Class");
	}

	public abstract void search(String productNameToFind);
	
	public abstract void sortHighToLow();
	
	public abstract void sortLowToHigh();

	public abstract void searchByBrand();
	
	//public abstract void sortByNew();

	//public abstract void sortByPopular();

	public abstract void addToCart(customer thisCustomer,product addToCartProduct);

	//public abstract void removeFromCart(customer thisCustomer,product toRemoveProduct);

	public void billing(customer thisCustomer,Vector<product> customerCartVector)
	{
		thisCustomer.customerTotalBill=0;
		for(product buyingProd:customerCartVector)
		{
			thisCustomer.customerTotalBill+=buyingProd.productCost;
		}
		System.out.println("  \t  \t \t YOUR TOTAL AMOUNT IS = $ " + thisCustomer.customerTotalBill+"\n");
	}
}
