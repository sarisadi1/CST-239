package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart<T extends SalableProduct> {
    InventoryManager<T> inventoryManager = new InventoryManager<>();


    public List<T> Cart = new ArrayList<>();

    public void CartAdd(T CartProduct) {
        Cart.add(CartProduct);

    }
    public List<T> showCart() {

        return Cart;
    }

    public double CartTotal() {
        double CartTotal = 0.0;
        for (T item : Cart) {
            CartTotal += item.getPrice();
        }
        return CartTotal;
    }

    public void CartEmpty() {
        Cart.clear();
    }



    public void RemoveFromCart() {
        Scanner myScan = new Scanner(System.in);
        System.out.print("Select a product: ");
        String productName = myScan.nextLine();

        InventoryManager<T> inventory = new InventoryManager<>();
        List<T> cartItems = showCart();
        T product = findProduct(productName, cartItems);

        if (product != null) {
            Cart.remove(product);
            product.setQuantity(product.getQuantity() + 1);
            System.out.println("Successfully Removed from the cart.");
            inventory.addProductToInventory(productName);

            inventoryManager.saveInventoryToJSON("Shopping Cart" , Cart);
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public void emptyCart() {
        InventoryManager<T> inventory = new InventoryManager<>();
        inventory.initializeInventoryFromJSON("inventory.json");
        for (T product : showCart()){
            inventory.addProductToInventory(product.getName());
        }

        inventory.saveInventoryToJSON("inventory.json" , inventory.getInventory());
        CartEmpty();
        inventory.saveInventoryToJSON("Shopping Cart" , showCart());
        System.out.println("Shopping Cart has been cleared. ");
    }

    public void seeCart() {
        if (Cart.isEmpty())
            System.out.println("Your Shopping cart is empty. ");
        else {
            System.out.println( "-------- Your Shopping Cart: ---------");
            for (T items : showCart()){
                System.out.println("Name: " + items.getName());
                System.out.println("Description: "+items.getDescription());
                System.out.println("Price: "+ items.getPrice());
                System.out.println("Quantity: "+items.getQuantity());
            }
        }
    }

    public void addToCart() {
        Scanner myScan = new Scanner(System.in);
        System.out.print("Select a product: ");
        String Name = myScan.nextLine().toLowerCase();

        InventoryManager<T> inventory = new InventoryManager<>();
        T myProduct = findProduct(Name, inventory.getInventory());
        if (myProduct != null) {
            if (myProduct.getQuantity() > 0) {
                CartAdd(myProduct);
                myProduct.setQuantity(myProduct.getQuantity() - 1);
                System.out.println("Item in Cart");
                inventory.returnProduct(Name);
                inventoryManager.saveInventoryToJSON("inventory.json" , inventory.getInventory());
                inventoryManager.saveInventoryToJSON("Shopping Cart" , Cart);

            } else {
                System.out.println("Not available");
            }
        } else {
            System.out.println("Select the right item");
        }

    }

    public T findProduct(String Name, List<T> CartProductTwo) {
        for (T CartProduct : CartProductTwo) {
            if (CartProduct.getName().equalsIgnoreCase(Name)) {
                return CartProduct;
            }
        }
        return null;
    }

    public void updateInventory(){
        inventoryManager.initializeInventoryFromJSON("inventory,json");
    }

}
