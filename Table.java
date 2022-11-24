import java.util.ArrayList;
/**
 * Table class is used to creat and store the tables of the restaurant
 * as objects.
 * @author killian
 */
public class Table {
//Private data fields    
    private int id;
    private int capacity;
    private boolean isFree;
    private boolean isReady;
    private Restaurant restaurant;
    private Bill bill;
    private ArrayList<Item> order;
    
//Table constructor
    public Table(int id, int capacity, Restaurant restaurant) {
        this.id = id;
        this.capacity = capacity;
        this.isFree = true;
        order = new ArrayList<>();
        bill = new Bill();
        this.restaurant = restaurant;
        isReady = false;
    }
    
//method to create bill for the table    
   public void createBill()
    {
        System.out.println("Enter tip:");
        String tip = Restaurant.getInput();
        this.bill = new Bill(order, Integer.parseInt(tip));
    }    
//Accessor and Mutator methods
    public void setOrder()
    {
        System.out.println(restaurant.getMenu());
        String item = "";
        while (!item.equals("0"))
        {
            System.out.println("Enter item (enter 0 to finish):");
            item = Restaurant.getInput();
            if (!item.equals("0"))
            {
                try
                {
                    order.add(restaurant.menuSearch(item));
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public ArrayList<Item> getOrder()
    {
        return order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Bill getBill()
    {
        return bill;
    }
    
//To string method to convert table object to string
    @Override
    public String toString() {
        return String.format("TableId: %s.\nTable capacity: %d.\nTable is free: %b", id, capacity, isFree);
    }
    
//Methods to change the status of an order
    public boolean isReady()
    {
        return isReady;
    }

    public void setReady(boolean ready)
    {
        isReady = ready;
    }
}
