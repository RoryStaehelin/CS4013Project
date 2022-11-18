public class Bill {
    private double price;
    private double tip;
    private String paymentType;
    private double total;

    Bill(Item[] order, double tip, String paymentType)
    {

    }

    public double getTotal() {
        return total;
    }

    public String getPaymentType() {
        return paymentType;
    }
}
