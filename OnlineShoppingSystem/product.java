package OnlineShoppingSystem;
import java.util.*;

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

		System.out.println("Product Class");
	}

	public abstract void showProduct();		//we will show the respective product here 
	public static void main(String args[]) 
	{
		
	}
}