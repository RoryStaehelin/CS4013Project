import java.util.ArrayList;

public class Bill {
    private double price;
    private double tip;
    Bill(ArrayList<Item> order, double tip)
    {
        this.tip = tip;
        for (Item item : order)
        {
            price += item.getPrice();
        }
    }

    Bill(){}
    public double pay()
    {
        return price + tip;
    }
}