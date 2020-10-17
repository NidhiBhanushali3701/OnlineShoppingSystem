package OnlineShoppingSystem;

public class HomeProducts extends product
{
    public HomeProducts()
    {
        super();

        System.out.println("Home Product Class");
    }

    public HomeProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public static void main(String args[]) 
    {

	}
}