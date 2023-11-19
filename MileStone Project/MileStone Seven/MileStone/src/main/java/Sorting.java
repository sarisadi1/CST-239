import java.util.Comparator;
import java.util.List;

public class Sorting <T extends SalableProduct> {

    // Sort a list in ascending order
    public void sortAscending(List<T> list)  // By name
    {
        list.sort(Comparator.comparing(SalableProduct::getName));
    }

    // Prices
    public void sortAscendingByPrice(List<SalableProduct> list) {
        list.sort(Comparator.comparing(SalableProduct::getPrice));
    }


    // Sort a list in descending order
    public void sortDescending(List<T> list) {
        list.sort(Comparator.comparing(SalableProduct::getName).reversed());
    }

    // By prices
    public void sortDescendingByPrice(List<SalableProduct> list) {
        list.sort(Comparator.comparing(SalableProduct::getPrice).reversed());
    }

}
