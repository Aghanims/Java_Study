package ClassNotes;
public class RetailShopping 
{
    public static void main(String[] args)
    {
        RetailItem itemNum1 = new RetailItem(1, "Jacket", 12, 59.95);
        RetailItem itemNum2 = new RetailItem(2, "Designer Jacket", 40, 34.95);
        RetailItem itemNum3 = new RetailItem(3, "Shirt", 20, 24.95);

        itemNum1.itemInformation();
        System.out.println();
        itemNum2.itemInformation();
        System.out.println();
        itemNum3.itemInformation();

        
    }
}
