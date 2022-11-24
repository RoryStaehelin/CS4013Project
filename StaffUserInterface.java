import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class StaffUserInterface {
    Restaurant restaurant;
    Staff staff;
    StaffUserInterface() throws IOException
    {
        this.logIn();
        int function;
        System.out.println("Select function:");
        System.out.println("(1) Create restaurant");
        System.out.println("(2) Load restaurant");
        function = Integer.parseInt(Restaurant.getInput());
        if (function == 1)
        {
            restaurant = new Restaurant();
        }
        else
        {
            System.out.println("Enter restaurant name:");
            restaurant = new Restaurant(Restaurant.getInput());
        }
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
            System.out.println("(4) Set order");
            System.out.println("(5) Get order");
            System.out.println("(6) Check if ready");
            System.out.println("(7) Create bill");
            System.out.println("(8) Get bill");
            System.out.println("(9) Make payment");
            System.out.println("(10) Show statistics");
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
                case 4 -> setOrder();
                case 5 -> getOrder();
                case 6 -> isReady();
                case 7 -> createBill();
                case 8 -> getBill();
                case 9 -> makePayment();
                case 10 -> showStatistics();
            }
        }
    }
    void makeReservation()
    {
        System.out.println("Enter name:");
        String name = Restaurant.getInput();
        System.out.println("Enter phone number:");
        String phoneNum = Restaurant.getInput();
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
        Reservation reservation = new Reservation(name, phoneNum, numOfPeople, date, time, table.getId());
        restaurant.makeReservation(reservation);
    }
    void cancelReservation()
    {
        System.out.println("Enter phone number:");
        String phoneNum = Restaurant.getInput();
        System.out.println("Enter reservation date (dd/mm/yyyy):");
        String stringDate = Restaurant.getInput();
        String[] dateArray = stringDate.split("/");
        LocalDate date = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[0]));
        System.out.println("Enter reservation time (24hr format) (hh:mm):");
        String stringTime = Restaurant.getInput();
        String[] timeArray = stringTime.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
        restaurant.cancelReservation(phoneNum, date, time);
    }
    void searchForTables()
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println("Enter number of people:");
        Table table = restaurant.searchForTables(Integer.parseInt(Restaurant.getInput()), date, time);
        if (table == null)
        {
            System.out.println("No tables available");
        }
        else
        {
            System.out.printf("Table %d is available", table.getId());
        }
    }
    void setOrder()
    {
        System.out.println("Enter table number:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        table.setOrder();
    }
    void getOrder()
    {
        System.out.println("Enter table number:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        System.out.println(table.getOrder());
    }
    void isReady()
    {
        System.out.println("Enter table number:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        if (table.isReady())
        {
            System.out.println("Order is ready");
        }
        else
        {
            System.out.println("Order is not ready");
        }
    }
    void createBill()
    {
        System.out.println("Enter table number:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        table.createBill();
    }
    void getBill()
    {
        System.out.println("Enter table number:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        Bill bill = table.getBill();
        System.out.println(bill);
    }
    void makePayment()
    {
        System.out.println("Enter table number:");
        Table table = restaurant.searchTable(Restaurant.getInput());
        restaurant.payBill(table);
    }
    void showStatistics()
    {
        System.out.println("Select (1)total stats or (2)specific period:");
        if (Restaurant.getInput().equals("2"))
        {
            System.out.println("Select start date (dd/mm/yyyy):");
            String startDateString = Restaurant.getInput();
            String[] startDateArray = startDateString.split("/");
            System.out.println("Select end date (dd/mm/yyyy):");
            String endDateString = Restaurant.getInput();
            String[] endDateArray = endDateString.split("/");
            LocalDate startDate = LocalDate.of(Integer.parseInt(startDateArray[2]), Integer.parseInt(startDateArray[1]), Integer.parseInt(startDateArray[0]));
            LocalDate endDate = LocalDate.of(Integer.parseInt(endDateArray[2]), Integer.parseInt(endDateArray[1]), Integer.parseInt(endDateArray[0]));
            Statistics statistic = new Statistics(startDate, endDate);
            System.out.println(statistic.getStatistic());
        }
        else
        {
            Statistics statistic = new Statistics();
            System.out.println(statistic.getStatistic());
        }
    }
    void exit() throws IOException
    {
        restaurant.saveData();
    }
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
            staff = new Staff(name, phoneNumber, id, password);
            restaurant.addPerson(staff);
        }
    }
}
