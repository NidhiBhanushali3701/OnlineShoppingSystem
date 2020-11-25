package OnlineShoppingSystem.Customer;

import OnlineShoppingSystem.Product.*;
import OnlineShoppingSystem.TnE.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class accountSettings extends customerDashBoard{

    ArrayList<customer> customerList = new ArrayList<customer>();
    File file;
    FileWriter fileWriter;
    FileReader fileReader;
    Scanner scanner;
    Console console = System.console();

    public accountSettings(customer thisCustomer) 
    {
        super(thisCustomer);
    }
    public accountSettings() 
    {
        super();
    }
	public void settingsmenu(customer thisCustomer) {
        Scanner s=new Scanner(System.in);
        int op;
        
            System.out.println("\n\t1) DISPLAY DETAILS\n\t2) EDIT DETAILS\n\t3) SIGN OUT\n\t4) DELETE ACCOUNT\n\t5) BACK\n\t0) EXIT\n");
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
                case 0:
                System.exit(0);
                break;
                default:
                System.out.println("INVALID CHOICE, Try Again.");
            }
        
        

    }

    public void display(customer thisCustomer)
    {
        System.out.println( "\tName   "+thisCustomer.customerName);
        System.out.println( "\tEmail ID   "+thisCustomer.customerEmail);
        System.out.println( "\tPhone Number   "+ thisCustomer.customerPhoneNo);
        System.out.println( "\tAddress   "+thisCustomer.customerAddress);
    }
    
    public void edit(customer thisCustomer)
    {
        customer old=thisCustomer;
        Scanner s=new Scanner(System.in);
        int o=0;
        String name,add,pass,id;
        long p=0;
        String newPass="";
        String oldPass="";
        //char[] oldPass;
        //char[] newPass;
        String regexStr = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"; 
        Pattern pattern = Pattern.compile(regexStr); 
        String[] cStr;
        System.out.println("\nEDIT:\n1) Name\n2) Addrress\n3) Phone Number\n4) Email ID\n5) Password\n0) BACK");
        o=s.nextInt();
        s.nextLine();
        boolean validity=false;
        switch(o)
        {
            case 1:
                System.out.println( " Name\t"+thisCustomer.customerName);
                System.out.print( " New Name\t");
                name=s.nextLine();
                thisCustomer.customerName=name;
            break;
            case 2:
                System.out.println( " Address\t"+thisCustomer.customerAddress);
                System.out.print( " New Address\t");
                add=s.nextLine();
                thisCustomer.customerAddress=add;
            break;
            case 3:
                System.out.println( " Phone Number\t"+thisCustomer.customerPhoneNo);
                while(!validity)
                {
                    try
                    {
                        System.out.print( " New Phone number\t");
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
                oldPass= s.nextLine();
                //oldPass = console.readPassword("Password : ");
                if(thisCustomer.customerPassword.equals(oldPass))
                {
                    while(!validity)
                    {
                        try
                        {
                            System.out.println( "New Password ");
                            newPass=s.nextLine();
                            //newPass = console.readPassword("Password : ");
                            Matcher matcher = pattern.matcher(newPass);
                            if(!matcher.matches())
                                throw new passwordException("Please enter a valid password(min 8 characters, atleast one uppercase and one lowercase letter, atleast one special character and one number)");
                            else 
                                validity=true;
                        }
                        catch(passwordException e)
                        {
                            System.out.println(e);			
                        }
                    }
                    thisCustomer.customerPassword=newPass;
                }
                
                else
                {
                    System.out.println("Wrong password");
                    edit(thisCustomer);
                }
            break;
            case 0:
                System.out.println("GOING BACK");
            break;
            default:
                System.out.println("Invalid choice".toUpperCase());
                edit(thisCustomer);
            break;
        }
        
        file = new File(pathOfCD);
        try
        {
            scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                cStr= scanner.nextLine().split(",");
                customer customerOB;
                if(cStr[4].equalsIgnoreCase("Email"))//|| cStr[4].equals(thisCustomer.customerEmail))
                {
                    continue;
                }
                else if(Long.parseLong(cStr[1])==thisCustomer.customerID)
                {
                    //customerOB = new customer(thisCustomer.customerName, thisCustomer.customerPhoneNo, thisCustomer.customerCredits, thisCustomer.customerAddress, thisCustomer.customerEmail, thisCustomer.customerPassword, thisCustomer.customerID, thisCustomer.customerTotalBill);
                    //customerList.add(customerOB);
                    //customerOB = thisCustomer;
                    customerList.add(thisCustomer);
                }
                else
                {
                    customerOB = new customer(cStr[2],Long.parseLong(cStr[3]),Long.parseLong(cStr[6]),cStr[5],cStr[4],cStr[7],Long.parseLong(cStr[1]),0);
                    customerList.add(customerOB);
                //SrNo,ID,Name,Phone No,Email,Address,Credits6,Password7,
                }
            }
            fileWriter = new FileWriter(file);
            fileWriter.write("SrNo,ID,Name,Phone No,Email,Address,Credits,Password,\n");
            int j=1;
            for(customer addToCustomerList:customerList)
            {
                fileWriter.write(Integer.toString(j)+","+Long.toString(addToCustomerList.customerID)+","+addToCustomerList.customerName+","+Long.toString(addToCustomerList.customerPhoneNo)+","+addToCustomerList.customerEmail+","+addToCustomerList.customerAddress+","+Long.toString(addToCustomerList.customerCredits)+","+addToCustomerList.customerPassword+",\n");
                j++;
            }
            fileWriter.close();
            customerList.clear();
        }
        catch(Exception exp)
        {
            System.out.println(exp);
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
        String[] cStr;
        System.out.println("Are you sure you want to delete your Account?(Y->1/N->0)");
        int ch=s.nextInt();
        //System.out.println("Please enter your password");
        if(ch==1)
        {
            file = new File(pathOfCD);
            try
            {
                scanner = new Scanner(file);
                while(scanner.hasNextLine())
                {
                    cStr= scanner.nextLine().split(",");
                    if(cStr[4].equalsIgnoreCase("Email") || cStr[4].equals(thisCustomer.customerEmail))
                    {
                        continue;
                    }
                    else
                    {
                    customer customerOB = new customer(cStr[2],Long.parseLong(cStr[3]),Long.parseLong(cStr[6]),cStr[5],cStr[4],cStr[7],Long.parseLong(cStr[1]),0);
                    customerList.add(customerOB);
                    //SrNo,ID,Name,Phone No,Email,Address,Credits6,Password7,
                    }
                }
                fileWriter = new FileWriter(file);
                fileWriter.write("SrNo,ID,Name,Phone No,Email,Address,Credits,Password,\n");
                int j=1;
                for(customer addToCustomerList:customerList)
                {
                    fileWriter.write(Integer.toString(j)+","+Long.toString(addToCustomerList.customerID)+","+addToCustomerList.customerName+","+Long.toString(addToCustomerList.customerPhoneNo)+","+addToCustomerList.customerEmail+","+addToCustomerList.customerAddress+","+Long.toString(addToCustomerList.customerCredits)+","+addToCustomerList.customerPassword+",\n");
                    j++;
                }
                fileWriter.close();
                customerList.clear();
            }
            catch(Exception exp)
            {
                System.out.println(exp);
            }
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