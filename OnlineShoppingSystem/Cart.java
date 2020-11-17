package BillingPackage;

import ProductsPackage.products;
import java.util.*;
public class Cart extends products {
    public static void cart(int c, int p)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Your Cart:");
        //displayCart(p);
        System.out.println("1)Remove an item\n2)Buy\n3)Buy All\n4)Back");
        int op=s.nextInt();
        switch(op)
        {
            case 1:
            System.out.println("Enter product number to be removed:");
            int n=s.nextInt();
            //remove(p,n);
            System.out.println("New list:");
            //displayCart(p);
            break;
            case 2:
            System.out.println("Which product do you want to buy?(Enter product number");
            int pro=s.nextInt();
            Buy.buymenu(c, pro);
            break;
            case 3:
            Buy.buymenu(c, p);
            break;
            case 4:
            //go to catalogue
            default:
            System.out.println("Invalid choice");
            cart(c, p);
        }
        s.close();
    }
    
}
