public class Chef extends Person{
    private String idNumber;
    private String password;
    private double salary;

    public Chef(String name, String phoneNumber, String idNumber, String password, double salary){
        super(name, phoneNumber);
        this.idNumber = idNumber;
        this.password = password;
        this.salary = salary;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
        return super.toString() + String.format("ID number: %s\nSalary: %d") ;
    }
}
