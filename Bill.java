import java.util.ArrayList;

public class Bill {
    private double price;
    private double tip;
    private String paymentType;
    private double total;
    private double startOfEachDay;
    private ArrayList<Bill> bills = new ArrayList<Bill>();
    
    public void add(Bill newBill){
        bills.add(newBill);
    }
    
    public void remove(Bill newBill){
        bills.remove(newBill);
    }

    Bill(Item[] order,double price, double tip, String paymentType)
    {
    this.price = price;
    this.tip = tip;
    this.paymentType = paymentType;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getTip(){
        return tip;
    }
    
    public void setTip(double tip){
        this.tip = tip;
    }
    
    
    public double getTotal() {
        return price + tip;
    }

    public String getPaymentType() {
        return paymentType;
    }
    
    public void paymentDetails(double price, double tip, String paymentType){
         switch(paymentType){
             
         }
    }
    
    public String toString(){
        return "Item's ordered: " /* + getOrder()*/ + "\n Price: " + getPrice() + "\n Tip: " + getTip() + "\n Total: " + getTotal() + "\n Payment Type: " + getPaymentType();
    }
}