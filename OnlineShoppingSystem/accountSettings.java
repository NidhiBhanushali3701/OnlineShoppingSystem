package CustomerPackage;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class accountSettings extends customer{
    
    public static void settingsmenu(int c){
        Scanner s=new Scanner(System.in);
        int op;
        
                    
            System.out.println("\n1)DISPLAY DETAILS\n2)EDIT DETAILS\n3)VIEW PREVIOUS ORDERS\n4)SIGN OUT\n5)DELETE ACCOUNT\n6)BACK\n7)EXIT\n");
            op=s.nextInt();
            switch(op)
            {
                case 1:
                display(c);
                settingsmenu(c);
                break;
                case 2:
                edit(c);
                settingsmenu(c);
                break;
                case 3:
                prevorders(c);
                settingsmenu(c);
                break;
                case 4:
                customer.customMenu();
                settingsmenu(c);
                break;
                case 5:
                delete(c);
                break;
                case 6://should be store menu after implementing store menu
                customer.customMenu();
                settingsmenu(c);
                break;
                case 7:
                System.exit(0);
                break;
                default:
                System.out.println("Wrong input, try again.");
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
        int o=0;
        String name,add,pass,id;
        long p=0;
        String newpass="";
        String regexStr = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"; 
		Pattern pattern = Pattern.compile(regexStr); 
        System.out.println("\nEDIT:\n1)Name\n2)Addrress\n3)Phone Number\n4)Email ID\n5)Password");
        o=s.nextInt();
        s.nextLine();
        boolean validity=false;
        switch(o)
        {
            case 1:
            System.out.println( "Name "+cust.get(c).customerName);
            System.out.println( "New Name ");
            name=s.nextLine();
            cust.elementAt(c).customerName=name;
            break;
            case 2:
            System.out.println( "Address "+cust.get(c).customerAddress);
            System.out.println( "New Address ");
            add=s.nextLine();
            cust.elementAt(c).customerAddress=add;
            break;
            case 3:
            System.out.println( "Phone Number "+cust.get(c).customerPhoneNo);
            while(!validity){
            try{
            System.out.println( "New Phone number ");
            p=s.nextLong();
            if(p<1000000000)throw new phonenumberException("Please enter a valid phone number(10 digits)");
		    else validity=true;
            }
            catch(phonenumberException e)
            {
                System.out.println(e);
            }
            }
            cust.elementAt(c).customerPhoneNo=p;
            break;
            case 4:
            System.out.println( "Email ID "+cust.get(c).customerEmail);
            System.out.println( "New ID ");
            id=s.nextLine();
            cust.elementAt(c).customerEmail=id;
            break;
            case 5:
            System.out.println("Enter your old password");
            pass=s.nextLine();
            
            if(cust.elementAt(c).customerPassword.equals(pass))
            {
                while(!validity)
                {
                    try{
                    System.out.println( "New Password ");
                    newpass=s.nextLine();
                    Matcher matcher = pattern.matcher(newpass);
                    if(!matcher.matches())throw new passwordException("Please enter a valid password(min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number)");
                    else validity=true;
                    }
                    catch(passwordException e)
                    {
                        System.out.println(e);			
                    }
                }
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
        
        System.out.println("Are you sure you want to delete your Account?(Y->1/N->0)");
        int ch=s.nextInt();
        if(ch==1)
        {
            cust.remove(c);
            customMenu();
        }
        else if(ch==0)
        {
            settingsmenu(c);
        }
        else
        {
            System.out.println("Invalid choice");
            delete(c);
        }
      

    }
}
