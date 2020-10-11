public class GrommingProducts extends product
{
    public GrommingProducts()
    {
        super();

        System.out.println("Gromming Product Class");
    }

    public GrommingProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public static void main(String args[]) 
    {

	}
}
