package CustomerPackage;
import java.util.*;

public class Buy extends accountSettings {
    public static void buymenu(int c,int p){
        Scanner s=new Scanner(System.in);
        System.out.println("Product(s) details:\n");
        //displayproducts();
        System.out.println("Your details:\n");
        display(c);
        System.out.println("Do You want to edit your personal details(0->No,1->Yes)");
        int op=s.nextInt();
        
        if(op==0)
        {           
            confirmOrder(c,p);
        }
        else if(op==1)
        {
            edit(c);
            confirmOrder(c,p);
        }
        else
        {
            System.out.println("Invalid choice");
            buymenu(c, p);
        }        
      

    }

    public static void confirmOrder(int c,int p){
        Scanner s=new Scanner(System.in);
        System.out.println("1)Proceed to payment\n2)Go back\n3)Cancel ordering");
            int o=s.nextInt();
            switch(o)
            {
                case 1:billing(c,p);
                break;
                case 2:buymenu(c, p);
                break;
                case 3:
                //go to catalogue
                break;
            }
            
    }

    public static void billing(int c,int p)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Order Summary:\n");
        //display product name, quantity, specifications, price
        getpaymentDetails(c,p);
        System.out.println("1)confirm order?\n2)cancel");
        int o=s.nextInt();
        switch(o)
        {
            case 1:
            //save in prevOrders
            System.out.println("Order Successfully placed!!");
            break;
            case 2:
            //go to catalogue
            break;
        }
       
    }

    public static void getpaymentDetails(int c, int p)
    {
        String name;
        Scanner s=new Scanner(System.in);
        System.out.println("How do you wish to pay?\n1)UPI IDs/Net banking\n2)Debit/Credit/ATM Card\n3)Pay on Delivery\n4)Go back");
        int op=s.nextInt();  
        switch(op)
        {
            case 1:
            System.out.println("Enter name: ");
            System.out.println("Enter  ");
            break;
            case 2:
            System.out.println("Enter name: ");
            name=s.nextLine();
            System.out.println("Enter your card number: ");
            System.out.println("Enter the expiration date: ");
            System.out.println("Enter CVV (card verification value): ");
            System.out.println("Enter the zip code: ");
            break;
            case 3:
            break;
            case 4:
            confirmOrder(c, p);
            break;
            default:
            System.out.println("Invalid choice");
            getpaymentDetails(c,p);
        }      
      
    }
    
}
