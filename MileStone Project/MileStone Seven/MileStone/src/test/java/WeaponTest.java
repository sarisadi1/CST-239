import junit.framework.TestCase;
import org.junit.Test;

public class WeaponTest extends TestCase {

    @Test
    public void testWeaponConstructor() {
        // Arrange and Act
        Weapon weapon = new Weapon("First Weapon", "Powerful 1 Weapon", 10.0, 5);

        // Assert
        assertEquals("First Weapon", weapon.getName());
        assertEquals("Powerful 1 Weapon", weapon.getDescription());
        assertEquals(10.0, weapon.getPrice(), 0.001);
        assertEquals(5, weapon.getQuantity());
    }

    @Test
    public void testCompareTo() {
        //Arrange and act
        Weapon weapon1 = new Weapon("First Weapon", "Powerful 1 Weapon", 10.0, 5);
        Weapon weapon2 = new Weapon("Second Weapon", "Powerful 2 Weapon", 20.0, 3);

        // Assertion
        assertTrue(weapon1.compareTo(weapon2) < 0);
        assertTrue(weapon2.compareTo(weapon1) > 0);
        assertEquals(0, weapon1.compareTo(weapon1));
    }

}