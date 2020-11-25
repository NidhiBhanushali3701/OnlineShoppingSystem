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

	public abstract void showProduct(customer thisCustomer);		//we will show the respective product here 

	public abstract void search(String productNameToFind);
	
	public abstract void sortHighToLow();
	
	public abstract void sortLowToHigh();

	//public abstract void searchByBrand();
	
	//public abstract void sortByNew();

	//public abstract void sortByPopular();

	public abstract void addToCart(customer thisCustomer,product addToCartProduct);

	//public abstract void removeFromCart(customer thisCustomer,product toRemoveProduct);

	public void billing(customer thisCustomer,Vector<product> customerCartVector)
	{
		/*thisCustomer.customerTotalBill=0;
		int q;
		for(product buyingProd:customerCartVector)
		{
			q=0;
			System.out.println("Enter the quantity of "+buyingProd.productName);
			q=ob.nextInt();
			thisCustomer.customerTotalBill+=(buyingProd.productCost*q);
		}
		System.out.println("  \t  \t \t YOUR TOTAL AMOUNT IS = $ " + thisCustomer.customerTotalBill+"\n");
		if(thisCustomer.customerCredits>0)
		{
		System.out.println("DO YOY WANT TO USE YOUR ACCOUNT CREDIT BALANCE");
		int op=ob.nextInt();
		if(op!=0)
		{
			thisCustomer.customerTotalBill-=thisCustomer.customerCredits;
			System.out.println("  \t  \t \t YOUR GRAND TOTAL AMOUNT IS = $ " + thisCustomer.customerTotalBill+"\n");
		}
			System.out.println(" NICE CHOICE OF PRODUCTS ");
		}*/
	}
	/*public void billing(customer thisCustomer,Vector<product> customerCartVector)
	{
		thisCustomer.customerTotalBill=0;
		System.out.println("in bill");
		for(product buyingProd:customerCartVector)
		{
			thisCustomer.customerTotalBill+=buyingProd.productCost;
		}
		System.out.println("  \t  \t \t YOUR TOTAL AMOUNT IS = $ " + thisCustomer.customerTotalBill+"\n");
	}*/
	
	public abstract void addToWishList(customer thisCustomer,product addToWLProd);

	public static void main(String[] args)
    {

    }
}