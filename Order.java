import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private final long orderNumber;
    private static long counter;
    private List<Item> items;

    public Order (Item...items)
    {
        this.items = new ArrayList<>(List.of(items));

        counter++;
        this.orderNumber = counter;
    }

    public double getTotalValue()
    {
        double total = 0d;

        for(Item item : items)
        {
            total += item.getPrice();
        }

        return total;

    }

    public double getTotalValuePlusVAT()
    {
        double total = 0d;

        for(Item item : items)
        {
            total += item.getPriceWithVAT();
        }

        return total;
    }

    public String getReceipt()
    {
        String result = "Receipt for order #" + orderNumber + "\n" + "-----------\n";
        
        for (Item item : items) 
            {
                result += item.toString() + "\n";

            }


        result += "Total excl . VAT :" + getTotalValue() + "\n";
        result += "Total incl . VAT :" + getTotalValuePlusVAT();
        
        return result; 
    }
}
