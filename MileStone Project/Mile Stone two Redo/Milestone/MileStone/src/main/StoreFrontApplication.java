package main;

import java.util.Scanner;

public class StoreFrontApplication {
    
	public static void main(String[] args) {
    	   	
        // Create an instance of the InventoryManager
        InventoryManager inventoryManager = new InventoryManager();
        // Create an instance of the ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();

       //Declare Scanner
        Scanner myScan=new Scanner(System.in);
        
        //Declare user input variable
        int UserInput = 50;
        //Display a menu of options
        System.out.println("Welcome to GameStore ");
        System.out.println("Please Select an option: ");
        
      //Take input of user
    	
        
        //Create a loop that prevents user from choosing other choices
        
        while (UserInput!=0) {
        	System.out.println("Option 1. Browse avaliable products ");
        	System.out.println("Option 2. Buy a product ");
        	System.out.println("Option 3. Cancel a Product ");
        	System.out.println("Option 3. return a Product ");
        	System.out.println("Option 0. Exit Store");
        	
        	
        	//SwitchStament with cases
        	
        		if (UserInput==1) {
        			InventoryManager.showInventory();
        			break;
        	}
        		else if(UserInput==2) {
        			
        		}
        		else if (UserInput==3) {
        		
        			
        		}
        		else if (UserInput==4) {
        			
        		}
        	
        		else {
        			return;
        		}
        	
        	
        	
        }
        
        
        
        
        
        
    }
}