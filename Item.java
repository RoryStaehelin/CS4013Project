/**
 * Item class is used to create new items for the restaurants
 * @author killian
 */
public class Item {
//Private data fields    
    private String name;
    private String category;
    private String description;
    private double price;
    
//Item constructor
    public Item(String name, String category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
    
//Accessor and Mutator methods
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//to string method to convert item object into a string
    @Override
    public String toString() {
        return String.format("Name: %s\nDescription: %s\nCategory: %s\nPrice: %,.2f", name, description, category, price);
    }
}
