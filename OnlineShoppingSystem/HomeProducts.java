package OnlineShoppingSystem;
import java.util.*;
import java.sql.*;
import java.io.*;

public class HomeProducts extends product
{
    public HomeProducts()
    {
        super();
    }

    public HomeProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    private static Vector<product> home = new Vector<product>();
    private static Enumeration<product> CPEnumeration = home.elements();
    String prodName[] = {"SOFA","FRAMES","CHAIR","TABLES","SHOW PIECES","STANDS","DINNER TABLE","STOOLS","LADDERS","HOME DECOR","WARDROBES","CLOCKS","BEDS"};
    long prodCost[] = {1299,1399,1149,1999,1299,3499,2999,5999,3499,5999,4499,3999,10999};
    String prodSellerName[] ={"URBAN LADDER","HOMESAKE","WOODSWORTH","WOODSWORTH","URBAN LADDER","HOME STUDIO","STYLE SPA","URBAN LADDER","WOODSWORTH","HOMESAKE","HOME STUDIO","AJANTA","SPRINGTEK"};
    public static Scanner ob = new Scanner(System.in);
    HomeProducts prod;
    File HomeProductDescriptionFile;

    public void showProduct(customer thisCustomer)
    {
        addHomeProductDetails();
        int ch,addToBag;
        do{
            System.out.println("\t--->>> WELCOME TO HOME COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+home.get(i).productName + " \t " +home.get(i).productCost + " \t " +home.get(i).productID);
            }
            */
            int i=1;
            for(product printProd:home)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = home.elements();
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
                    System.out.println(home.get(ch-1).productDescription);
                    addToCart(thisCustomer,home.get(ch-1));
                case 0:
                    System.out.println("GOING BACK");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }while(ch!=0);
        home = new Vector<product>();
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
        HomeProducts prodMain = new HomeProducts();
        ((HomeProducts) prodMain).addHomeProductDetails();
    }

    public void addHomeProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                HomeProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\HomeProductsDescription.txt");
                sc = new Scanner(HomeProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new HomeProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    home.add(allProd);
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
            /*
            finally{
                allProd= new HomeProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                home.add(allProd);
            }
            */
        }
    }
}
