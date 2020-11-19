package OnlineShoppingSystem;

class deliveredThread extends Thread
{
    public void run()
    {
        try
        {
            Thread.sleep(5000);
            System.out.println("\t\t\tSTARTED PACKING YOUR PRODUCTS(S) :)");
            Thread.sleep(7500);
            System.out.println("\t\t\tSHIPPED :)");
            Thread.sleep(10000);
            System.out.println("\t\t\tOUT FOR DELIVERY :)");
            Thread.sleep(15000);
            System.out.println("\t\t\tPRODUCT DELIVERED :)");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("\t\t\t HAPPY SHOPPING ;-)");
        }
    }
}