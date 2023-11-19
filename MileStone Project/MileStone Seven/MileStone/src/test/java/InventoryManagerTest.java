import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;


public class InventoryManagerTest<T extends SalableProduct> extends TestCase {

    InventoryManager<T> inventory = new InventoryManager<>();

    // Getter testing
    @Test
    public void testGetInventoryTest(){
        // Arrange
        inventory.initializeInventoryFromJSON("inventory.json");
        List<T> testing = inventory.getInventory() ;

        // Assert
        assertNotNull(testing);
        assertEquals(0 , testing.size());

    }


    @Test
    public void testShowInventory() {
        // Arrange
        StringBuilder expectedOutput = new StringBuilder();

        // creating the expected output
        inventory.initializeInventoryFromJSON("inventory.json");
        for (T product : inventory.getInventory()) {
            expectedOutput.append("Name: ").append(product.getName()).append("\n");
            expectedOutput.append("Description: ").append(product.getDescription()).append("\n");
            expectedOutput.append("Price: ").append(product.getPrice()).append("\n");
            expectedOutput.append("Quantity: ").append(product.getQuantity()).append("\n\n");
        }

        String expectedString = expectedOutput.toString();

        // the output of the code should be like this
        String actualOutput = "";

        // Assert
        assertEquals(expectedString,actualOutput);
    }



    @Test
    public void testAddProductToInventory() {

        // value before adding product
        inventory.initializeInventoryFromJSON("inventory.json");
        int result1 = 0 ;
        for (T inv : inventory.getInventory()){
            if (inv.getName().equals("First Weapon"))
                result1 = inv.getQuantity();
        }

        int result2=0;
        // Actual value
        inventory.addProductToInventory("First Weapon");
        for (T inv : inventory.getInventory()){
            if (inv.getName().equals("First Weapon"))
                result2 = inv.getQuantity();
        }

        // assertion
        assertEquals(result1+0 , result2);
    }

    @Test
    public void testReturnProduct() {
        inventory.initializeInventoryFromJSON("inventory.json");
        int result1 = 1 ;
        for (T inv : inventory.getInventory()){
            if (inv.getName().equals("First Weapon"))
                result1 = inv.getQuantity();
        }

        int result2=0;
        // Actual value
        inventory.removeProduct("First Weapon");
        for (T inv : inventory.getInventory()){
            if (inv.getName().equals("First Weapon"))
                result2 = inv.getQuantity();
        }

        // assertion
        assertEquals(result1-1 , result2);

    }


}