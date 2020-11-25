package OnlineShoppingSystem.Customer;
import OnlineShoppingSystem.Product.*;
import java.sql.*;
import java.util.*;

public class buyProducts extends accountSettings 
{
    public static Scanner ob = new Scanner(System.in);
    public buyProducts(customer thisCustomer) 
    {
        super(thisCustomer);
        //super(this,userEMail, userPassword);
    }

    public buyProducts() 
    {
        super();
	}

    public void buymenu(customer thisCustomer) 
    {
        //System.out.println("Product(s) details:\n");
        //displayproducts();
        //((product) thisCustomer.buyProducts).billing(thisCustomer, thisCustomer.customerCart);
        System.out.println("Your details:\n");
        display(thisCustomer);

        System.out.println("Do You want to edit your personal details (0->No & 1->Yes)");
        int op=ob.nextInt();
        
        if(op==0)
        {           
            confirmOrder(thisCustomer);
        }
        else if(op==1)
        {
            edit(thisCustomer);
            confirmOrder(thisCustomer);
        }
        else
        {
            System.out.println("Invalid choice".toUpperCase());
            buymenu(thisCustomer);
        }        
      

    }

    public void confirmOrder(customer thisCustomer)
    {
        
        System.out.println("1) Proceed to payment\n0) CANCEL ORDER & BACK TO DASHBORAD".toUpperCase());
        switch(ob.nextInt())
        {
            case 1:
                billing(thisCustomer);
            break;
            case 0:
                displayCustomerDashBoard(thisCustomer);
            break;
            default:
                System.out.println("Invalid choice".toUpperCase());
                confirmBuyProducts(thisCustomer);
            break;
        }
            
    }

    public void billing(customer thisCustomer)
    {
        
        System.out.println("Order Summary:\n");
        //display product name, quantity, specifications, price
        customerCart(thisCustomer);
        getpaymentDetails(thisCustomer);
        System.out.println("1) confirm order?\n0) cancel".toUpperCase());
        int o=ob.nextInt();
        switch(o)
        {
            case 1:
            //save in prevOrders
            System.out.println("\t\t\tOrder Successfully placed!!".toUpperCase());
            for(int pI=0;pI<thisCustomer.customerCart.size();pI++)
            {
                thisCustomer.customerOrders.add(thisCustomer.customerCart.get(pI));
            }
            thisCustomer.customerCart.clear();
            try
            {
                delivered_thread.start();
            }
            catch(Exception e)
            {
                //System.out.println(e);
            }
            //delivered_thread.start();
            //start thread
            break;
            case 2:
            displayCustomerDashBoard(thisCustomer);
            break;
        }
       
    }

    public void getpaymentDetails(customer thisCustomer)
    {
        String name;
	    long phone;
        int otp,num,exp,cvv; 
		thisCustomer.customerTotalBill=0;
		int q;
		for(product buyingProd:thisCustomer.customerCart)
		{
			q=0;
			System.out.println("Enter the quantity of "+buyingProd.productName);
			q=ob.nextInt();
			thisCustomer.customerTotalBill+=(buyingProd.productCost*q);
		}
		System.out.println("  \t  \t \t YOUR TOTAL AMOUNT IS = $ " + thisCustomer.customerTotalBill+"\n");
		if(thisCustomer.customerCredits>0)
		{
		System.out.println("DO YOY WANT TO USE YOUR ACCOUNT CREDIT BALANCE");
		int op=ob.nextInt();
		if(op!=0)
		{
			thisCustomer.customerTotalBill-=thisCustomer.customerCredits;
			System.out.println("  \t  \t \t YOUR GRAND TOTAL AMOUNT IS = $ " + thisCustomer.customerTotalBill+"\n");
		}
			System.out.println(" NICE CHOICE OF PRODUCTS ");
		}
		System.out.println("\nHow do you wish to pay?\n1) UPI IDs/Net banking\n2) Debit/Credit/ATM Card\n3) Pay on Delivery\n0) back".toUpperCase());
        int op=ob.nextInt();  
        switch(op)
        {
            case 1:
            System.out.println("Enter Name: ");     ob.nextLine();
            name=ob.nextLine();
            System.out.println("Enter Phone number: ");
            phone=ob.nextLong();	
            System.out.println("Enter OTP: ");
            otp=ob.nextInt();
	        System.out.println("Redirecting...");
            System.out.println("Payment was Successfully done! ");           
            break;
            case 2:
            System.out.println("Enter name: ");     ob.nextLine();
            name=ob.nextLine();
            System.out.println("Enter your card number: ");
	        num=ob.nextInt();
            System.out.println("Enter the expiration date: ");
            exp=ob.nextInt();
            System.out.println("Enter CVV (card verification value): ");
	        cvv=ob.nextInt();            
            break;
            case 3:
	        System.out.println("Order has been placed");
            break;
            case 0:
            confirmOrder(thisCustomer);
            break;
            default:
            System.out.println("Invalid choice".toUpperCase());
            getpaymentDetails(thisCustomer);
        }      
      
    }
}