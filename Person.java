public class Person {
    private String name;
    private String phoneNumber;
    private String type;

    public Person(String name, String phoneNumber, String type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getId()
    {
        return null;
    }
    public String getPassword()
    {
        return null;
    }

    public String getType()
    {
        return type;
    }
}