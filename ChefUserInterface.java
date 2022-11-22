import java.io.IOException;
import java.util.ArrayList;

public class ChefUserInterface {
    Restaurant restaurant;
    ChefUserInterface() throws IOException, InterruptedException
    {
        System.out.println("Enter restaurant name:");
        restaurant = new Restaurant(Restaurant.getInput());
        this.run();
    }
    void run() throws IOException, InterruptedException
    {
        int function;
        while (true)
        {
            System.out.println("Select function:");
            System.out.println("(1) Get Order");
            System.out.println("(2) Set order as ready");
            System.out.println("(0) Exit");
            function = Integer.parseInt(Restaurant.getInput());
            switch (function)
            {
                case 0: exit();
                case 1: getOrder();
                case 2: orderReady();
            }
            Thread.sleep(1000);
        }
    }
    void getOrder()
    {
        System.out.println("Select table:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        ArrayList<Item> order = table.getOrder();
        for (Item item : order)
        {
            System.out.println(item.getName());
        }
    }
    void orderReady()
    {
        System.out.println("Select table:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        table.setReady(true);
    }
    void exit() throws IOException
    {
        restaurant.saveData();
        restaurant.saveIncome();
    }
}
