import java.io.IOException;
import java.util.Scanner;

public class StoreFrontApplication {
    public static void main(String[] args) throws IOException {

                // Create an instance of the InventoryManager,Sorting  and ShoppingCart
                InventoryManager<SalableProduct> inventoryManager = new InventoryManager<>();

                ShoppingCart<SalableProduct> shoppingCart = new ShoppingCart<>();
                  Sorting<SalableProduct> sorting = new Sorting<>();



                // Declare Scanner
                Scanner myScan = new Scanner(System.in);

                // Declare user input variable
                int userInput = 10;

                // Display a menu of options
                System.out.println("------------Welcome to GameStore------------ ");
                System.out.println("Please select an option:");
                System.out.println(" ");

                // Create a loop to prevent the user from choosing other choices
                while (userInput != 0) {
                    System.out.println(" ");
                    System.out.println("Option 1: Browse available products");
                    System.out.println("Option 2: Add a product to the Cart");
                    System.out.println("Option 3: Return a product from the Cart");
                    System.out.println("Option 4: View Cart");
                    System.out.println("Option 5: Empty Cart");
                    System.out.println("Option 6: Sort Products by Name (Ascending)");
                    System.out.println("Option 7: Sort Products by Price (Ascending)");
                    System.out.println("Option 8: Sort Products by Name (Descending)");
                    System.out.println("Option 9: Sort Products by Price (Descending)");
                    System.out.println("Option 0: Exit Store");
                    System.out.println("Select an option: ");

                    // Take input from the user
                    userInput = myScan.nextInt();

                    // Show inventory
                    if (userInput == 1) {
                        inventoryManager.initializeInventoryFromJSON("inventory.json");
                        inventoryManager.showInventory();
                        inventoryManager.getInventory().clear();
                    }
                    //buy a product
                    else if(userInput==2) {
                          shoppingCart.addToCart();
                }

                  //return a product
                   else if (userInput==3) {
                        shoppingCart.removeFromCart();
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
                        System.out.println("1. Available products\n2. Products in the cart");
                        int option = myScan.nextInt();
                        if (option==2){
                            System.out.println("Shopping Cart Products sorted by name (ascending):");
                            sorting.sortAscending(shoppingCart.showCart());
                            shoppingCart.seeCart();
                            inventoryManager.saveInventoryToJSON("Shopping Cart.json" , shoppingCart.showCart());}
                        else {
                            System.out.println("Available Products sorted by name (ascending):");
                            inventoryManager.initializeInventoryFromJSON("inventory.json");
                            sorting.sortAscending(inventoryManager.getInventory());
                            inventoryManager.showInventory();
                            inventoryManager.saveInventoryToJSON("inventory.json" , inventoryManager.getInventory());
                            inventoryManager.getInventory().clear();
                        }

                    } else if (userInput == 7) {
                        // Sort products by price in ascending order

                        System.out.println("1. Available products\n2. Products in the cart");
                        int option = myScan.nextInt();
                        if (option == 2) {
                            System.out.println("Shopping Cart Products sorted by price (descending):");
                            sorting.sortAscendingByPrice(shoppingCart.showCart());
                            shoppingCart.seeCart();
                            inventoryManager.saveInventoryToJSON("Shopping Cart.json", shoppingCart.showCart());
                        } else {
                            System.out.println("Available Products sorted by name (ascending):");
                            inventoryManager.initializeInventoryFromJSON("inventory.json");
                            sorting.sortAscendingByPrice(inventoryManager.getInventory());
                            inventoryManager.showInventory();
                            inventoryManager.saveInventoryToJSON("inventory.json", inventoryManager.getInventory());
                            inventoryManager.getInventory().clear();
                        }
                    }
                    else if (userInput == 8) {
                        // Sort products by name in descending order
                        System.out.println("1. Available products\n2. Products in the cart");
                        int option = myScan.nextInt();

                        if (option==2){
                        System.out.println("Shopping Cart Products sorted by name (ascending):");
                     sorting.sortDescending(shoppingCart.showCart());
                        shoppingCart.seeCart();
                        inventoryManager.saveInventoryToJSON("Shopping Cart.json" , shoppingCart.showCart());
                        } else {
                            System.out.println("Available Products sorted by name (ascending):");
                            inventoryManager.initializeInventoryFromJSON("inventory.json");
                            sorting.sortDescending(inventoryManager.getInventory());
                            inventoryManager.showInventory();
                            inventoryManager.saveInventoryToJSON("inventory.json", inventoryManager.getInventory());
                            inventoryManager.getInventory().clear();
                        }

                    }
                    else if (userInput == 9) {
                        // Sort products by price in descending order
                            System.out.println("1. Available products\n2. Products in the cart");
                            int option = myScan.nextInt();

                            if (option==2){
                        System.out.println("Shopping Cart Products sorted by price (descending):");
                        sorting.sortDescendingByPrice(shoppingCart.showCart());
                        shoppingCart.seeCart();
                        inventoryManager.saveInventoryToJSON("Shopping Cart.json" , shoppingCart.showCart());
                            } else {
                                System.out.println("Available Products sorted by name (ascending):");
                                inventoryManager.initializeInventoryFromJSON("inventory.json");
                                sorting.sortDescendingByPrice(inventoryManager.getInventory());
                                inventoryManager.showInventory();
                                inventoryManager.saveInventoryToJSON("inventory.json", inventoryManager.getInventory());
                                inventoryManager.getInventory().clear();
                            }

                    }
                    // Exit Store
                    else if (userInput == 0) {
                        System.out.println("Thank you for shopping! Saving your cart");
                        // Save the cart to a JSON file
                        inventoryManager.saveInventoryToJSON("Shopping Cart.json" , shoppingCart.showCart());
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    System.out.println("--------------------------------------------------------------------");
                }
            }
        }


