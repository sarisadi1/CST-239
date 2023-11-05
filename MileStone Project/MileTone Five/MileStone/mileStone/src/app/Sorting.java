package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting <T extends SalableProduct> {

// Sort a list in ascending order
public void sortAscending(List<T> list) {
    list.sort(Comparator.comparing(SalableProduct::getName));
}
    public void sortAscendingByPrice(List<SalableProduct> list) {
        list.sort(Comparator.comparing(SalableProduct::getPrice));
    }


// Sort a list in descending order
public void sortDescending(List<T> list) {
    List<T> sortedList = new ArrayList<>(list);

//        list.sort(Collections.reverseOrder());
    list.sort(Comparator.comparing(SalableProduct::getName).reversed());
        }
    public void sortDescendingByPrice(List<SalableProduct> list) {
        list.sort(Comparator.comparing(SalableProduct::getPrice).reversed());
    }

// Sort a list based on a custom comparator
public void sortWithComparator(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
        }
}
