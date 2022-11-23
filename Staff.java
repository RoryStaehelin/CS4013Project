public class Staff extends Person{
    private String staffID;
    /*private static int count = 1;*/
    private double salary;
    private String password;
    
    public Staff(){
        
    }
    
    public Staff(String name, String phoneNumber, String staffID,/* int count,*/ double salary, String password){
        super(name, phoneNumber);
        this.staffID = staffID;
        /*this.staffID = count;
        this.count = count++;*/
        this.salary = salary;
        this.password = password;
    }
    
    public String getStaffID(){
        return staffID;
    }
    
    public void setStaffID(String staffID){
        this.staffID = staffID;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean checkPassword(String staffID, String password){
        if(this.staffID.equals(staffID) && this.password.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n Staff ID: " + getStaffID() + "\n Salary: " + getSalary() + "\n Password: " + getPassword();
    }
}
