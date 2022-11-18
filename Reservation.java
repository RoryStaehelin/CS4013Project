public class Reservation {
    private String name;
    private String phoneNumber;
    private String date;
    private String time;
    private int numberOfPeople;
    private int table;

    Reservation(String name, String phoneNumber)
    {
        Customers.newcustomer(name, phoneNumber);

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}
