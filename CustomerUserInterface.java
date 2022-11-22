import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerUserInterface {
    private final String name;
    private final String phoneNumber;
    Restaurant restaurant;

    CustomerUserInterface() throws IOException
    {
        System.out.println("Enter your name:");
        this.name = Restaurant.getInput();
        System.out.println("Enter phone number:");
        this.phoneNumber = Restaurant.getInput();
        System.out.println("Enter restaurant name:");
        restaurant = new Restaurant(Restaurant.getInput());
        this.run();
    }
    void run() throws IOException
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
                case 0 -> exit();
                case 1 -> makeReservation();
                case 2 -> cancelReservation();
                case 3 -> searchForTables();
            }
        }
    }
    void makeReservation()
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
        Reservation reservation = new Reservation(name, phoneNumber, numOfPeople, date, time, table.getId());
        restaurant.makeReservation(reservation);
    }
    void cancelReservation()
    {
        System.out.println("Enter reservation date (dd/mm/yyyy):");
        String stringDate = Restaurant.getInput();
        String[] dateArray = stringDate.split("/");
        LocalDate date = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[0]));
        System.out.println("Enter reservation time (24hr format) (hh:mm):");
        String stringTime = Restaurant.getInput();
        String[] timeArray = stringTime.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
        restaurant.cancelReservation(phoneNumber, date, time);
    }
    void searchForTables()
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Enter number of people:");
        restaurant.searchForTables(Integer.parseInt(Restaurant.getInput()), date, time);
    }
    void exit() throws IOException
    {
        restaurant.saveData();
        restaurant.saveIncome();
    }
}
