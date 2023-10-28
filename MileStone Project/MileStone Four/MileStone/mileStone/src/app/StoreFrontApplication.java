package app;

import java.util.Scanner;

public class StoreFrontApplication {

    public static void main(String[] args) {

        // Create an instance of the InventoryManager (intlilize)
        InventoryManager inventoryManager = new InventoryManager();
        // Create an instance of the ShoppingCart (intlilize)
        ShoppingCart shoppingCart = new ShoppingCart();





        //Declare Scanner
        Scanner myScan=new Scanner(System.in);

        //Declare user input variable
        int UserInput = 50;
        //Display a menu of options
        System.out.println("Welcome to GameStore ");
        System.out.println("Please Select an option: ");
        System.out.println(" ");



        //Create a loop that prevents user from choosing other choices

        while (UserInput!=0) {
            System.out.println(" ");
            System.out.println("                                                   Option 1. Browse available products ");
            System.out.println("                                                   Option 2. Added it to Cart ");
            System.out.println("                                                   Option 3. return a Product ");
            System.out.println("                                                   Option 4. View Cart ");
            System.out.println("                                                   Option 5. Empty Cart ");
            System.out.println("                                                   Option 0. Exit Store");

            //Take input of user
            UserInput=myScan.nextInt();

            //Show inventory
            if (UserInput==1) {
                //Initialize store and call inventory
                InventoryManager.initializeInventoryFromJSON("inventory.json");
                InventoryManager.showInventory();

            }
            //buy a product
            else if(UserInput==2) {
                ShoppingCart.FinalAddCart();
            }

            //return a product
            else if (UserInput==3) {
                ShoppingCart.RemoveFromCart();
            }
            //View Cart
            else if (UserInput==4) {
                ShoppingCart.seeCart();
            }
            // Empty Cart
            else if (UserInput==5) {
                ShoppingCart.emptyCart();
            }
            //Exit Store
            else {
                return;
            }



        }






    }
}
