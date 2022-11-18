import java.util.ArrayList;

public class CashPayment extends Bill{
    private double value;
    private String name;
    private static Cash[] cash = { new Cash(0.05, "5 cent"),
                                   new Cash(0.1, "10 cent"),
                                   new Cash(0.2, "20 cent"),
                                   new Cash(0.5, "50 cent"),
                                   new Cash(1, "euro"), 
                                   new Cash(2,"2 euro"),
                                   new Cash(5, "5 euro"),
                                   new Cash(10, "10 euro"),
                                   new Cash(20,"20 euro"),
                                   new Cash(50,"50 euro"),
                                   new Cash(100,"100 euro"),
                                   new Cash(200,"200 euro"),
                                   new Cash(500, "500 euro"),
                                };
    
                                   
    public CashPayment(Item[] order,double price, double tip, String paymentType){
        super(order,price, tip, paymentType);
    }
    
}