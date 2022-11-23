public class Chef extends Person{
    private String chefId;
    private String password;
    private double salary;
    
    public Chef(){
    }

    public Chef(String name, String phoneNumber, String idNumber, String password, double salary){
        super(name, phoneNumber);
        this.chefId = chefId;
        this.password = password;
        this.salary = salary;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("ID number: %s\nSalary: %d", chefId, salary) ;
    }
}
