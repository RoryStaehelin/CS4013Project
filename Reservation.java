import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Reservation class is used to allow customers and resturant staff
 * to create reservations for tables between certain times.
 * @author killian
 */
public class Reservation {
//Private data fields    
    private String name;
    private String phoneNumber;
    private int numOfPeople;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalTime reservedUntil;
    private int table;
    
//constructor for reservations
    public Reservation(String name, String phoneNumber, int numOfPeople, LocalDate reservationDate,
                       LocalTime reservationTime, int table) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numOfPeople = numOfPeople;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        //each reservation is automatically 1 hour long
        this.reservedUntil = reservationTime.plusHours(1);
        this.table = table;
        System.out.printf("Reservation confirmed for %d people on %s at %s", numOfPeople, reservationDate, reservationTime);
    }

//Accessor methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public LocalDate getDate() {
        return reservationDate;
    }

    public LocalTime getTime() {
        return reservationTime;
    }

    public int getTable() {
        return table;
    }

    public LocalTime getReservedUntil()
    {
        return reservedUntil;
    }

}
