package app;

import java.util.Scanner;

public class StoreFrontApplication {



    public static void main(String[] args) {

                // Create an instance of the InventoryManager and ShoppingCart
                InventoryManager<SalableProduct> inventoryManager = new InventoryManager<>();


                ShoppingCart<SalableProduct> shoppingCart = new ShoppingCart<>();
                  Sorting<SalableProduct> sorting = new Sorting<>();


        inventoryManager.initializeInventoryFromJSON("inventory.json");

                // Declare Scanner
                Scanner myScan = new Scanner(System.in);

                // Declare user input variable
                int userInput = 50;

                // Display a menu of options
                System.out.println("Welcome to GameStore ");
                System.out.println("Please select an option:");
                System.out.println(" ");

                // Create a loop to prevent the user from choosing other choices
                while (userInput != 0) {
                    System.out.println(" ");
                    System.out.println("												Option 1: Browse available products");
                    System.out.println("												Option 2: Add a product to the Cart");
                    System.out.println("												Option 3: Return a product from the Cart");
                    System.out.println("												Option 4: View Cart");
                    System.out.println("												Option 5: Empty Cart");
                    System.out.println("												Option 6: Sort Products by Name (Ascending)");
                    System.out.println("												Option 7: Sort Products by Price (Ascending)");
                    System.out.println("												Option 8: Sort Products by Name (Descending)");
                    System.out.println("												Option 9: Sort Products by Price (Descending)");
                    System.out.println("												Option 0: Exit Store");
                    System.out.println("												Select an option: ");

                    // Take input from the user
                    userInput = myScan.nextInt();

                    // Show inventory
                    if (userInput == 1) {
                        inventoryManager.initializeInventoryFromJSON("inventory.json");
                        inventoryManager.showInventory();
                    }
                    //buy a product
                    else if(userInput==2) {
//                        System.out.println(inventoryManager.showInventory());
                    	shoppingCart.FinalAddCart();
                    }

                    //return a product
                   else if (userInput==3) {
                	   shoppingCart.RemoveFromCart();
                   }
                    // View Cart
                    else if (userInput == 4) {
                        shoppingCart.seeCart();
                    }
                    // Empty Cart
                    else if (userInput == 5) {
                        shoppingCart.emptyCart();
                    } else if (userInput == 6) {
                        // Sort products by name in ascending order
                        sorting.sortAscending(inventoryManager.inventory);
                        System.out.println("Products sorted by name (ascending):");
                        inventoryManager.showInventory();
                    } else if (userInput == 7) {
                        // Sort products by price in ascending order
                        sorting.sortAscendingByPrice(inventoryManager.inventory);
                        System.out.println("Products sorted by price (descending):");
                        inventoryManager.showInventory();}
                    else if (userInput == 8) {
                        // Sort products by name in descending order

                        System.out.println("Products sorted by name (ascending):");
                     sorting.sortDescending(inventoryManager.inventory);
                        inventoryManager.showInventory();
                    } else if (userInput == 9) {
                        // Sort products by price in descending order

                        System.out.println("Products sorted by price (descending):");
                        sorting.sortDescendingByPrice(inventoryManager.inventory);
                        inventoryManager.showInventory();
                    }
                    // Exit Store
                    else if (userInput == 0) {
                        System.out.println("Thank you for shopping! Saving your cart to a JSON file...");
                        // Save the cart to a JSON file
                        inventoryManager.saveInventoryToJSON("userCart.json");
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        }


//
//        // Create an instance of the InventoryManager (initialize)
//        InventoryManager = new InventoryManager();
//        // Create an instance of the ShoppingCart (initialize)
//        ShoppingCart = new ShoppingCart();
//
//
//
//
//
//        //Declare Scanner
//        Scanner myScan=new Scanner(System.in);
//
//        //Declare user input variable
//        int UserInput = 50;
//        //Display a menu of options
//        System.out.println("Welcome to GameStore ");
//        System.out.println("Please Select an option: ");
//        System.out.println(" ");
//
//
//
//        //Create a loop that prevents user from choosing other choices
//
//        while (UserInput!=0) {
//            System.out.println(" ");
//            System.out.println("                                                   Option 1. Browse available products ");
//            System.out.println("                                                   Option 2. Added it to Cart ");
//            System.out.println("                                                   Option 3. return a Product ");
//            System.out.println("                                                   Option 4. View Cart ");
//            System.out.println("                                                   Option 5. Empty Cart ");
//            System.out.println("                                                   Option 0. Exit Store");
//
//            //Take input of user
//            UserInput=myScan.nextInt();
//
//            //Show inventory
//            if (UserInput==1) {
//                //Initialize store and call inventory
//                InventoryManager.initializeInventoryFromJSON("inventory.json");
//                InventoryManager.showInventory();
//
//            }
//            //buy a product
//            else if(UserInput==2) {
//                ShoppingCart.FinalAddCart();
//            }
//
//            //return a product
//            else if (UserInput==3) {
//                ShoppingCart.RemoveFromCart();
//            }
//            //View Cart
//            else if (UserInput==4) {
//                ShoppingCart.seeCart();
//            }
//            // Empty Cart
//            else if (UserInput==5) {
//                ShoppingCart.emptyCart();
//            }
//            //Exit Store
//            else {
//                return;
//            }
//
//
//
//        }
//
//
//
//
//
//
//    }
//}
