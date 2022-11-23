public class Person {
    private String name;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.name = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPhone Number: %s\n", name, phoneNumber);
    }
}
