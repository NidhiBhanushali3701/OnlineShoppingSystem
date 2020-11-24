package OnlineShoppingSystem;

class deliveredThread  extends Thread
{
    int flagDelivered=0;
    private Thread t;
    String threadName;
    customer thisCustomer=new customer();

    deliveredThread(int flagDelivered)
    {
        this.threadName="DELIVERY THREAD";
        //this.thisCustomer=thisCustomer;
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
            System.out.println("\t\t\tSTARTED PACKING YOUR PRODUCTS(S) :)");
            Thread.sleep(7500);
            System.out.println("\t\t\tSHIPPED :)");
            Thread.sleep(10000);
            System.out.println("\t\t\tOUT FOR DELIVERY :)");
            Thread.sleep(15000);
            System.out.println("\t\t\tPRODUCT DELIVERED :)");
            thisCustomer.customerDeliveryStatus=1;
            flagDelivered=1;
            checkStatus(thisCustomer,flagDelivered);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("\t\t\t HAPPY SHOPPING ;-)");
            //or else change status here :)
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