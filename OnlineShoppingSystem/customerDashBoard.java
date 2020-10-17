package OnlineShoppingSystem;

import java.util.*;

public class customerDashBoard extends customer{
    public static Scanner ob;
    
    public customerDashBoard(String userEMail,String userPassword)
    {
        super("customerName", 0, 0, 0, "customerAddress", userEMail, 0,'\0', userEMail,"");
        ob = new Scanner(System.in);
        System.out.println(" WELCOME !");
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
                    System.out.println("INVALID CHOICE ");
                break;
            }
        }
        while(choice != 0 );
    }
    public static void main(String args[]) 
	{
        customerDashBoard customerDashBoard_ = new customerDashBoard("user@gmail.com","password");
    }
    public void viewProducts()
    {

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
