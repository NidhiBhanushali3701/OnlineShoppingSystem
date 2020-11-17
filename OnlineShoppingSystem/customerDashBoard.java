package OnlineShoppingSystem;

import java.util.*;
import java.time.*;
import java.sql.*;

public class customerDashBoard extends customer{
    public static Scanner ob = new Scanner(System.in);
    customerCart customerCart_;    
    public customerDashBoard(String userEMail,String userPassword)
    {
        super("customerName", 0, 0, 0, "customerAddress", userEMail, 0,'\0', userEMail,"",0);
        System.out.println("\n\t\t\tWELCOME !");
        int choice ;
        do{
            System.out.println("1. VIEW PRODUCTS");
            System.out.println("2. BUY PRODUCTS");
            System.out.println("3. PREVIOUS PRODUCTS");
            System.out.println("4. VIEW CART");  
            System.out.println("5. VIEW WISHLIST"); //System.out.println("");
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
                    viewPreviousProducts(this);
                break;
                case 4:
                    customerCart(this);
                break;
                case 5:

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
            System.out.println("\t7. VIEW CART");
            System.out.println("\t0. BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch =  ob.nextInt();

            product viewingProduct;

            switch(ch)
            {
                case 1:
                    viewingProduct = new  MedicalProducts();
                    viewingProduct.showProduct(this);
                break;
                case 2:
                    viewingProduct = new  HomeProducts();
                    viewingProduct.showProduct(this);
                break;
                case 3:
                    viewingProduct = new  GrommingProducts();
                    viewingProduct.showProduct(this);
                break;
                case 4:
                    viewingProduct = new  GrocceryProducts();
                    viewingProduct.showProduct(this);
                break;
                case 5:
                    viewingProduct = new  ElectronicProducts();
                    viewingProduct.showProduct(this);
                break;
                case 6:
                    viewingProduct = new  ClothingProducts();
                    viewingProduct.showProduct(this);       //this will give the respective product type dashboard
                break;
                case 7:
                    customerCart(this);
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
        int ch;
        do{
            System.out.println(" WHAT TYPE OF PRODUCT YOU WANT TO SEE ?");
            System.out.println("\t1. MEDICAL");
            System.out.println("\t2. HOME");
            System.out.println("\t3. GROOMING");
            System.out.println("\t4. GROCCERY");
            System.out.println("\t5. ELECTRONICS");
            System.out.println("\t6. CLOTHING");
            System.out.println("\t7. BUY ALL FROM CART");
            System.out.println("\t0. BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch =  ob.nextInt();

            product buyingProduct;

            switch(ch)
            {
                case 1:
                    buyingProduct = new  MedicalProducts();
                    buyingProduct.showProduct(this);
                    buyingProduct.billing(this,customerCart);
                break;
                case 2:
                    buyingProduct = new  HomeProducts();
                    buyingProduct.showProduct(this);
                    buyingProduct.billing(this,customerCart);
                break;
                case 3:
                    buyingProduct = new  GrommingProducts();
                    buyingProduct.showProduct(this);
                    buyingProduct.billing(this,customerCart);
                break;
                case 4:
                    buyingProduct = new  GrocceryProducts();
                    buyingProduct.showProduct(this);
                    buyingProduct.billing(this,customerCart);
                break;
                case 5:
                    buyingProduct = new  ElectronicProducts();
                    buyingProduct.showProduct(this);
                    buyingProduct.billing(this,customerCart);
                break;
                case 6:
                    buyingProduct = new  ClothingProducts();
                    buyingProduct.showProduct(this);
                    buyingProduct.billing(this,customerCart);       //this will give the respective product type dashboard
                break;
                case 7:
                    buyingProduct = new ClothingProducts();
                    customerCart(this);
                    buyingProduct.billing(this,customerCart);
                    System.out.println("\t SURE YOU WANT TO BUY ?");
                    int sureBuy = ob.nextInt();
                    if(sureBuy!=0)
                    {
                        //call payment method()
                        System.out.println("SELECT PAYING OPTION ");
                    }
                    else
                    {
                        break;
                    }
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
    public void viewPreviousProducts(customer thisCustomer)
    {

    }
    public void customerCart(customer thisCustomer)
    {
        //product buyedProducts = new ClothingProducts();
        System.out.println("\t >> YOUR CART ");
        int i=1;
        for(product cartProduct: thisCustomer.customerCart)
        {
            System.out.println("\t\t "+(i)+". "+cartProduct.productName + " \t " +cartProduct.productCost + " \t " + cartProduct.productSellerName);
            i++;    
        }

        System.out.println("DO YOU WANT CHANGE CART ? \n 1. ADD \n 2. REMOVE \n 0. NO - CONTINUE & BUY ALL");
        switch(ob.nextInt())
        {
            case 1:
                viewProducts();
            break;
            case 2:
                System.out.println("Enter Name of The Product From To remove it ");
                //String removeProductName=ob.nextLine();
                removeFromCart(this,ob.nextLine());
            break;
            case 0:
                System.out.println(" HOLD ON TILL WE LOAD : ) \n");
                buyProducts();
                //buyedProducts.billing(this,customerCart);
            break;
            default:
                System.out.println("INVALID CHOICE \n");
            break;
        }
        //customerCart_ = new customerCart(, );
    }
    public void customerWishlist()
    {

    }

    public void removeFromCart(customer thisCustomer,String toRemoveProduct)
    {

    }
}
