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

    public double CartTotal() {
        double CartTotal = 0.0;
        for (T item : Cart) {
            CartTotal += item.getPrice();
        }
        return CartTotal;
    }

    public void CartRemove(T CartProduct) {
        Cart.remove(CartProduct);
    }

    public void CartEmpty() {
        Cart.clear();
    }

    public List<T> showCart() {
        return Cart;
    }

    public void RemoveFromCart() {
        Scanner myScan = new Scanner(System.in);
        System.out.print("Select a product: ");
        String productName = myScan.nextLine();

        List<T> cartItems = showCart();
        T product = findProduct(productName, cartItems);

        if (product != null) {
            Cart.remove(product);
            product.setQuantity(product.getQuantity() + 1);
            System.out.println("Successfully Removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public void emptyCart() {
        System.out.println("Cart is empty");
        CartEmpty();
    }

    public void seeCart() {
        System.out.println("Your Cart");

        List<T> cartItems = showCart();
        double totalPrice = 0;

        for (T product : cartItems) {
            System.out.println(product.getName());
            totalPrice += product.getPrice();
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    public void FinalAddCart() {
        Scanner myScan = new Scanner(System.in);
        System.out.print("Select a product: ");
        String Name = myScan.nextLine().toLowerCase();

        List<T> inventory = inventoryManager.getInventory();
        T myProduct = findProduct(Name, inventory);
        if (myProduct != null) {
            if (myProduct.getQuantity() > 0) {
                CartAdd(myProduct);
                myProduct.setQuantity(myProduct.getQuantity() - 1);
                System.out.println("Item in Cart");
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

}
