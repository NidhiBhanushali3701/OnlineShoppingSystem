package OnlineShoppingSystem;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class accountSettings extends customerDashBoard{
    
    public accountSettings(customer thisCustomer) {
        super(thisCustomer);
    }

	public void settingsmenu(customer thisCustomer) {
        Scanner s=new Scanner(System.in);
        int op;
        
            System.out.println("\n1)DISPLAY DETAILS\n2)EDIT DETAILS\n3)SIGN OUT\n4)DELETE ACCOUNT\n5)BACK\n6)EXIT\n");
            op=s.nextInt();
            switch(op)
            {
                case 1:
                display(thisCustomer);
                settingsmenu(thisCustomer);
                break;
                case 2:
                edit(thisCustomer);
                settingsmenu(thisCustomer);
                break;
                case 3:
                customMenu();
                settingsmenu(thisCustomer);
                break;
                case 4:
                delete(thisCustomer);
                break;
                case 5:
                displayCustomerDashBoard(thisCustomer);
                settingsmenu(thisCustomer);
                break;
                case 6:
                System.exit(0);
                break;
                default:
                System.out.println("Wrong input, try again.");
            }
        
        

    }

    public void display(customer thisCustomer)
    {
        
        System.out.println( "Name "+thisCustomer.customerName);
        System.out.println( "Email ID "+thisCustomer.customerEmail);
        System.out.println( "Phone Number "+ thisCustomer.customerPhoneNo);
        System.out.println( "Address "+thisCustomer.customerAddress);
        
    }
    
    public void edit(customer thisCustomer)
    {
        customer old=thisCustomer;
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
            System.out.println( "Name "+thisCustomer.customerName);
            System.out.println( "New Name ");
            name=s.nextLine();
            thisCustomer.customerName=name;
            break;
            case 2:
            System.out.println( "Address "+thisCustomer.customerAddress);
            System.out.println( "New Address ");
            add=s.nextLine();
            thisCustomer.customerAddress=add;
            break;
            case 3:
            System.out.println( "Phone Number "+thisCustomer.customerPhoneNo);
            while(!validity){
            try{
            System.out.println( "New Phone number ");
            p=s.nextLong();
            if(p<1000000000)
                throw new phonenumberException("Please enter a valid phone number(10 digits)");
		    else validity=true;
            }
            catch(phonenumberException e)
            {
                System.out.println(e);
            }
            }
            thisCustomer.customerPhoneNo=p;
            break;
            case 4:
            System.out.println( "Email ID "+thisCustomer.customerEmail);
            System.out.println( "New ID ");
            id=s.nextLine();
            thisCustomer.customerEmail=id;
            break;
            case 5:
            System.out.println("Enter your old password");
            pass=s.nextLine();
            
            if(thisCustomer.customerPassword.equals(pass))
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
                thisCustomer.customerPassword=newpass;
            }
            
            else
            {
                System.out.println("Wrong password");
                edit(thisCustomer);
            }
            break;
            default:
            System.out.println("Invalid choice");
            edit(thisCustomer);
            break;

        }
    
        cust.remove(old);
        cust.add(thisCustomer);
        
        
    }

    public void prevorders(customer thisCustomer)
    {
        System.out.println( "Your orders: ");
    }

    public void delete(customer thisCustomer)
    {
        Scanner s=new Scanner(System.in);
        
        System.out.println("Are you sure you want to delete your Account?(Y->1/N->0)");
        int ch=s.nextInt();
        if(ch==1)
        {
            cust.remove(thisCustomer);
            customMenu();
        }
        else if(ch==0)
        {
            settingsmenu(thisCustomer);
        }
        else
        {
            System.out.println("Invalid choice");
            delete(thisCustomer);
        }
      

    }

	
}
