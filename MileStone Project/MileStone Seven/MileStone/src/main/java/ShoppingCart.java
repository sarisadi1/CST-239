import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

   public class ShoppingCart<T extends SalableProduct> {

        public List<T> cart = new ArrayList<>();


         public void cartAdd(T CartProduct) {
        cart.add(CartProduct);
    }

         // getter
         public List<T> showCart() {

                return cart;
         }

           // Total amount of the products in the cart
            public double cartTotal() {
                 double CartTotal = 0.0;
                  for (T item : cart) {
                      CartTotal += (item.getPrice()* item.getQuantity());
                  }
              return CartTotal;
            }


            // removing product from the cart and adding it in the inventory
            public void removeFromCart() {
             Scanner myScan = new Scanner(System.in);
             System.out.print("Select a product: ");
             String productName = myScan.nextLine();

             InventoryManager<T> inventory = new InventoryManager<>();
             inventory.initializeInventoryFromJSON("inventory.json");

             List<T> cartItems = showCart();

             //if the product is in the cart
             T product = findProduct(productName, cartItems);

             // checking if the product is in the inventory
             T product2 = findProduct(productName, inventory.getInventory());

            if (product != null) {
                //if the product is already in the inventory simply adding the quantity otherwise adding new product
                if (product2 != null)
                    inventory.addProductToInventory(productName);
                else
                    inventory.getInventory().add(product);

                //if there is only 1 product present then simply have to remove it otherwise reducing the quantity
                if (product.getQuantity()==1)
                    cart.remove(product);
                else
                    for (T cartProduct : showCart()){
                        if (cartProduct.getName().equalsIgnoreCase(product.getName()))
                            cartProduct.setQuantity(cartProduct.getQuantity()-1);
                    }



            System.out.println("Successfully Removed from the cart.");

            // Saving file
            inventory.saveInventoryToJSON("Shopping Cart.json" , showCart());
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public void emptyCart() {
        InventoryManager<T> inventory = new InventoryManager<>();

        //Shifting products to inventory.json
        for (T product : showCart()){
            inventory.addProductToInventory(product.getName());
        }

        //Saving inventory.json with additional products
        inventory.saveInventoryToJSON("inventory.json" , inventory.getInventory());

        // Clearing the cart
        cart.clear();

        // saving the empty cart
        inventory.saveInventoryToJSON("Shopping Cart.json" , showCart());
        System.out.println("Shopping Cart has been cleared. ");
    }

    // Displaying the products in the cart
    public void seeCart() {
        if (cart.isEmpty())
            System.out.println("Your Shopping cart is empty. ");
        else {
            System.out.println( "-------- Your Shopping Cart: ---------");
            for (T items : showCart()){
                System.out.println("Name: " + items.getName());
                System.out.println("Description: "+items.getDescription());
                System.out.println("Price: "+ items.getPrice());
                System.out.println("Quantity: "+items.getQuantity());
            }

            System.out.println("Total Amount: "+cartTotal());
        }
    }

    public void addToCart() {
        Scanner myScan = new Scanner(System.in);
        InventoryManager<T> inventory = new InventoryManager<>();
        inventory.initializeInventoryFromJSON("inventory.json");

        if (inventory.getInventory().isEmpty())
            System.out.println("Inventory is empty");
        else {
        System.out.print("Select a product: ");
        String Name = myScan.nextLine().toLowerCase();

        // Checking whether the product is available or not
        T myProduct = findProduct(Name, inventory.getInventory());

        // Checking whether the product already in the cart
        T myProduct2 = findProduct(Name, showCart());

            if (myProduct != null ) {

                // if product is greater than 1 then simply we reduce the quantity from inventory.json
                if (myProduct.getQuantity() > 0) {
                    if (myProduct.getQuantity()>1)
                        inventory.removeProduct(Name);
                    else
                        inventory.getInventory().remove(myProduct);  // if the quantity is 1 removing the product

                    //if the product is not already in the shopping cart
                    if(myProduct2 == null){
                        cartAdd(myProduct);
                        myProduct.setQuantity((myProduct.getQuantity()+1) - myProduct.getQuantity());}
                    else {
                        myProduct2.setQuantity(myProduct2.getQuantity()+1);  //if it's already in the cart
                    }
                    System.out.println("Item in Cart");


                    inventory.saveInventoryToJSON("Shopping Cart.json", showCart());

                }  else {
                    System.out.println("Not available");
                }
            } else {
                System.out.println("Select the right item");
            }
        }
    }


    // finding whether the product is available or not
    public T findProduct(String Name, List<T> CartProductTwo) {
        for (T CartProduct : CartProductTwo) {
            if (CartProduct.getName().equalsIgnoreCase(Name)) {
                return CartProduct;
            }
        }
        return null;
    }
}
