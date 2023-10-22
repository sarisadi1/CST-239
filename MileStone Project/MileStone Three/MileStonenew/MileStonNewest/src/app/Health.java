package app;

//This class extends on salable product parent class 10/20
public class Health extends SalableProduct implements Comparable {

	
	//Add a constructor
	Health(String name, String description, double price, int quantity) {
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

