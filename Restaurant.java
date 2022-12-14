// Author: Rory Staehelin 21334161

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Restaurant {
    private String name;
    private ArrayList<Item> menu = new ArrayList<>();
    private ArrayList<Table> tables = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ArrayList<Person> people = new ArrayList<>();
    private double incomeForDay;
    private static Scanner scanner = new Scanner(System.in);


    //Creates new restaurant
    Restaurant() throws IOException {
        boolean finished = false;
        System.out.println("Creating new restaurant...");
        System.out.println("Set name:");
        this.name = getInput();
        System.out.println("Set number of tables:");
        int numberOfTables = Integer.parseInt(getInput());
        for (int i = 1; i <= numberOfTables; i++)
        {
            System.out.printf("Set table %d capacity:", i);
            tables.add(new Table(i, Integer.parseInt(getInput()), this));
        }
        System.out.println("Add menu items (name,category,description,price):");
        while (!finished)
        {
            String item = getInput();
            if (item.equals("d"))
            {
                finished = true;
            }
            else
            {
                String[] itemArray = item.split(",");
                menu.add(new Item(itemArray[0], itemArray[1], itemArray[2], Double.parseDouble(itemArray[3])));
                System.out.println("Type another item, or type 'd' when done...");
            }
        }
        saveData();
        System.out.println("Setup complete");
    }



    //Loads restaurant from csv file
    Restaurant(String restaurantName) throws IOException
    {
        System.out.println("Loading Restaurant");
        this.name = restaurantName;
        String fileName = name +".csv";
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.addAll(Arrays.asList(values));
            }
        }
        int i = 0;
        String type;
        String name;
        String phoneNumber;
        String id;
        String password;
        for (int m = 0; !data.get(m).equals(""); m++)
        {
            type = data.get(m);
            name = data.get(m+1);
            phoneNumber = data.get(m+2);
            id = data.get(m+3);
            password = data.get(m+4);
            m += 4;
            if (type.equals("staff"))
            {
                people.add(new Staff(name, phoneNumber, id, password));
            }
            i = m + 2;
        }


        int j = 0;
        String category;
        String description;
        String price;
        for (; !data.get(i).equals(""); i++)
        {
            name = data.get(i);
            category = data.get(i+1);
            description = data.get(i+2);
            price = data.get(i+3);
            i += 3;
            menu.add(new Item(name, category, description, Double.parseDouble(price)));
            j = i + 2;
        }
        String capacity;
        int k = 0;
        for (; j < data.size() && !data.get(j).equals(""); j++)
        {
            id = data.get(j);
            capacity = data.get(j+1);
            j += 1;
            tables.add(new Table(Integer.parseInt(id), Integer.parseInt(capacity), this));
            k = j + 2;
        }
        String numPeople;
        String dateString;
        String timeString;
        String table;
        for (; k < data.size() && !data.get(k).equals(""); k++)
        {
            name = data.get(k);
            phoneNumber = data.get(k+1);
            numPeople = data.get(k+2);
            dateString = data.get(k+3);
            timeString = data.get(k+4);
            table = data.get(k+5);
            k += 5;
            String[] dateArray = dateString.split("-");
            String[] timeArray = timeString.split(":");
            LocalDate date = LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
            LocalTime time = LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
            reservations.add(new Reservation(name, phoneNumber, Integer.parseInt(numPeople), date, time, Integer.parseInt(table)));
        }
        System.out.println("Setup complete");
    }

    // Add a reservation
    void makeReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }

    // Cancel a reservation
    void cancelReservation(String phoneNumber, LocalDate date, LocalTime time)
    {
        reservations.removeIf(reservation -> reservation.getPhoneNumber().equals(phoneNumber) && reservation.getDate().equals(date) && reservation.getTime().equals(time));
    }

    // Add a member of staff
    void addPerson(Person person)
    {
        people.add(person);
    }

    // Pay a bill
    void payBill(Table t)
    {
        double payment = t.getBill().pay();
        int id = t.getId();
        int capacity = t.getCapacity();
        tables.remove(t);
        tables.add(new Table(id, capacity, this));
        incomeForDay += payment;
    }

    // Search for table for specified number of people and time/date
    Table searchForTables(int number, LocalDate date, LocalTime time)
    {
        ArrayList<Table> adequateTables = new ArrayList<>();
        int lowestCapacity = 1000;
        Table currentTable = null;
        for (Table table : tables)
        {
            if (table.getCapacity() >= number)
            {
                adequateTables.add(table);
            }
        }
        ArrayList<Integer> reservedTables = new ArrayList<>();
        for (Reservation reservation : reservations)
        {
            if (reservation.getTime().compareTo(time) < 0 && reservation.getDate().equals(date) && reservation.getReservedUntil().compareTo(time) > 0)
            {
                reservedTables.add(reservation.getTable());
            }
        }
        for (Table table : adequateTables)
        {
            if (!reservedTables.contains(table.getId()) && table.getCapacity() < lowestCapacity)
            {
                currentTable = table;
                lowestCapacity = table.getCapacity();
            }
        }
        return currentTable;
    }

    // Save data to (Current Restaurant).csv file
    void saveData() throws IOException {
        File file = new File(this.name + ".csv");
        FileWriter fileWriter = new FileWriter(file);
        for (Person person : people)
        {
            fileWriter.append(person.getType());
            fileWriter.append(",");
            fileWriter.append(person.getName());
            fileWriter.append(",");
            fileWriter.append(person.getPhoneNumber());
            fileWriter.append(",");
            fileWriter.append(person.getId());
            fileWriter.append(",");
            fileWriter.append(person.getPassword());
            fileWriter.append(",");
        }
        fileWriter.append(",");
        for (Item item : menu)
        {
            fileWriter.append(item.getName());
            fileWriter.append(",");
            fileWriter.append(item.getCategory());
            fileWriter.append(",");
            fileWriter.append(item.getDescription());
            fileWriter.append(",");
            fileWriter.append(String.valueOf(item.getPrice()));
            fileWriter.append(",");
        }
        fileWriter.append(",");
        for (Table table : tables)
        {
            fileWriter.append(String.valueOf(table.getId()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(table.getCapacity()));
            fileWriter.append(",");
        }
        fileWriter.append(",");
        for (Reservation reservation : reservations)
        {
            fileWriter.append(reservation.getName());
            fileWriter.append(",");
            fileWriter.append(reservation.getPhoneNumber());
            fileWriter.append(",");
            fileWriter.append(String.valueOf(reservation.getNumOfPeople()));
            fileWriter.append(",");
            fileWriter.append(reservation.getDate().toString());
            fileWriter.append(",");
            fileWriter.append(reservation.getTime().toString());
            fileWriter.append(",");
            fileWriter.append(String.valueOf(reservation.getTable()));
            fileWriter.append(",");
        }
        fileWriter.append(",");
        fileWriter.close();
        saveIncome();
    }

    // Save income to statistics.csv
    void saveIncome() throws IOException {
        LocalDate date = LocalDate.now();
        File file = new File("statistics.csv");
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(date.toString());
        fileWriter.append(",");
        fileWriter.append(String.valueOf(incomeForDay));
        fileWriter.append("\n");
        fileWriter.close();
    }

    // Returns menu
    ArrayList<Item> getMenu()
    {
        return menu;
    }

    // Returns table specified by number
    Table searchTable(String tableNum)
    {
        return searchTable(Integer.parseInt(tableNum));
    }

    // Returns table specified by number
    Table searchTable(int tableNum)
    {
        Table table = null;
        for (Table t : tables)
        {
            if (t.getId() == tableNum)
            {
                table = t;
            }
        }
        if (table == null)
        {
            throw new RuntimeException("Invalid Table");
        }
        return table;
    }

    // Gets user input
    static String getInput()
    {
        return scanner.nextLine();
    }

    // Returns specified menu item
    public Item menuSearch(String item)
    {
        for (Item i : menu)
        {
            if (i.getName().equals(item))
            {
                return i;
            }
        }
        throw new RuntimeException("Invalid Item");
    }

    // Logs in using id and password
    public boolean logIn(String id, String password)
    {
        for (Person person : people)
        {
            if (id.equals(person.getId()))
            {
                return person.getPassword().equals(password);
            }
        }
        return false;
    }
}
