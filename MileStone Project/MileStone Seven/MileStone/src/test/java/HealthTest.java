import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class HealthTest extends TestCase {

    private final String testName;
    private final String testDescription;
    private final double testPrice;
    private final int testQuantity;

    public HealthTest(String testName, String testDescription, double testPrice, int testQuantity) {
        this.testName = testName;
        this.testDescription = testDescription;
        this.testPrice = testPrice;
        this.testQuantity = testQuantity;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"First Health", "Description 1", 10.0, 20},
                {"Second Health", "Description 2", 15.0, 30},
                {"Third Health", "Description 3", 12.0, 25}
        });
    }

    @Test
    public void testParametrizedConstructor() {
        // Arrange
        Health health = new Health(testName, testDescription, testPrice, testQuantity);

        // Act
        String actualName = health.getName();
        String actualDescription = health.getDescription();
        double actualPrice = health.getPrice();
        int actualQuantity = health.getQuantity();

        // Assert
        assertEquals(testName, actualName);
        assertEquals(testDescription, actualDescription);
        assertEquals(testPrice, actualPrice, 0.01); // Allowing for some precision difference
        assertEquals(testQuantity, actualQuantity);
    }

    @Test
    public void testCompareTo() {

        // Arrange
        Health health1 = new Health("First Health", "Powerful 1 Health", 10.0, 5);
        Health health2 = new Health("Second Health", "Powerful 2 Health", 20.0, 3);

        // Assert
        assertTrue(health1.compareTo(health2) < 0);
        assertTrue(health2.compareTo(health1) > 0);
        assertEquals(0, health1.compareTo(health1));
    }

}