package OnlineShoppingSystem;
import java.util.*;
import java.io.*;
import java.sql.*;

public class MedicalProducts extends product
{
    private static Vector<product> medical = new Vector<product>();
    //static Vector<product> Cart = new Vector<product>();
    private static Enumeration<product> CPEnumeration = medical.elements();
    String prodName[] = {"Med1","Med2 ","Med3","Med4","Med5","Med6","Med7","Med8","Med9","Med10","Med11","Med12","Med13"};
    long prodCost[] = {1299,1399,1149,1999,1299,3499,2999,5999,3499,5999,4499,3999,10999};
    String prodSellerName[] ={"ZARA1","ADIDAS1","PRADA1","PRADA1","AND1","AND1","H&M1","H&M1","CHANEL1","AND1","H&M1","GUCCI1","Dior1"};
    //long prodID[] = {};
    public static Scanner ob = new Scanner(System.in);
    MedicalProducts prod;
    File MedicalProductDescriptionFile;

    public MedicalProducts()
    {
        super();
    }

    public MedicalProducts(long productId,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productId,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
    }

    public void showProduct(customer thisCustomer)
    {
        addMedicalProductDetails();
        int ch,addToBag;
        do{
            System.out.println("\t--->>> WELCOME TO MEDICAL COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+medical.get(i).productName + " \t " +medical.get(i).productCost + " \t " +medical.get(i).productID);
            }
            */
            int i=1;
            for(product printProd:medical)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = medical.elements();
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
                    System.out.println(medical.get(ch-1).productDescription);
                    addToCart(thisCustomer,medical.get(ch-1));
                break;
                case 0:
                    System.out.println("GOING BACK");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }while(ch!=0);
        medical = new Vector<product>();
    } 

    public void search(String productNameToFind) 
    {
        int i,j;
        for(i=0;i<medical.size();i++)
        {
            if(medical.elementAt(i).productName.trim().equalsIgnoreCase(productNameToFind))
            {
                System.out.println(medical.get(i).productName+"\t"+medical.get(i).productCost+"\t"+medical.get(i).productSellerName);
                break;
            }
        }
    }
    
    public void sortHighToLow() 
    {
        int i,j;
        for(i=0;i<medical.size();i++)
        {
            for(j=0;j<medical.size()-1-i;j++)
            {
                if(medical.get(j).productCost<medical.get(j+1).productCost)
                {
                    product temp = medical.get(j);
                    medical.set(j,medical.get(j+1));
                    medical.set(j+1,temp);
                }
            }
        }
    }
    
    public void sortLowToHigh() 
    {
        int i,j;
        for(i=0;i<medical.size();i++)
        {
            for(j=0;j<medical.size()-1-i;j++)
            {
                if(medical.get(j).productCost>medical.get(j+1).productCost)
                {
                    product temp = medical.get(j);
                    medical.set(j,medical.get(j+1));
                    medical.set(j+1,temp);
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
        MedicalProducts prodMain = new MedicalProducts();
        ((MedicalProducts) prodMain).addMedicalProductDetails();
    }

    public void addMedicalProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                MedicalProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\MedicalProductsDescription.txt");
                sc = new Scanner(MedicalProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new MedicalProducts((1000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    medical.add(allProd);
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
            /*
            finally{
                allProd= new MedicalProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                medical.add(allProd);
            }
            */
        }
    }
}
