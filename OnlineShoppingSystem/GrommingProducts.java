package OnlineShoppingSystem;
import java.util.*;

public class GrommingProducts extends product
{
    public static Scanner ob = new Scanner(System.in);

    public GrommingProducts()
    {
        super();
        //System.out.println("Gromming Product Class");
    }

    public GrommingProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public void showProduct()
    {
        int ch;
        do{
            System.out.println("\t --->>> WELCOME TO GROMMING COLLECTION ");
            System.out.println("\t\t1. LOTIONS / CREAMS / OILS");
            System.out.println("\t\t2. SOAP / FACEWASH");
            System.out.println("\t\t3. SHAMPOO / CONDITIONER");
            System.out.println("\t\t4. TOOTH BRUSHES / PASTE ");
            System.out.println("\t\t5. FACIAL MASKS / FACIAL KITS");
            System.out.println("\t\t6. NAIL PAINTS / ACCESSORIES");
            System.out.println("\t\t7. SANITISERS / FACE MASKS / WIPPES / TISSUES");
            System.out.println("\t\t0. GO BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch = ob.nextInt();
            switch(ch)
            {
                case 1:

                break;
                case 2:
                    
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                case 5:

                break;
                case 6:

                break;
                case 7:
                
                break;
                case 0:
                    System.out.println("GOING BACK");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }while(ch!=0);
    }

    public static void main(String args[]) 
    {

	}
}
