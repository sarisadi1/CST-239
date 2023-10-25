package main;

public class SalableProduct {

	//common products to sell(make them private so other clases dont mess with the value)
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	//create a constructor to intialize the variables
	 SalableProduct(String name, String description, double price,int quantity){
		this.name=name;
		this.description=description;
		this.price=price;
		this.quantity=quantity;
	}
	 
	 /////////////////////////////Create getters 
	 
	 //Get name getter
	 public String getName() {
		 return name;
		 }
	 //Get description getter
	 public String getDescription() {
		 return description;
	 }
	 //Get price getter
	 public double getPrice() {
		 return price;
	 }
	 //Get quantity getter
	 public int getQuantity() {
		 return quantity;
	 }
	 
	 /////////////////////////////Create Setters
	 
	 //Set name setter
	 public void setName(String name) {
		 this.name=name;
	 }
	 //Set description setter
	 public void setDescription(String description) {
		 this.description=description;
	 }
	 //Set price setter
	 public void setPrice(double price) {
		 this.price=price;
	 }
	 //set quantity setter
	 public void setQuantity(int quantity ) {
		 this.quantity=quantity;
	 }
	 
	 
	}


