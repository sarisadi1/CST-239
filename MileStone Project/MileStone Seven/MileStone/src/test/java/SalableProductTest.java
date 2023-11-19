import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runners.Parameterized;

public class SalableProductTest extends TestCase {

    // test for the default constructor
    public void testSalableProduct(){
        var product = new SalableProduct();
        assertNull(product.getName());
        assertNull(product.getDescription());
        assertEquals(0.0 , product.getPrice());
        assertEquals(0 , product.getQuantity());
    }

    @Parameterized.Parameters
        public void parameterizedTestSalableProduct(String name, String description, double price, int quantity) {
            // Arrange
            SalableProduct product = new SalableProduct(name, description, price, quantity);

            // Act & Assert
            assertEquals(name, product.getName());
            assertEquals(description, product.getDescription());
            assertEquals(price, product.getPrice());
            assertEquals(quantity, product.getQuantity());
        }

    @Test
        public void testGetName() {
        // Arrange
        SalableProduct product = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 20);

        // Act & Assert
        assertEquals("First Weapon", product.getName());
    }

    @Test
        public void testGetDescription() {
        // Arrange
        SalableProduct product = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 20);

        // Act & Assert
        assertEquals("Powerful 1 Weapon", product.getDescription());
    }

    @Test
        public void testGetPrice() {
        // Arrange
        SalableProduct product = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 20);

        // Act & Assert
        assertEquals(10.0, product.getPrice());
    }

    @Test
        public void testGetQuantity() {
        // Arrange
        SalableProduct product = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 20);

        // Act & Assert
        assertEquals(20, product.getQuantity());
    }

    @Test
    public void testSetName() {
        // Arrange
        SalableProduct product = new SalableProduct();

        // Act
        product.setName("Bevor");

        // Assert
        assertEquals("Bevor", product.getName());
    }

    @Test
    public void testSetDescription() {
        // Arrange
        SalableProduct product = new SalableProduct();

        // Act
        product.setDescription("Plate armour that covers the front of the neck and chin only");

        // Assert
        assertEquals("Plate armour that covers the front of the neck and chin only", product.getDescription());
    }

    @Test
    public void testSetPrice() {
        // Arrange
        SalableProduct product = new SalableProduct();

        // Act
        product.setPrice(15.0);

        // Assert
        assertEquals(15.0, product.getPrice());
    }

    @Test
    public void testSetQuantity() {
        // Arrange
        SalableProduct product = new SalableProduct();

        // Act
        product.setQuantity(30);

        // Assert
        assertEquals(30, product.getQuantity());
    }


    @Test
        public void testCompareTo() {
            // Create SalableProduct instances
            SalableProduct product1 = new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 22);
            SalableProduct product2 = new SalableProduct("Second Weapon", "Very Powerful 2 Weapon", 30.0, 40);
            SalableProduct product3 = new SalableProduct("First Armor", "amazing Powerful 1 Armor", 50.0, 57);

            // Act
            int result1 = product1.compareTo(product2);
            int result2 = product2.compareTo(product1);
            int result3 = product3.compareTo(product3);

            // Assert
            assertTrue(result1 < 0);
            assertTrue(result2 > 0);
            assertEquals(0, result3);
        }
    }


