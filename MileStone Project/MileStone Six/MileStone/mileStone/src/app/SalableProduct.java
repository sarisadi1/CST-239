package app;

public class SalableProduct implements Comparable{

    //common products to sell(make them private so other classes don't mess with the value)
    private String name;
    private String description;
    private double price;
    private int quantity;

    public SalableProduct() {

    }

    //create a constructor to initialize the variables
    SalableProduct(String name, String description, double price,int quantity){
        this.name=name;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
    }

    /////////////////////////////Create getters

    //Getter method to get name (Since it is private)
    public String getName() {
        return name;
    }
    //Getter method to get Description (Since it is private)
    public String getDescription() {
        return description;
    }
    //Getter method to get Price (Since it is private)
    public double getPrice() {
        return price;
    }
    //Getter method to get Quantity (Since it is private)
    public int getQuantity() {
        return quantity;
    }

    /////////////////////////////Create Setters

    //Setter method to set Name (Since it is private)
    public void setName(String name) {
        this.name=name;
    }
    //Setter method to set Description (Since it is private)
    public void setDescription(String description) {
        this.description=description;
    }
    //Setter method to set Price (Since it is private)
    public void setPrice(double price) {
        this.price=price;
    }
    //Setter method to set Quantity (Since it is private)
    public void setQuantity(int quantity ) {
        this.quantity=quantity;
    }


    /////////////////////////////Some other needed methods

    //Method to compare products
    public int compareTo(SalableProduct other) {
        // Compare products by their names
        return this.name.compareTo(other.name);
    }





}
