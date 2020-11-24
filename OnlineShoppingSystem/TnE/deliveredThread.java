package OnlineShoppingSystem.TnE;
import OnlineShoppingSystem.Customer.*;
public class deliveredThread extends Thread
{
    int flagDelivered=0;
    private Thread t;
    String threadName;
    public customer thisCustomer=new customer();

    public deliveredThread(int flagDelivered)
    {
        this.threadName="DELIVERY THREAD";
       
        checkStatus(thisCustomer,flagDelivered);
    }
    public deliveredThread() {
        super();
    }
	public void run()
    {
        try
        {
            Thread.sleep(7500);
            System.out.println("\n\t\t\tSTARTED PACKING YOUR PRODUCTS(S) :)");
            Thread.sleep(7500);
            System.out.println("\n\t\t\tSHIPPED :)");
            Thread.sleep(10000);
            System.out.println("\n\t\t\tOUT FOR DELIVERY :)");
            Thread.sleep(15000);
            System.out.println("\n\t\t\tPRODUCT DELIVERED :)");
            thisCustomer.customerDeliveryStatus=1;
            flagDelivered=1;
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("\n\t\t\t HAPPY SHOPPING ;-)");         
        }
    }
    public void checkStatus(customer thisCustomer,int flagDelivered)
    { 
        this.flagDelivered=flagDelivered;
        if(flagDelivered!=0 || thisCustomer.customerDeliveryStatus!=0)
        {
            for(int pI=0;pI<thisCustomer.customerCart.size();pI++)
            {
                thisCustomer.prevOrders.add(thisCustomer.customerOrders.get(pI));
            }
            thisCustomer.customerOrders.clear();
        }
    }
}