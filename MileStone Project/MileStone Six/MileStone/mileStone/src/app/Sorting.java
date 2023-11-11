package app;


import java.util.Comparator;
import java.util.List;

public class Sorting <T extends SalableProduct> {
    ShoppingCart cart = new ShoppingCart();


// Sort a list in ascending order
public void sortAscending(List<T> list)
{
    cart.updateInventory();
    list.sort(Comparator.comparing(SalableProduct::getName));
}
    public void sortAscendingByPrice(List<SalableProduct> list) {
        cart.updateInventory();
        list.sort(Comparator.comparing(SalableProduct::getPrice));

    }


// Sort a list in descending order
public void sortDescending(List<T> list) {
         cart.updateInventory();
//        list.sort(Collections.reverseOrder());
    list.sort(Comparator.comparing(SalableProduct::getName).reversed());
        }
    public void sortDescendingByPrice(List<SalableProduct> list) {
         cart.updateInventory();
        list.sort(Comparator.comparing(SalableProduct::getPrice).reversed());
    }

}
