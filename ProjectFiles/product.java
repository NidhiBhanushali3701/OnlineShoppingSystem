public class product
{
	
	long productID;
	String productName;
	long productBuyerID;
	String productBuyerName;
	long productCost;
	long productSellerID;
	String productSellerName;
	String productDescription;

	product(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
	{
		this.productId=productID;
		this.productCost=productCost;
		this.productBuyerID=productBuyerID;
		this.productBuyerName=productBuyerName;
		this.productName=productName;
		this.productSellerID=productSellerID;
		this.productSellerName=thisproductSellerName;
		this.productDescription=productDescription;
	}
	
	product()
	{
		productId=0;
		productCost=0;
		productBuyerID=0;
		productBuyerName="";
		productName="";
		productSellerID=0;
		productSellerName="";
		productDescription="";

		System.out.println("Product Class");
	}

	public static void main(String args[]) 
	{
		
	}
}