public class Staff extends Person{
    private String staffId;
    private String password;
    
    public Staff(String name, String phoneNumber, String staffId, String password)
    {
        super(name, phoneNumber, "staff");
        this.staffId = staffId;
        this.password = password;
    }
    
    public String getId(){
        return staffId;
    }
    
    public String getPassword(){
        return password;
    }
}
