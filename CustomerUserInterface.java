import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * CustomerUnserInterface class is used to allow customers to interact with the restuarant reservation 
 * system.
 * @author rory
 */
public class CustomerUserInterface {
//Private data feilds    
    Customer customer;
    Restaurant restaurant;
//Method to run customer user interface asking a customer to enter their details
    CustomerUserInterface() throws IOException
    {
        System.out.println("Enter your name:");
        String name = Restaurant.getInput();
        System.out.println("Enter phone number:");
        String phoneNumber = Restaurant.getInput();
        customer = new Customer(name, phoneNumber);
        System.out.println("Enter restaurant name:");
        restaurant = new Restaurant(Restaurant.getInput());
        this.run();
    }
//Method allowing customers to select whsat function to execute    
    private void run() throws IOException
    {
        int function;
        while (true)
        {
            System.out.println("Select function:");
            System.out.println("(1) Make reservation");
            System.out.println("(2) Cancel reservation");
            System.out.println("(3) Search for tables");
            System.out.println("(0) Exit");
            function = Integer.parseInt(Restaurant.getInput());
            switch (function)
            {
                case 0 -> {
                    exit();
                    return;
                }
                case 1 -> makeReservation();
                case 2 -> cancelReservation();
                case 3 -> searchForTables();
            }
        }
    }
//Method to create a reservation for a certain amount of people and for a  certaion date and time    
    private void makeReservation()
    {
        System.out.println("Enter number of people:");
        int numOfPeople = Integer.parseInt(Restaurant.getInput());
        System.out.println("Enter date (dd/mm/yyyy):");
        String stringDate = Restaurant.getInput();
        String[] dateArray = stringDate.split("/");
        LocalDate date = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[0]));
        System.out.println("Enter time (24hr format) (hh:mm):");
        String stringTime = Restaurant.getInput();
        String[] timeArray = stringTime.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
        Table table = restaurant.searchForTables(numOfPeople, date, time);
        Reservation reservation = new Reservation(customer.getName(), customer.getPhoneNumber(), numOfPeople, date, time, table.getId());
        restaurant.makeReservation(reservation);
    }
//Method to cancel an existing reservation    
    private void cancelReservation()
    {
        System.out.println("Enter reservation date (dd/mm/yyyy):");
        String stringDate = Restaurant.getInput();
        String[] dateArray = stringDate.split("/");
        LocalDate date = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[0]));
        System.out.println("Enter reservation time (24hr format) (hh:mm):");
        String stringTime = Restaurant.getInput();
        String[] timeArray = stringTime.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
        restaurant.cancelReservation(customer.getPhoneNumber(), date, time);
    }
//Method to search for avalabke tables for a certain number of people ata certain times    
    private void searchForTables()
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Enter number of people:");
        restaurant.searchForTables(Integer.parseInt(Restaurant.getInput()), date, time);
    }
//Exiting the customer user interface    
    private void exit() throws IOException
    {
        restaurant.saveData();
    }
}
