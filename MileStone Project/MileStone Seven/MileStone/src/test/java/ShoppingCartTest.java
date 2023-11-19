import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest<T extends SalableProduct> extends TestCase {

    private ShoppingCart<T> cart;


    @Test
    public void testCartAdd() {
        SalableProduct product1 = new SalableProduct("Product1", "Description1", 20.0, 2);
        SalableProduct product2 = new SalableProduct("Product2", "Description2", 30.0, 1);

        cart.cartAdd((T)product1);
        cart.cartAdd((T) product2);

        List<SalableProduct> expectedCart = new ArrayList<>();
        expectedCart.add(product1);
        expectedCart.add(product2);

        assertEquals(expectedCart, cart.showCart());
    }

    // getter
    @Test
    public void testShowCart() {
        SalableProduct product1 = new SalableProduct("Product1", "Description1", 20.0, 2);
        SalableProduct product2 = new SalableProduct("Product2", "Description2", 30.0, 1);
        cart.cartAdd((T)product1);
        cart.cartAdd((T) product2);

        List<SalableProduct> expectedCart = new ArrayList<>();
        expectedCart.add(product1);
        expectedCart.add(product2);

        assertEquals(expectedCart, cart.showCart());
    }

    @Test
    public void testCartTotal() {
        SalableProduct product1 = new SalableProduct("Product1", "Description1", 20.0, 2);
        SalableProduct product2 = new SalableProduct("Product2", "Description2", 30.0, 1);

        cart.cartAdd((T)product1);
        cart.cartAdd((T) product2);

        double expectedTotal = 70.0;

        assertEquals(expectedTotal, cart.cartTotal());
    }


    @Before
    public void setUp() {
        cart = new ShoppingCart<>();
        InventoryManager<SalableProduct> inventory = new InventoryManager<>();
        inventory.initializeInventoryFromJSON("inventory.json");
    }

    @Test
    public void testRemoveFromCart() {

        // creating a product "First Weapon" in the cart
        SalableProduct product = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1);

       // Act
        cart.cartAdd((T)product);
        int s1 = cart.showCart().size();

        cart.showCart().remove(product);
        int s2 = cart.showCart().size();

        // Assertion
        assertTrue(s1>s2);
        assertFalse(cart.showCart().contains(product));
    }

    @Test
    public void testEmptyCart() {
        ShoppingCart<SalableProduct> cart = new ShoppingCart<>();
        // Assuming some products in the cart
        cart.cartAdd(new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));
        cart.cartAdd(new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));

        cart.emptyCart();

        assertTrue(cart.showCart().isEmpty());
    }

    @Test
    public void testSeeCart() {
        // Assuming some products in the cart
        cart.cartAdd((T)new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));
        cart.cartAdd((T)new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));

        // Output should be like this
        String expectedOutput = "-------- Your Shopping Cart: ---------\n" +
                "Name: First Weapon\nDescription: Powerful 1 Weapon\nPrice: 10.0\nQuantity: 1\n" +
                "Name: Second Weapon\nDescription: Powerful 2 Weapon\nPrice: 20.0\nQuantity: 1\n" +
                "Total Amount: 30.0\n";

        // output by the code
        StringBuilder actualOutput = new StringBuilder();
        actualOutput.append("-------- Your Shopping Cart: ---------\n");

        for (SalableProduct item : cart.showCart()) {
            actualOutput.append("Name: ").append(item.getName()).append("\n");
            actualOutput.append("Description: ").append(item.getDescription()).append("\n");
            actualOutput.append("Price: ").append(item.getPrice()).append("\n");
            actualOutput.append("Quantity: ").append(item.getQuantity()).append("\n");
        }

        actualOutput.append("Total Amount: ").append(cart.cartTotal()).append("\n");
        String actualOutputString = actualOutput.toString();

        // Assert
        assertEquals(expectedOutput, actualOutputString);
    }

    @Test
    public void testAddToCart() {
        //Arrange
        SalableProduct product = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1);

        // Act
        int s1 = cart.showCart().size();

        cart.cartAdd((T)product);
        int s2 = cart.showCart().size();

        // Assert
        assertFalse(cart.showCart().isEmpty());
        assertTrue(cart.showCart().contains(product));
        assertTrue(s1<s2);
    }

    @Test
    public void testFindProduct() {
        // Assuming some products in the cart
        cart.cartAdd((T)new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));
        cart.cartAdd((T)new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));

        // Act
        SalableProduct foundProduct = cart.findProduct("First Weapon", cart.showCart());

        // Assert
        assertNotNull(foundProduct);
        assertEquals("First Weapon", foundProduct.getName());
    }




}