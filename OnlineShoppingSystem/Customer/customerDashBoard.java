package OnlineShoppingSystem.Customer;
import OnlineShoppingSystem.Product.*;
import OnlineShoppingSystem.TnE.*;
import java.util.*;
import java.time.*;
import java.sql.*;

public class customerDashBoard extends customer{
    public static Scanner ob = new Scanner(System.in);
    //customerCart customerCart_;    
    //product buyingProduct;
    public customerDashBoard(customer thisCustomer)
    {
        super(thisCustomer.customerName,thisCustomer.customerPhoneNo,thisCustomer.customerCredits,thisCustomer.customerAddress,thisCustomer.customerEmail,thisCustomer.customerPassword,thisCustomer.customerID,thisCustomer.customerTotalBill);
    }
    
    public customerDashBoard() 
    {
        super();
	}

	public void displayCustomerDashBoard(customer thisCustomer)
    {
        System.out.println("\n\t\t\tWELCOME\t"+thisCustomer.customerName);
        int choice ;
        do{
            System.out.println("YOU CAN SELECT FROM ALL BELOW :)");
            System.out.println("1. VIEW PRODUCTS");
            System.out.println("2. BUY PRODUCTS");
            System.out.println("3. VIEW CART");  
            System.out.println("4. VIEW WISHLIST"); //System.out.println("");
            System.out.println("5. VIEW ORDERED PRODUCTS");
            System.out.println("6. ACCOUNT SETTINGS");
            System.out.println("0. EXIT");
            System.out.print(" PLEASE ENTER YOUR CHOICE - ");
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
                    customerCart(this);
                break;
                case 4:
                    customerWishlist(this);
                break;
                case 5:
                    orderedProducts(this);;
                break;
                case 6: 
                    accountSettings ob=new accountSettings(thisCustomer);                  
                    ob.settingsmenu(thisCustomer);
                break;
                case 0:
                    System.out.println("EXITING ... ");
                    System.exit(0);
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }
        while(choice != 0);
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
        product buyingProduct;
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
                    confirmBuyProducts(this);
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
    public void confirmBuyProducts(customer thisCustomer)
    {
        if(thisCustomer.customerCart.size()>0)
        {
            System.out.println("\t SURE YOU WANT TO BUY ?");
            int sureBuy = ob.nextInt();
            if(sureBuy!=0)
            {           //call payment method()
                customerPayment(thisCustomer);
            }
            else
            {
                //break;
            }
        }
        else
        {
            //System.out.println("\t >> YOUR CART IS EMPTY ADD & BUY BEST PRODUCT AT BEST POSSIBLE PRICES :)\n");
        }
    }
    public void viewPreviousProducts(customer thisCustomer,int flag)
    {
        if(thisCustomer.customerDeliveryStatus!=0 || flag!=0)
        {
            for(int pI=0;pI<thisCustomer.customerCart.size();pI++)
            {
                thisCustomer.prevOrders.add(thisCustomer.customerOrders.get(pI));
            }
            thisCustomer.customerOrders.clear();
        }
        if(thisCustomer.prevOrders.size()>0)
        {
            System.out.println("\t\t >> YOUR DELIVERED PRODUCTS");
            for(product p:thisCustomer.prevOrders)
            {
                System.out.println(p.productName+"\t\t"+p.productCost);
            }
        }
        else{
            System.out.println("\t >> YOU HAVEN'T BOUGHT ANYTHING ADD & BUY BEST PRODUCT AT BEST POSSIBLE PRICES :)");
        }
        System.out.println("");
    }
    public void orderedProducts(customer thisCustomer)
    {
        if(thisCustomer.customerOrders.size()>0)
        {
            System.out.println("\t\t >> YOUR ORDERED PRODUCTS");
            for(product p:thisCustomer.customerOrders)
            {
                System.out.println(p.productName+"\t\t"+p.productCost);
            }
        }
        else{
            System.out.println("\t >> YOU HAVEN'T BOUGHT ANYTHING ADD & BUY BEST PRODUCT AT BEST POSSIBLE PRICES :)");
        }
        System.out.println("");
    }
    public void customerCart(customer thisCustomer)
    {
        //product buyedProducts = new ClothingProducts();
        if(thisCustomer.customerCart.size()>0)
        {
            System.out.println("\t >> YOUR CART \n");
            int i=1;
            for(product cartProduct: thisCustomer.customerCart)
            {
                System.out.println("\t\t "+(i)+". "+cartProduct.productName + " \t " +cartProduct.productCost + " \t " + cartProduct.productSellerName);
                i++;    
            }
            System.out.println("");
            System.out.println("DO YOU WANT CHANGE CART ? \n 1. ADD \n 2. REMOVE \n 0. NO - CONTINUE & BUY ALL");
            switch(ob.nextInt())
            {
                case 1:
                    viewProducts();
                break;
                case 2:
                    System.out.println("Enter Name of The Product From To remove it ");
                    //String removeProductName=ob.nextLine();
                    ob.nextLine();
                    removeFromCart(this,ob.nextLine());
                break;
                case 0:
                    System.out.println(" HOLD ON TILL WE LOAD : ) \n");
                    confirmBuyProducts(this);
                    //buyProducts();
                    //buyedProducts.billing(this,customerCart);
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
            //customerCart_ = new customerCart(, );
        }
        else{
            System.out.println("\t >> YOUR CART IS EMPTY ADD & BUY BEST PRODUCT AT BEST POSSIBLE PRICES :)");
        }
        System.out.println("");
    }
    public void customerWishlist(customer thisCustomer)
    {
        
        if(thisCustomer.customerWishList.size()>0)
        {
            System.out.println("\t\t>>> YOUR WISHLIST \n");
            int i=1;
            for(product cartProduct: thisCustomer.customerWishList)
            {
                System.out.println("\t\t "+(i)+". "+cartProduct.productName + " \t " +cartProduct.productCost + " \t " + cartProduct.productSellerName);
                i++;    
            }
            System.out.println("");
        }
        else{
            System.out.println("\t >> YOUR WISHLIST IS EMPTY VIEW & BUY BEST PRODUCT AT BEST POSSIBLE PRICES :)");
        }
        System.out.println("");
    }

    public void removeFromCart(customer thisCustomer,String toRemoveProduct)
    {
        /*Iterator<product> i = customerCart.iterator();
        while(i.hasNext())
        {
            product p=i.next();
            if(p.productName.trim().equalsIgnoreCase(toRemoveProduct))
            {
                customerCart.remove(i.next());
            }
        }*/
        for(int i = 0;i<customerCart.size();i++)
        {
            if(customerCart.elementAt(i).productName.trim().equalsIgnoreCase(toRemoveProduct))
            {
                customerCart.removeElementAt(i);
            }
        }
    }

    public void checkStatus(customer thisCustomer,int flagDelivered)
    { 
        //this.flagDelivered=flagDelivered;
        if(flagDelivered!=0 || thisCustomer.customerDeliveryStatus!=0)
        {
            for(int pI=0;pI<thisCustomer.customerCart.size();pI++)
            {
                thisCustomer.prevOrders.add(thisCustomer.customerOrders.get(pI));
            }
            thisCustomer.customerOrders.clear();
        }
    }

    public void search()
    {
        int ch;
        do{
            System.out.println(" WHAT TYPE OF PRODUCT YOU WANT TO SEARCH IN ?");
            System.out.println("\t1. MEDICAL");
            System.out.println("\t2. HOME");
            System.out.println("\t3. GROOMING");
            System.out.println("\t4. GROCCERY");
            System.out.println("\t5. ELECTRONICS");
            System.out.println("\t6. CLOTHING");
            System.out.println("\t0. BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch =  ob.nextInt();
            String s;
            product searchProduct;

            switch(ch)
            {
                case 1:
                    searchProduct = new  MedicalProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 2:
                    searchProduct = new  HomeProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                    
                break;
                case 3:
                    searchProduct = new  GrommingProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 4:
                    searchProduct = new  GrocceryProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 5:
                    searchProduct = new  ElectronicProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);
                break;
                case 6:
                    searchProduct = new  ClothingProducts();
                    System.out.println("ENTER THE PRODUCT TO SEARCH ");
                    ob.nextLine();
                    s=ob.nextLine();
                    System.out.println(s);
                    searchProduct.search(s);       //this will give the respective product type dashboard
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
    
}