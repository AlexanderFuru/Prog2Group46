import java.util.List;
import java.util.ArrayList;

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

}
