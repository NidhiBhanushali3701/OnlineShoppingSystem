package OnlineShoppingSystem.Product;
import java.util.*;
import java.io.*;
import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.TnE.*;

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

    Vector<product> home = new Vector<product>();
    Enumeration<product> CPEnumeration = home.elements();
    String prodName[] = {"SOFA","FRAMES","CHAIR","TABLES","SHOW PIECES","STANDS","DINNER TABLE","STOOLS","LADDERS","HOME DECOR","WARDROBES","CLOCKS","BEDS"};
    long prodCost[] = {20000,1200,2000,9000,1999,5000,11000,1000,2499,3999,2999,3999,10999};
    String prodSellerName[] ={"URBAN LADDER","HOMESAKE","WOODSWORTH","WOODSWORTH","URBAN LADDER","HOME STUDIO","STYLE SPA","URBAN LADDER","WOODSWORTH","HOMESAKE","HOME STUDIO","AJANTA","SPRINGTEK"};
    public static Scanner ob = new Scanner(System.in);
    HomeProducts prod;
    File HomeProductDescriptionFile;

    public void showProduct(customer thisCustomer)
    {
        addHomeProductDetails();
        int ch;
        do{
            System.out.println("\t--->>> WELCOME TO HOME COLLECTION ");
            
            System.out.println("\n\t\t "+" "+"   "+"PRODUCT NAME"+ " \t" +"PRICE"+ " \t " +"BRAND NAME");
            int i=1;
            for(product printProd:home)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            System.out.println("\n\t\t 14. SEARCH");
            System.out.println("\t\t 15. SORT [HIGH TO LOW]");
            System.out.println("\t\t 16. SORT [LOW TO HIGH]");
            System.out.println("\n\t\t 0. GO BACK");
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
                    System.out.println("\t Do You want to add it to : \n   1. CART \n   2. WISHLIST \n   0. NONE ");
                    switch(ob.nextInt())
                    {
                        case 1:
                            addToCart(thisCustomer,home.get(ch-1));
                        break;
                        case 2:
                            addToWishList(thisCustomer,home.get(ch-1));
                        break;
                        case 0:
                            System.out.println("GOING BACK");
                        break;
                        default:
                            System.out.println("INVALID CHOICE \n");
                        break;
                    }
                break;
                case 14:
                    System.out.println("ENTER PRODUCT NAME YOU ARE SERACHING ");
                    ob.nextLine();
                    search(ob.nextLine());
                break;
                case 15:
                    sortHighToLow();
                break;
                case 16:
                    sortLowToHigh();
                break;
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

    public void search(String productNameToFind) 
    {
        int i,flag=0;
        for(i=0;i<home.size();i++)
        {
            if(home.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
            {
                flag=1;
                break;
            }
        }
        try{
            if(flag==0)
            {
                throw new ProductNotFoundException("\n\tPRODUCT NOT FOUND :/\n");
            }
            else
            {
                System.out.println(home.get(i).productName+"\t"+home.get(i).productCost+"\t"+home.get(i).productSellerName);
            }
        }
        catch(Exception e)
        {
            System.out.println(e+"\n");
        }
    }
    
    public void sortHighToLow() 
    {
        int i,j;
        for(i=0;i<home.size();i++)
        {
            for(j=0;j<home.size()-1-i;j++)
            {
                if(home.get(j).productCost<home.get(j+1).productCost)
                {
                    product temp = home.get(j);
                    home.set(j,home.get(j+1));
                    home.set(j+1,temp);
                }
            }
        }
    }
    
    public void sortLowToHigh() 
    {
        int i,j;
        for(i=0;i<home.size();i++)
        {
            for(j=0;j<home.size()-1-i;j++)
            {
                if(home.get(j).productCost>home.get(j+1).productCost)
                {
                    product temp = home.get(j);
                    home.set(j,home.get(j+1));
                    home.set(j+1,temp);
                }
            }
        }
    }

    public void addToCart(customer thisCustomer,product addToCartProd)
    {
        System.out.print("\t Do You want to add to Cart ? [1-Y || 0-N]\t");
        int addToBag=ob.nextInt();
        if(addToBag!=0)
        {
            thisCustomer.customerCart.add(addToCartProd);
            System.out.print("\t Do You Want to view Your Cart ?\t");
            int viewCart = ob.nextInt();
            if(viewCart!=0)
            {
              
                System.out.println("\t >>> YOUR CART \n");
                int i=1;
                for(product printProd:thisCustomer.customerCart)
                {
                    System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                    i++;
                }
            }
        }
        System.out.println("");
    }
    public void addToWishList(customer thisCustomer,product addToWLProd)
    {
        System.out.print("\t Do You want to add to WishList ? [1-Y || 0-N]\t");
        int addToWL=ob.nextInt();
        if(addToWL!=0)
        {
            thisCustomer.customerWishList.add(addToWLProd);
            System.out.print("\t Do You Want to view Your WishList ?\t");
            int viewCart = ob.nextInt();
            if(viewCart!=0)
            {
               
                System.out.println("\t >>> YOUR WISHLIST \n");
                int i=1;
                for(product printProd:thisCustomer.customerWishList)
                {
                    System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                    i++;
                }
            }
        }
        System.out.println("");
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
                HomeProductDescriptionFile = new File("C:\\Users\\user\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\Product\\HomeProductsDescription.txt");
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
            
        }
    }
}