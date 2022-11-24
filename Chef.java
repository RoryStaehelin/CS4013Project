public class Chef extends Person{
    private String chefId;
    private String password;

    public Chef(String name, String phoneNumber, String idNumber, String password)
    {
        super(name, phoneNumber, "chef");
        this.chefId = idNumber;
        this.password = password;
    }

    public String getId() {
        return chefId;
    }

    public String getPassword() {
        return password;
    }
}
