package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reservation {
    private String name;
    private String phoneNumber;
    private int numOfPeople;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalTime reservedUntil;
    private Table table;
    private String customerId;
    private ArrayList<Reservation> reservations;

//Constructors
    public Reservation() {
    }

    public Reservation(String name, String phoneNumber,int numOfPeople, LocalDate reservationDate,
                        LocalTime reservationTime, Table table, String customerId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numOfPeople = numOfPeople;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        //each reservation is automatically 1 hour long
        this.reservedUntil = reservationTime.plusHours(1);
        this.table = table;
        this.customerId = customerId;
    }




    //Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Table getTable() {
        return table;
    }






    @Override
    public String toString() {
        return String.format("Name: %s.\nPhone number: %s.\nNumber of people: %d\nCustomer Id: %s", name, phoneNumber, numOfPeople, customerId
               +"\nTable Number: "+ table.getId() +"\nReservation date: " + reservationDate.toString() + "\nReservation Time: " + reservationTime.toString()
                + "\nReserved until: " + reservedUntil.toString());
    }

}
