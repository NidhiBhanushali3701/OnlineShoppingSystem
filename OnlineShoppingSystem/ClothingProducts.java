package OnlineShoppingSystem;

public class ClothingProducts extends product
{   
    public ClothingProducts()
    {
        super();

        System.out.println("Clothing Product Class");
    }

    public ClothingProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public static void main(String args[]) 
    {

    }
}