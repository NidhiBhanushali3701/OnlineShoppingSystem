package OnlineShoppingSystem;
import java.util.*;
import java.io.*;
import java.sql.*;

public class ClothingProducts extends product
{   
    private static Vector<product> clothing = new Vector<product>();
    private static Enumeration<product> CPEnumeration = clothing.elements();
    String prodName[] = {" TOPS       "," T-SHIRTS   "," SHIRTS     "," PANTS      "," SHORTS     "," GOWNS      ","ONE-PIECES  ","PURSES      ","BAGS        ","SHOES       ","SANDALS     ","WATCHES     ","JWELLERY    "};
    long prodCost[] = {1299,1399,1149,1999,1299,3499,2999,5999,3499,5999,4499,3999,10999};
    String prodSellerName[] ={"ZARA","ADIDAS","PRADA","PRADA","AND","AND","H&M","H&M","CHANEL","AND","H&M","GUCCI","Dior"};
    //long prodID[] = {};
    public static Scanner ob = new Scanner(System.in);
    ClothingProducts prod;
    File ClothingProductDescriptionFile;
    public ClothingProducts()
    {
        super();
        showProduct();
    }

    public ClothingProducts(long productID,long productCost,String productName,long productBuyerID,String productBuyerName,long productSellerID,String productSellerName,String productDescription)
    {
        super(productID,productCost,productName,productBuyerID,productBuyerName,productSellerID,productSellerName,productDescription);
        //showProduct();
    }

    public void showProduct()
    {
        addClothingProductDetails();
        int ch;
        do{
            System.out.println("\t--->>> WELCOME TO CLOTHING COLLECTION ");
            /*
            for(int i=0;i<13;i++)
            {
                System.out.println("\t\t\t"+clothing.get(i).productName + " \t " +clothing.get(i).productCost + " \t " +clothing.get(i).productID);
            }
            */
            int i=1;
            for(product printProd:clothing)
            {
                System.out.println("\t\t "+(i)+". "+printProd.productName + " \t " +printProd.productCost + " \t " + printProd.productSellerName);
                i++;
            }
            
            /*
            CPEnumeration = clothing.elements();
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
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 2:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 3:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 4:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 5:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 6:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 7:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 8:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 9:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 10:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 11:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 12:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 13:
                    System.out.println(clothing.get(ch).productDescription);
                break;
                case 0:
                    System.out.println("GOING BACK");
                break;
                default:
                    System.out.println("INVALID CHOICE \n");
                break;
            }
        }while(ch!=0);
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

    public static void main(String args[]) 
    {
        ClothingProducts prodMain = new ClothingProducts();
        ((ClothingProducts) prodMain).addClothingProductDetails();
    }

    public void addClothingProductDetails()
    {
        product allProd;
        Scanner sc;
        for(int i=0;i<13;i++)
        {
            try
            {
                ClothingProductDescriptionFile = new File("C:\\Users\\Nidhi\\Desktop\\OnlineShoppingSystem\\OnlineShoppingSystem\\ClothingProductsDescription.txt");
                sc = new Scanner(ClothingProductDescriptionFile);
                if(sc.hasNextLine())
                {
                    allProd= new ClothingProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],sc.nextLine());
                    clothing.add(allProd);
                }
            }
            catch(Exception E)
            {
                System.out.println(E);
            }
            /*
            finally{
                allProd= new ClothingProducts((6000+i+1),prodCost[i],prodName[i],0,"",0,prodSellerName[i],"");
                clothing.add(allProd);
            }
            */
        }
    }
}