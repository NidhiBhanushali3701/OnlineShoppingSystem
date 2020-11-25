package OnlineShoppingSystem.Product;
import java.util.*;
import java.io.*;
import java.sql.*;
import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.TnE.*;

public class GrocceryProducts extends product
{
    public GrocceryProducts()
    {
        super();
    }

    public GrocceryProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    Vector<product> groccery = new Vector<product>();
    public static Scanner ob = new Scanner(System.in);
    GrocceryProducts prod;
    File GrocceryProductDescriptionFile;

    String prodName[] = {" COOKING OIL       ","  PULSES   ","  FRUITS AND VEGETABLES    ","  WHEAT      ","  DRY FRUITS     ","  RICE      ","  BISCUITS AND SNACKS ","  COLD DRINKS  ","  TEA       ","  COFFEE       ","  MILK    ","  BREAD    ","  INSTANT NOODLES  "};
    long prodCost[] = {250,220,400,200,350,250,80,50,60,75,25,50,30};
    String prodSellerName[] ={"FORTUNE","ORGANIC TATTVA","HARVEST FARMS","AASHIRWAAD","FARMOWN","KOHINOOR","BRITANNIA","THUMBS UP","SOCIETY","NESCAFE","AMUL","ENGLISH OVEN","MAGGI"};

    public void showProduct(customer thisCustomer)
    {
        addGrocceryProductDetails();
        int ch,addToBag;
        do{
            System.out.println("\t--->>> WELCOME TO GROCCERY COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+groccery.get(i).productName + " \t " +groccery.get(i).productCost + " \t " +groccery.get(i).productID);
            }
            */
            System.out.println("\n\t\t "+" "+"   "+"PRODUCT NAME"+ " \t" +"PRICE"+ " \t " +"BRAND NAME");
            int i=1;
            for(product printProd:groccery)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = groccery.elements();
            while(CPEnumeration.hasMoreElements())
            {
                System.out.println(CPEnumeration.nextElement().productName + " \t " +CPEnumeration.nextElement().productCost);
            }
            */
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
                    System.out.println(groccery.get(ch-1).productDescription);
                    System.out.println("\t Do You want to add it to : \n   1. CART \n   2. WISHLIST \n   0. NONE ");
                    switch(ob.nextInt())
                    {
                        case 1:
                            addToCart(thisCustomer,groccery.get(ch-1));
                        break;
                        case 2:
                            addToWishList(thisCustomer,groccery.get(ch-1));
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
        groccery = new Vector<product>();
    } 

    public void search(String productNameToFind) 
    {
        int i,flag=0;
        for(i=0;i<groccery.size();i++)
        {
            if(groccery.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
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
                System.out.println(groccery.get(i).productName+"\t"+groccery.get(i).productCost+"\t"+groccery.get(i).productSellerName);
                
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
        for(i=0;i<groccery.size();i++)
        {
            for(j=0;j<groccery.size()-1-i;j++)
            {
                if(groccery.get(j).productCost<groccery.get(j+1).productCost)
                {
                    product temp = groccery.get(j);
                    groccery.set(j,groccery.get(j+1));
                    groccery.set(j+1,temp);
                }
            }
        }
    }
    
    public void sortLowToHigh() 
    {
        int i,j;
        for(i=0;i<groccery.size();i++)
        {
            for(j=0;j<groccery.size()-1-i;j++)
            {
                if(groccery.get(j).productCost>groccery.get(j+1).productCost)
                {
                    product temp = groccery.get(j);
                    groccery.set(j,groccery.get(j+1));
                    groccery.set(j+1,temp);
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
                /*CPEnumeration = customerCart.elements();
                while(CPEnumeration.hasMoreElements())
                {
                    System.out.println(CPEnumeration.nextElement().productName + " \t " +CPEnumeration.nextElement().productCost);
                }*/
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
                /*CPEnumeration = customerWishList.elements();
                while(CPEnumeration.hasMoreElements())
                {
                    System.out.println(CPEnumeration.nextElement().productName + " \t " +CPEnumeration.nextElement().productCost);
                }*/
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
        GrocceryProducts prodMain = new GrocceryProducts();
        ((GrocceryProducts) prodMain).addGrocceryProductDetails();
    }

    public void addGrocceryProductDetails()
    {
        product allProd;
        Scanner sc;
        String[] prodStr;
        for(int i=0;i<13;i++)
        {
            try
            {
                GrocceryProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\Product\\ProductsDescription.csv");
                sc = new Scanner(GrocceryProductDescriptionFile);
                while(sc.hasNextLine())
                {
                    prodStr=sc.nextLine().split(",");
                    if(prodStr[0].equals("productID"))
                    {
                        continue;
                    }
                    else
                    {
                        if(Integer.parseInt(prodStr[0])==(4000+i+1))
                        {
                            allProd= new GrocceryProducts((4000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],prodStr[1]);
                            groccery.add(allProd);
                        }
                    }
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
            /*
            finally{
                allProd= new GrocceryProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                groccery.add(allProd);
            }
            */
        }
    }
}
