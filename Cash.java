public class Cash{
    private double value;
    private String name;
    
    public Cash(double aValue, String aName){
        this.value = aValue;
        this.name = aName;
    }
    
    public double getValue(){
        return value;
    }
    
    public String getName(){
        return name;
    }
}