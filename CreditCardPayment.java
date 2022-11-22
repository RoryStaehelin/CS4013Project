
public class CreditCardPayment extends Bill{
    private String cardName;
    private String cardNo;
    private String cardExpDate;
    
    public CreditCardPayment(Item[] order,double price, double tip, String paymentType, String cardName, String cardNo, String cardExpDate){
        this.cardName = cardName;
        this.cardNo = cardNo;
        this.cardExpDate = cardExpDate;
    }
    
    
}