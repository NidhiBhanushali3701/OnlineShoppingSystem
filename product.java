class product{
	long productID;
	String productName;
	long productBuyerID;
	String productBuyerName;
	long productCost;
	long productSellerID;
	String productSellerName;
	product(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName)
	{
		productId=this.productID;
		productCost=this.productCost;
		productBuyerID=this.productBuyerID;
		productBuyerName=this.productBuyerName;
		productName=this.productName;
		productSellerID=this.productSellerID;
		productSellerName=this.productSellerName;
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
	}
}
