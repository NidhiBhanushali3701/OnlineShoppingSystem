package OnlineShoppingSystem;
import java.util.*;
import java.io.*;
import java.sql.*;

public class ElectronicProducts extends product
{
    public ElectronicProducts()
    {
        super();
    }

    public ElectronicProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    private static Vector<product> electronic = new Vector<product>();
    //static Vector<product> Cart = new Vector<product>();
    private static Enumeration<product> CPEnumeration = electronic.elements();
    String prodName[] = {"PHONES ","TABLETS "," TELEVISION ","OVEN ","FRIGDE ","FANS  "," LIGHTS ","COMPUTER ","LAPTOPS","AIR CONDITIONER ","CAMERA ","SPEAKERS","MUSIC PLAYERS"};
    long prodCost[] = {120000,100000,200000,20000,65000,5000,5000,150000,200000,50000,45000,40000,30000};
    String prodSellerName[] ={"APPLE","ONEPLUS","SONY","LG","SAMSUNG","BAJAJ","BAJAJ","APPLE","APPLE","VOLTAS","CANON","SONY","SAMSUNG"};
    public static Scanner ob = new Scanner(System.in);
    ElectronicProducts prod;
    File ElectronicProductDescriptionFile;

    public void showProduct(customer thisCustomer)
    {
        addElectronicProductDetails();
        int ch,addToBag;
        do{
            System.out.println("\t--->>> WELCOME TO ELECTRONIC COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+electronic.get(i).productName + " \t " +electronic.get(i).productCost + " \t " +electronic.get(i).productID);
            }
            */
            int i=1;
            for(product printProd:electronic)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = electronic.elements();
            while(CPEnumeration.hasMoreElements())
            {
                System.out.println(CPEnumeration.nextElement().productName + " \t " +CPEnumeration.nextElement().productCost);
            }
            */
            System.out.println("\t\t 0. GO BACK");
            System.out.print("   ENTER YOUR CHOICE ");
            ch = ob.nextInt();
            switch(ch)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    System.out.println(electronic.get(ch-1).productDescription);
                    addToCart(thisCustomer,electronic.get(ch-1));
                case 0:
                    System.out.println("GOING BACK");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }while(ch!=0);
        electronic = new Vector<product>();
    } 

    public void search(String productNameToFind) 
    {
        int i,j;
        for(i=0;i<electronic.size();i++)
        {
            if(electronic.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
            {
                System.out.println(electronic.get(i).productName+"\t"+electronic.get(i).productCost+"\t"+electronic.get(i).productSellerName);
                break;
            }
        }
    }
    
    public void sortHighToLow() 
    {
        int i,j;
        for(i=0;i<electronic.size();i++)
        {
            for(j=0;j<electronic.size()-1-i;j++)
            {
                if(electronic.get(j).productCost<electronic.get(j+1).productCost)
                {
                    product temp = electronic.get(j);
                    electronic.set(j,electronic.get(j+1));
                    electronic.set(j+1,temp);
                }
            }
        }
    }
    
    public void sortLowToHigh() 
    {
        int i,j;
        for(i=0;i<electronic.size();i++)
        {
            for(j=0;j<electronic.size()-1-i;j++)
            {
                if(electronic.get(j).productCost>electronic.get(j+1).productCost)
                {
                    product temp = electronic.get(j);
                    electronic.set(j,electronic.get(j+1));
                    electronic.set(j+1,temp);
                }
            }
        }
    }

    public void sortByPopular() {
         

    }

    public void sortByNew() {
         

    }
    public void addToCart(customer thisCustomer,product addToCartProd)
    {
        System.out.print("\t Do You want to add to cart ? [1-Y || 0-N]   ");
        int addToBag=ob.nextInt();
        if(addToBag!=0)
        {
            thisCustomer.customerCart.add(addToCartProd);
            System.out.println("\t Do You Want to view Your Cart ?");
            int viewCart = ob.nextInt();
            if(viewCart!=0)
            {
                /*CPEnumeration = Cart.elements();
                while(CPEnumeration.hasMoreElements())
                {
                    System.out.println(CPEnumeration.nextElement().productName + " \t " +CPEnumeration.nextElement().productCost);
                }*/
                System.out.println("\t>>YOUR CART ");
                int i=1;
                for(product printProd:thisCustomer.customerCart)
                {
                    System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                    i++;
                }
            }
        }
}
    public static void main(String args[]) 
    {
        ElectronicProducts prodMain = new ElectronicProducts();
        ((ElectronicProducts) prodMain).addElectronicProductDetails();
    }

    public void addElectronicProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                ElectronicProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\ElectronicProductsDescription.txt");
                sc = new Scanner(ElectronicProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new ElectronicProducts((5000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    electronic.add(allProd);
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
            /*
            finally{
                allProd= new ElectronicProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                electronic.add(allProd);
            }
            */
        }
    }
}
