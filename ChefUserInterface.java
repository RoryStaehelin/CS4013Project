import java.io.IOException;
import java.util.ArrayList;
/**
 * ChefUserInterface class is used to control the interface for the chefs
 * allowing them to interact with the restaurant.
 * @author rory
 */
public class ChefUserInterface {
//Private data feilds     
    Restaurant restaurant;
    Chef chef;
//Chef user interface constructor    
    ChefUserInterface() throws IOException
    {
        this.logIn();
        System.out.println("Enter restaurant name:");
        restaurant = new Restaurant(Restaurant.getInput());
        this.run();
    }
//Login method to check login details
    private void logIn()
    {
        System.out.println("Do you have an account? (y/n)");
        if (Restaurant.getInput().equals("y"))
        {
            System.out.println("Enter id:");
            String id = Restaurant.getInput();
            System.out.println("Enter password:");
            String password = Restaurant.getInput();
            if (!restaurant.logIn(id, password))
            {
                throw new RuntimeException("Invalid login");
            }
        }
        else
        {
            System.out.println("Enter name:");
            String name = Restaurant.getInput();
            System.out.println("Enter phone number:");
            String phoneNumber = Restaurant.getInput();
            System.out.println("Enter id:");
            String id = Restaurant.getInput();
            System.out.println("Enter password:");
            String password = Restaurant.getInput();
            chef = new Chef(name, phoneNumber, id, password);
            restaurant.addPerson(chef);
        }
    }
//allow chef user to select what functions to execute
    private void run() throws IOException
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
                case 0 -> {
                    exit();
                    return;
                }
                case 1 -> getOrder();
                case 2 -> orderReady();
            }
        }
    }
//get order method    
    private void getOrder()
    {
        System.out.println("Select table:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        ArrayList<Item> order = table.getOrder();
        for (Item item : order)
        {
            System.out.println(item.getName());
        }
    }
//Method to change status of order    
    private void orderReady()
    {
        System.out.println("Select table:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        table.setReady(true);
    }
 //Method to exit chef user interface   
    private void exit() throws IOException
    {
        restaurant.saveData();
    }
}
