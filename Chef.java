/**
 * The chef class is a subclass of the person class.
 * It is used to create and store a chef object
 * @author killian
 */
public class Chef extends Person{
//Private data fields    
    private String chefId;
    private String password;
    
//Chef constructor
    public Chef(String name, String phoneNumber, String idNumber, String password)
    {
        super(name, phoneNumber, "chef");
        this.chefId = idNumber;
        this.password = password;
    }
    
//Accessor methods overriding the methods from person class
    @Override    
    public String getId() {
        return chefId;
    }
    @Override
    public String getPassword() {
        return password;
    }
}
