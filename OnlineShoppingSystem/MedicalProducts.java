public class MedicalProducts extends product
{
    public MedicalProducts()
    {
        super();

        System.out.println("Medical Product Class");
    }

    public MedicalProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public static void main(String args[]) 
    {
		System.out.println("4");
	}
}