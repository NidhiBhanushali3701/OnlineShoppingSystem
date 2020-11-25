package OnlineShoppingSystem.Product;
import java.util.*;
import java.sql.*;
import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.TnE.*;

public abstract class product
{
	public static Scanner ob = new Scanner(System.in);
	long productID;
	public String productName;
	long productBuyerID;
	String productBuyerName;
	public long productCost;
	long productSellerID;
	public String productSellerName;
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

	public abstract void showProduct(customer thisCustomer);		

	public abstract void search(String productNameToFind);
	
	public abstract void sortHighToLow();
	
	public abstract void sortLowToHigh();

	public abstract void addToCart(customer thisCustomer,product addToCartProduct);	
	
	public abstract void addToWishList(customer thisCustomer,product addToWLProd);

	public static void main(String[] args)
    {

    }
}
