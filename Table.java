package org.example;

public class Table {
    private int id;
    private int capacity;
    private boolean isFree;


    public Table(int id, int capacity, Boolean isFree) {
        this.id = id;
        this.capacity = capacity;
        this.isFree = isFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }


    @Override
    public String toString() {
        return String.format("TableId: %s.\nTable capacity: %d.\nTable is free: %b", id, capacity, isFree);
    }

    

    


}
