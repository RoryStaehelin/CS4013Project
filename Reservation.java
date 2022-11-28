import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private String name;
    private String phoneNumber;
    private int numOfPeople;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalTime reservedUntil;
    private int table;

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
        System.out.printf("Reservation confirmed for %d people on %s at %s\n", numOfPeople, reservationDate, reservationTime);
    }


    //Getters and setters

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