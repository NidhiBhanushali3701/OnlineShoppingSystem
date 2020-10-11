public class ElectronicProducts extends product
{
    public ElectronicProducts()
    {
        super();

        System.out.println("Electronic Product Class");
    }

    public ElectronicProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public static void main(String args[]) 
    {

	}
}
