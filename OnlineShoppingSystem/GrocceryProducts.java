package OnlineShoppingSystem;
import java.util.*;
import java.io.*;
import java.sql.*;

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

    private static Vector<product> groccery = new Vector<product>();
    private static Enumeration<product> CPEnumeration = groccery.elements();
    String prodName[] = {" TOPS       "," T-SHIRTS   "," SHIRTS     "," PANTS      "," SHORTS     "," GOWNS      "," ONE-PIECES "," PURSES     "," BAGS       ","SHOES       ","SANDALS     ","WATCHES     ","JWELLERY    "};
    long prodCost[] = {1299,1399,1149,1999,1299,3499,2999,5999,3499,5999,4499,3999,10999};
    String prodSellerName[] ={"ZARA","ADIDAS","PRADA","PRADA","AND","AND","H&M","H&M","CHANEL","AND","H&M","GUCCI","Dior"};
    public static Scanner ob = new Scanner(System.in);
    GrocceryProducts prod;
    File GrocceryProductDescriptionFile;

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
                    System.out.println(groccery.get(ch-1).productDescription);
                    addToCart(thisCustomer,groccery.get(ch-1));
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
        int i,j;
        for(i=0;i<groccery.size();i++)
        {
            if(groccery.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
            {
                System.out.println(groccery.get(i).productName+"\t"+groccery.get(i).productCost+"\t"+groccery.get(i).productSellerName);
                break;
            }
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
        GrocceryProducts prodMain = new GrocceryProducts();
        ((GrocceryProducts) prodMain).addGrocceryProductDetails();
    }

    public void addGrocceryProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                GrocceryProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\GrocceryProductsDescription.txt");
                sc = new Scanner(GrocceryProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new GrocceryProducts((4000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    groccery.add(allProd);
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
