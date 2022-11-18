public class Table {
    private int tableNumber;
    private int capacity;
    private boolean reserved = false;
    private Item[] order;
    private boolean orderReady = false;
    private Bill bill;

    Table(int capacity)
    {

    }
    public Item[] getOrder() {
        return order;
    }
    public void setOrder(Item[] order) {
        this.order = order;
    }
    public boolean isOrderReady() {
        return orderReady;
    }
    public void setOrderReady(boolean orderReady) {
        this.orderReady = orderReady;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    public void createBill()
    {

    }
    public Bill getBill()
    {
        return bill;
    }
}
