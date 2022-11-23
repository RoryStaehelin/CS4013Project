import java.util.ArrayList;

public class Customer extends Person{
    private String name;
    private String phoneNumber;
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    /*private int customerNo;
    private static int count = 1;*/
    
    public Customer(){
        
    }
    
    public Customer(String name, String phoneNumber/*, int customerNo*/){
        this.name = name;
        this.phoneNumber = phoneNumber;
        /*this.customerNo= count;
        this.count = count++;*/
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    /*public int getCustomerNo(){
        return customerNo;
    }
    
    public void setCustomerNo(int customerNo){
        this.customerNo = customerNo;
    }*/
    
    public ArrayList<Customer> getCustomer(){
        return customers;
    }
    
    public static void setCustomer(ArrayList<Customer> customers){
        Customer.customers = customers;
    }
    
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }
    
    public Customer getCustomer(String phoneNumber){
        for(Customer customer: customers){
            if(customer.phoneNumber.equals(phoneNumber)){
                return customer;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Customer: " + "\n Name: " + getName() + "\n Phone Number: " + getPhoneNumber(); /*"\n Customer Number: " + getCustomerNo();*/
    }
}
