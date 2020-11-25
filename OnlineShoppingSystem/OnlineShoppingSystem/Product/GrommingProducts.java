package OnlineShoppingSystem.Product;
import java.util.*;
import java.io.*;
import java.sql.*;
import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.TnE.*;

public class GrommingProducts extends product
{
    public GrommingProducts()
    {
        super();
    }

    public GrommingProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }


    Vector<product> gromming = new Vector<product>();
    public static Scanner ob = new Scanner(System.in);
    GrommingProducts prod;
    File GrommingProductDescriptionFile;

    String prodName[] = {"LOTIONS","OILS","SOAP","FACEWASH","SHAMPOO","CONDITIONER","PASTE","TOOTH BRUSH","FACIAL MASKS","FACIAL KITS","NAIL PAINTS","ACCESSORIES","WIPES"};
    long prodCost[] = {1299,1399,1149,1999,1299,3499,2999,5999,3499,5999,4499,3999,10999};
    String prodSellerName[] ={"VASLINE","DOVE","DOVE","C&C","DOVE","DOVE","CLOSE UP","ORAL B","C&C","VLCC","NYKAA","Dior","J&J"};

    public void showProduct(customer thisCustomer)
    {
        addGrommingProductDetails();
        int ch,addToBag;
        do{
            System.out.println("\t--->>> WELCOME TO GROMMING COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+gromming.get(i).productName + " \t " +gromming.get(i).productCost + " \t " +gromming.get(i).productID);
            }
            */
            System.out.println("\n\t\t "+" "+"   "+"PRODUCT NAME"+ " \t" +"PRICE"+ " \t " +"BRAND NAME");
            int i=1;
            for(product printProd:gromming)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = gromming.elements();
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
                    System.out.println(gromming.get(ch-1).productDescription);
                    System.out.println("\t Do You want to add it to : \n   1. CART \n   2. WISHLIST \n   0. NONE ");
                    switch(ob.nextInt())
                    {
                        case 1:
                            addToCart(thisCustomer,gromming.get(ch-1));
                        break;
                        case 2:
                            addToWishList(thisCustomer,gromming.get(ch-1));
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
        gromming = new Vector<product>();
    } 

    public void search(String productNameToFind) 
    {
        int i,flag=0;
        for(i=0;i<gromming.size();i++)
        {
            if(gromming.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
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
                System.out.println(gromming.get(i).productName+"\t"+gromming.get(i).productCost+"\t"+gromming.get(i).productSellerName);
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
        for(i=0;i<gromming.size();i++)
        {
            for(j=0;j<gromming.size()-1-i;j++)
            {
                if(gromming.get(j).productCost<gromming.get(j+1).productCost)
                {
                    product temp = gromming.get(j);
                    gromming.set(j,gromming.get(j+1));
                    gromming.set(j+1,temp);
                }
            }
        }
    }
    
    public void sortLowToHigh() 
    {
        int i,j;
        for(i=0;i<gromming.size();i++)
        {
            for(j=0;j<gromming.size()-1-i;j++)
            {
                if(gromming.get(j).productCost>gromming.get(j+1).productCost)
                {
                    product temp = gromming.get(j);
                    gromming.set(j,gromming.get(j+1));
                    gromming.set(j+1,temp);
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
        GrommingProducts prodMain = new GrommingProducts();
        ((GrommingProducts) prodMain).addGrommingProductDetails();
    }

    public void addGrommingProductDetails()
    {
        product allProd;
        Scanner sc;
        String[] prodStr;
        for(int i=0;i<13;i++)
        {
            try
            {
                GrommingProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\Product\\ProductsDescription.csv");
                sc = new Scanner(GrommingProductDescriptionFile);
                while(sc.hasNextLine())
                {
                    prodStr=sc.nextLine().split(",");
                    if(prodStr[0].equals("productID"))
                    {
                        continue;
                    }
                    else
                    {
                        if(Integer.parseInt(prodStr[0])==(3000+i+1))
                        {
                            allProd= new GrommingProducts((3000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],prodStr[1]);
                            gromming.add(allProd);
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
                allProd= new GrommingProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                gromming.add(allProd);
            }
            */
        }
    }

}
