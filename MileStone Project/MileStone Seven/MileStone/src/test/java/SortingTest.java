import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingTest extends TestCase {

    @Test
    public void testSortAscending() {
        // Arrange
        Sorting<SalableProduct> sorting = new Sorting<>();
        List<SalableProduct> productList = new ArrayList<>();
        productList.add(new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));
        productList.add(new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));

        //Code output
        sorting.sortAscending(productList);

        // Assert
        assertEquals("First Weapon", productList.get(0).getName());
        assertEquals("Second Weapon", productList.get(1).getName());
    }

    @Test
    public void testSortAscendingByPrice() {
        // Arrange
        Sorting<SalableProduct> sorting = new Sorting<>();
        List<SalableProduct> productList = new ArrayList<>();
        productList.add(new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));
        productList.add(new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));

        //Code output
        sorting.sortAscendingByPrice(productList);

        // assert
        assertEquals(10.0, productList.get(0).getPrice(), 0.001);
        assertEquals(20.0, productList.get(1).getPrice(), 0.001);
    }

    @Test
    public void testSortDescending() {
        //Arrange
        Sorting<SalableProduct> sorting = new Sorting<>();
        List<SalableProduct> productList = new ArrayList<>();
        productList.add(new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));
        productList.add(new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));

        //Code output
        sorting.sortDescending(productList);

        // Assert
        assertEquals("Second Weapon", productList.get(0).getName());
        assertEquals("First Weapon", productList.get(1).getName());
    }

    @Test
    public void testSortDescendingByPrice() {
        // Arrange
        Sorting<SalableProduct> sorting = new Sorting<>();
        List<SalableProduct> productList = new ArrayList<>();
        productList.add(new SalableProduct("Second Weapon", "Powerful 2 Weapon", 20.0, 1));
        productList.add(new SalableProduct("First Weapon", "Powerful 1 Weapon", 10.0, 1));

        // Code output
        sorting.sortDescendingByPrice(productList);

        // Assert
        assertEquals(20.0, productList.get(0).getPrice(), 0.001);
        assertEquals(10.0, productList.get(1).getPrice(), 0.001);
    }

}