import java.util.*;
public class accountSettings extends customer {
    public static void settingsmenu(int c){
        Scanner s=new Scanner(System.in);
        int op=0;
        while(op!=7){
            System.out.println("\n1)DISPLAY DETAILS\n2)EDIT DETAILS\n3)VIEW PREVIOUS ORDERS\n4)SIGN OUT\n5)DELETE ACCOUNT\n6)BACK\n7)EXIT\n");
            op=s.nextInt();
            switch(op)
            {
                case 1:
                display(c);
                break;
                case 2:
                edit(c);
                break;
                case 3:
                prevorders(c);
                break;
                case 4:
                customer.customMenu();
                break;
                case 5:
                delete(c);
                break;
                case 6://should be store menu after implementing store menu
                customer.customMenu();
                break;
                case 7:
                System.exit(0);
                break;
                default:
                System.out.println("Wrong input, try again.");
            }
        }

    }

    public static void display(int c)
    {
        
        System.out.println( "Name "+cust.get(c).customerName);
        System.out.println( "Email ID "+cust.get(c).customerEmail);
        System.out.print( "Phone Number ");
        System.out.println(cust.get(c).customerPhoneNo);
        System.out.println( "Address "+cust.get(c).customerAddress);
        
    }
    
    public static void edit(int c)
    {
        Scanner s=new Scanner(System.in);
        int op=0;
        String name,add,p,pass,newpass,id;
        System.out.println("\nEDIT:\n1)Name\n2)Addrress\n3)Phone Number\n4)Email ID\n5)Password");
        op=s.nextInt();
        switch(op)
        {
            case 1:
            System.out.println( "Name "+cust.get(c).customerName);
            System.out.println( "New Name ");
            name=s.next();
            cust.elementAt(c).customerName=name;
            break;
            case 2:
            System.out.println( "Address "+cust.get(c).customerAddress);
            System.out.println( "New Address ");
            add=s.next();
            cust.elementAt(c).customerAddress=add;
            break;
            case 3:
            System.out.println( "Phone Number "+cust.get(c).customerPhoneNo);
            System.out.println( "New Phone number ");
            p=s.next();
            cust.elementAt(c).customerAddress=p;
            break;
            case 4:
            System.out.println( "Email ID "+cust.get(c).customerEmail);
            System.out.println( "New ID ");
            id=s.next();
            cust.elementAt(c).customerEmail=id;
            break;
            case 5:
            System.out.println("Enter your old password");
            pass=s.next();
            if(cust.elementAt(c).customerPassword.equals(pass))
            {
                System.out.println( "New Password ");
                newpass=s.next();
                cust.elementAt(c).customerPassword=newpass;
            }
            else
            {
                System.out.println("Wrong password");
                edit(c);
            }
            break;
            default:
            System.out.println("Invalid choice");
            edit(c);
            break;

        }
        
    }

    public static void prevorders(int c)
    {
        System.out.println( "Your orders: "+cust.get(c).prevOrders);
    }

    public static void delete(int c)
    {
        Scanner s=new Scanner(System.in);
        String op;
        System.out.println("Are you sure you want to delete your Account?(Y/N)");
        op=s.next();
        if(op.equals("Y"))
        {
            cust.remove(c);
        }
        else if(op.equals("N"))
        {
            settingsmenu(c);
        }
        else
        {
            System.out.println("Invalid choice");
            delete(c);
        }
        s.close();

    }
}
