package OnlineShoppingSystem;

import java.util.*;

public class customerDashBoard extends customer{
    public static Scanner ob = new Scanner(System.in);
    
    public customerDashBoard(String userEMail,String userPassword)
    {
        super("customerName", 0, 0, 0, "customerAddress", userEMail, 0,'\0', userEMail,"");
        System.out.println("\n\t\t\tWELCOME !");
        int choice ;
        do{
            System.out.println("1. VIEW PRODUCTS");
            System.out.println("2. BUY PRODUCTS");
            System.out.println("3. PREVIOUS PRODUCTS");
            System.out.println("4. VIEW CART");         //System.out.println("5. ");//System.out.println("");
            System.out.println("0. EXIT");
            choice = ob.nextInt();
            switch(choice)
            {
                case 1:
                    viewProducts();
                break;
                case 2:
                    buyProducts();
                break;
                case 3:
                    viewPreviousProducts();
                break;
                case 4:
                    customerCart();
                break;
                case 0:
                    System.out.println("EXITING ... ");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }
        while(choice != 0);
    }
    public static void main(String args[]) 
	{
        customerDashBoard customerDashBoard_ = new customerDashBoard("user@gmail.com","password");

    }
    public void viewProducts()
    {
        int ch;
        do{
            System.out.println(" WHAT TYPE OF PRODUCT YOU WANT TO SEE ?");
            System.out.println("\t1. MEDICAL");
            System.out.println("\t2. HOME");
            System.out.println("\t3. GROOMING");
            System.out.println("\t4. GROCCERY");
            System.out.println("\t5. ELECTRONICS");
            System.out.println("\t6. CLOTHING");
            System.out.println("\t0. BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch =  ob.nextInt();

            product viewingProduct;

            switch(ch)
            {
                case 1:
                    viewingProduct = new  MedicalProducts();
                    viewingProduct.showProduct();
                break;
                case 2:
                    viewingProduct = new  HomeProducts();
                    viewingProduct.showProduct();
                break;
                case 3:
                    viewingProduct = new  GrommingProducts();
                    viewingProduct.showProduct();
                break;
                case 4:
                    viewingProduct = new  GrocceryProducts();
                    viewingProduct.showProduct();
                break;
                case 5:
                    viewingProduct = new  ElectronicProducts();
                    viewingProduct.showProduct();
                break;
                case 6:
                    viewingProduct = new  ClothingProducts();
                    viewingProduct.showProduct();       //this will give the respective product type dashboard
                break;
                case 0:
                System.out.println(" GOING TO DASHBORAD ");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }
        while(ch!=0);
    }
    public void buyProducts()
    {

    }
    public void viewPreviousProducts()
    {

    }
    public void customerCart()
    {

    }
}
