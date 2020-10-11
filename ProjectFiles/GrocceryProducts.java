public class GrocceryProducts extends product
{
    public GrocceryProducts()
    {
        super();

        System.out.println("Groccery Product Class");
    }

    public GrocceryProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public static void main(String args[]) 
    {

	}
}
