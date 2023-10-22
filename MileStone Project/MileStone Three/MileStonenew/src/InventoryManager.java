package main;

//import array list 
import java.util.ArrayList;

//Inventory manger class
public class InventoryManager {
   
	//Create a public array list for the inventory
	public ArrayList<SalableProduct> inventory = new ArrayList<SalableProduct>();
	
	
	//Create first weapon
	Weapon FirstWeapon=new Weapon(null, null, 0, 0);
	//Create second weapon
	Weapon SecondWeapon=new Weapon(null,null,0,0);
	
	//Create First Armor
	Armor FirstArmor=new Armor(null, null, 0, 0);
	
	//Create Second Armor
	Armor SecondArmor=new Armor(null, null, 0, 0);
	
	//Create First health option
	Health FirstHealth=new Health(null, null, 0, 0);
	//Create Second health option
	Health SecondHealth=new Health(null, null, 0, 0);
	
	//Add weapon objects to the array list
	
	inventory.add(FirstWeapon);
	inventory.add(SecondWeapon);
	////Add Armor objects to the array list
	inventory.add(FirstArmor);
	inventory.add(SecondArmor);
	////Add Health objects to the array list
	inventory.add(FirstHealth);
	inventory.add(SecondHealth);
	
	
	//////////////////////////////////////////////////////////////
	
	//Create a method to show Inventory
	public static void showInventory() {
		//To be filled
	}
	
	//Create a method to buy a product and pass to cart
	public static void buyProduct(ShoppingCart cart) {
		//To be filled
	}
	
	//Create a method to cancel a Salable product
	public static void CancelProduct(ShoppingCart cart) {
		//To be filled
	}
	
	//Create a method to return a Salable product
		public static void ReturnProduct(ShoppingCart cart) {
		//To be filled
		}
	
}