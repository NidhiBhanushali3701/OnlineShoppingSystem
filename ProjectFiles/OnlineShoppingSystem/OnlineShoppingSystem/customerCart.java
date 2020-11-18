package OnlineShoppingSystem;
import java.util.*;
import java.sql.*;

public class customerCart {
    public static Scanner ob = new Scanner(System.in);
    Vector<product> customerCartOfProducts = new Vector<product>();
    Map<customer,product> customerCartProducts = new HashMap<customer,product>();
    customerCart(Vector<product> customerCartOfProducts,Map<customer,product> customerCartProducts)
    {
        this.customerCartOfProducts = customerCartOfProducts;
        this.customerCartProducts = customerCartProducts;
    }
}
