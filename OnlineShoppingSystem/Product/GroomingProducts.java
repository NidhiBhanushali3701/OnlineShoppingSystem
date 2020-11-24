package OnlineShoppingSystem.Product;
import java.util.*;
import java.io.*;
import OnlineShoppingSystem.Customer.*;
import OnlineShoppingSystem.TnE.*;

public class GroomingProducts extends product
{
    public GroomingProducts()
    {
        super();
    }

    public GroomingProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }


    Vector<product> Grooming = new Vector<product>();
    Enumeration<product> CPEnumeration = Grooming.elements();
    String prodName[] = {"LOTIONS","OILS","SOAP","FACEWASH","SHAMPOO","CONDITIONER","PASTE","TOOTH BRUSH","FACIAL MASKS","FACIAL KITS","NAIL PAINTS","ACCESSORIES","WIPES"};
    long prodCost[] = {1299,1399,1149,1999,1299,3499,2999,5999,3499,5999,4499,3999,10999};
    String prodSellerName[] ={"VASLINE","DOVE","DOVE","C&C","DOVE","DOVE","CLOSE UP","ORAL B","C&C","VLCC","NYKAA","Dior","J&J"};
    public static Scanner ob = new Scanner(System.in);
    GroomingProducts prod;
    File GroomingProductDescriptionFile;
    

    public void showProduct(customer thisCustomer)
    {
        addGroomingProductDetails();
        int ch;
        do{
            System.out.println("\t--->>> WELCOME TO Grooming COLLECTION ");
            
            System.out.println("\n\t\t "+" "+"   "+"PRODUCT NAME"+ " \t" +"PRICE"+ " \t " +"BRAND NAME");
            int i=1;
            for(product printProd:Grooming)
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
                    System.out.println(Grooming.get(ch-1).productDescription);
                    System.out.println("\t Do You want to add it to : \n   1. CART \n   2. WISHLIST \n   0. NONE ");
                    switch(ob.nextInt())
                    {
                        case 1:
                            addToCart(thisCustomer,Grooming.get(ch-1));
                        break;
                        case 2:
                            addToWishList(thisCustomer,Grooming.get(ch-1));
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
        Grooming = new Vector<product>();
    } 

    public void search(String productNameToFind) 
    {
        int i,flag=0;
        for(i=0;i<Grooming.size();i++)
        {
            if(Grooming.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
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
                System.out.println(Grooming.get(i).productName+"\t"+Grooming.get(i).productCost+"\t"+Grooming.get(i).productSellerName);
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
        for(i=0;i<Grooming.size();i++)
        {
            for(j=0;j<Grooming.size()-1-i;j++)
            {
                if(Grooming.get(j).productCost<Grooming.get(j+1).productCost)
                {
                    product temp = Grooming.get(j);
                    Grooming.set(j,Grooming.get(j+1));
                    Grooming.set(j+1,temp);
                }
            }
        }
    }
    
    public void sortLowToHigh() 
    {
        int i,j;
        for(i=0;i<Grooming.size();i++)
        {
            for(j=0;j<Grooming.size()-1-i;j++)
            {
                if(Grooming.get(j).productCost>Grooming.get(j+1).productCost)
                {
                    product temp = Grooming.get(j);
                    Grooming.set(j,Grooming.get(j+1));
                    Grooming.set(j+1,temp);
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
        GroomingProducts prodMain = new GroomingProducts();
        ((GroomingProducts) prodMain).addGroomingProductDetails();
    }

    public void addGroomingProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                GroomingProductDescriptionFile = new File("C:\\Users\\user\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\Product\\GroomingProductsDescription.txt");
                sc = new Scanner(GroomingProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new GroomingProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    Grooming.add(allProd);
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
           
        }
    }
}