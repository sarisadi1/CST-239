import junit.framework.TestCase;
import org.junit.Test;

class ArmorTest extends TestCase {

    @Test
    public void testParametrizedConstructor() {
        // Create an instance of Armor using the parametrized constructor
        Armor armor = new Armor("First Armor", "amazing Powerful 1 Armor", 50.0, 57);

        // Assert the values set by the constructor
        assertEquals("First Armor", armor.getName());
        assertEquals("amazing Powerful 1 Armor", armor.getDescription());
        assertEquals(50.0, armor.getPrice());
        assertEquals(57, armor.getQuantity());
    }

    @Test
    public void testNonParametrizedConstructor() {
        // Create an instance of Armor using the non-parametrized constructor
        Armor armor = new Armor();

        // Assert the default values set by the non-parametrized constructor
        assertEquals(null, armor.getName());
        assertEquals(null, armor.getDescription());
        assertEquals(0.0, armor.getPrice());
        assertEquals(0, armor.getQuantity());
    }

    @Test
    public void testCompareTo() {
        // Create instances of Armor for comparison
        Armor armor1 = new Armor("First Armor", "amazing Powerful 1 Armor", 50.0, 57);
        Armor armor2 = new Armor("Second Armor", "crazy Powerful 2 Armor", 70.0, 80);

        // Test the compareTo method
        int result1 = armor1.compareTo(armor2);
        int result2 = armor2.compareTo(armor1);

        // Assert the comparison results
        assertTrue(result1 < 0);
        assertTrue(result2 > 0);
        assertEquals(0, armor1.compareTo(armor1));
    }


    @org.junit.Test
    public void compareTo() {
    }
}