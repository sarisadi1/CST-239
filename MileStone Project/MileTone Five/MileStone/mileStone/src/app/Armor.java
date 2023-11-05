package app;

public class Armor extends SalableProduct implements Comparable {




    //Add a constructor
    Armor(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);


    }



    //call the compare to method from the interface class 10/20
    //pass the product to compare, get the name and compare it with ignore of a case and then return the comparison.
    @Override
    public int compareTo(SalableProduct compare ){
        int compared =this.getName().compareToIgnoreCase(compare.getName());
        return compared;
    }


}


