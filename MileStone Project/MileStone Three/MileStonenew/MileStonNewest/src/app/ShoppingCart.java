package app;
import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingCart {
	
	//Create a public array list for the cart(This array will store products while they are in cart)
	public static ArrayList<SalableProduct> Cart = new ArrayList <SalableProduct>();
	
			
			
			//Method to add items to cart Done 10/20
			public static void CartAdd(SalableProduct CartProduct) {
				Cart.add(CartProduct);
			        }
			
			
			//Method to add total done 10/20
			 public static double CartTotal() {
			        double Carttotal = 0.0;
			        for (SalableProduct item : Cart) {
			        	Carttotal += item.getPrice();
			        } return Carttotal;
			    }
			 
			//Method to remove stuff from cart Done 10/20
			public void CartRemove(SalableProduct CartProduct) {
			Cart.remove(CartProduct);
			}
			
			//a method to empty cart Done 10/20
			public static void CartEmpty() {
					Cart.clear();
				
				}
			//a method to return stuff in cart
			public static ArrayList<SalableProduct> showCart(){
				return Cart;
			}
			
			
			   
			/////////////////////////////////////////////////Now lets create the logic of those methods
			 
			
			
			
			//The logical method to remove from cart
			public static void RemoveFromCart() {
				//Scanner
				 Scanner myScan = new Scanner(System.in);
				 //Asking what item to remove
			        System.out.print("Select a product ");
			        //Calling the search for name method
			        String productName = myScan.nextLine();

			        ArrayList<SalableProduct> cartItems = showCart();
			        SalableProduct product = findProduct(productName, cartItems);

			        if (product != null) {
			            Cart.remove(product);
			            product.setQuantity(product.getQuantity() + 1);
			            System.out.println("Succfully Removed");
			        } else {
			            System.out.println("Not found, try again");
			        }
			    }
			
			
			//The logical method to empty cart
			public static void emptyCart() {
				System.out.println("Cart is empty");
				CartEmpty();
		       
		    }
			
			//The logical method to see cart
			public static void seeCart() {
		        System.out.println("Your Cart");
		    

		        ArrayList<SalableProduct> cartItems = showCart();
		        double totalPrice = 0;

		        for (SalableProduct product : cartItems) {
		            System.out.println(product.getName());
		            totalPrice += product.getPrice();
		            		
		        }
		        	System.out.println("Total Price: $" + totalPrice);
		        }

		        
		       
		    
				
				//The logical method to add to cart
				public static void FinalAddCart() {
					Scanner myscan = new Scanner(System.in); 
					System.out.println("Select a product ");
					String Name=myscan.nextLine();
					ArrayList<SalableProduct> inventory=InventoryManager.showInventory();
					SalableProduct myProduct = findProduct(Name, inventory); if (myProduct !=null) {
						if (myProduct.getQuantity()>0) {CartAdd(myProduct);myProduct.setQuantity(myProduct.getQuantity()-1); System.out.println("Item in Cart");} 
						else {System.out.println("Not avaliable");}	
					}else {System.out.println("Select right item");}
					
				}
				
				//method to search for name of product
				public static SalableProduct findProduct(String Name, ArrayList<SalableProduct> CartProductTwo) {
					for (SalableProduct CartProduct : CartProductTwo) {
						if (CartProduct.getName().equalsIgnoreCase(Name)) {
							return CartProduct;
						}
					}return null;
					
					
			}
				
				
			}
