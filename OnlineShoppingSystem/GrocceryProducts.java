package OnlineShoppingSystem;
import java.util.*;
import java.io.*;
import java.sql.*;

public class groceryProducts extends product
{
    public groceryProducts()
    {
        super();
    }

    public groceryProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    private static Vector<product> grocery = new Vector<product>();
    private static Enumeration<product> CPEnumeration = grocery.elements();
    String prodName[] = {" COOKING OIL       ","  PULSES   ","  FRUITS AND VEGETABLES    ","  WHEAT      ","  DRY FRUITS     ","  RICE      ","  BISCUITS AND SNACKS ","  COLD DRINKS  ","  TEA       ","  COFFEE       ","  MILK    ","  BREAD    ","  INSTANT NOODLES  ",};
    long prodCost[] = {250,220,400,200,350,250,80,50,60,75,25,50,30};
    String prodSellerName[] ={"FORTUNE","ORGANIC TATTVA","HARVEST FARMS","AASHIRWAAD","FARMOWN","KOHINOOR","BRITANNIA","THUMBS UP","SOCIETY","NESCAFE","AMUL","ENGLISH OVEN","MAGGI"};
    public static Scanner ob = new Scanner(System.in);
    groceryProducts prod;
    File groceryProductDescriptionFile;

    public void showProduct(customer thisCustomer)
    {
        addgroceryProductDetails();
        int ch,addToBag;
        do{
            System.out.println("\t--->>> WELCOME TO grocery COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+grocery.get(i).productName + " \t " +grocery.get(i).productCost + " \t " +grocery.get(i).productID);
            }
            */
            int i=1;
            for(product printProd:grocery)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = grocery.elements();
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
                    System.out.println(grocery.get(ch-1).productDescription);
                    addToCart(thisCustomer,grocery.get(ch-1));
                case 0:
                    System.out.println("GOING BACK");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }while(ch!=0);
        grocery = new Vector<product>();
    } 

    public void search(String productNameToFind) {
         

    }
    
    public void sortHighToLow() {
         

    }
    
    public void sortLowToHigh() {
         

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
                /*CPEnumeration = customerCart.elements();
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
        GroceryProducts prodMain = new groceryProducts();
        ((GroceryProducts) prodMain).addgroceryProductDetails();
    }

    public void addgroceryProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                groceryProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\groceryProductsDescription.txt");
                sc = new Scanner(groceryProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new groceryProducts((4000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    grocery.add(allProd);
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
            /*
            finally{
                allProd= new groceryProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                grocery.add(allProd);
            }
            */
        }
    }
}
