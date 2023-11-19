public class Weapon extends SalableProduct implements Comparable {

    //Add a constructor
    Weapon(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);

    }

    //call the compare to method from the interface class 10/20
    //pass the product to compare, get the name and compare it with ignore of a case and then return the comparison.
    @Override
    public int compareTo(SalableProduct compare ){
        return this.getName().compareToIgnoreCase(compare.getName());
    }


}

