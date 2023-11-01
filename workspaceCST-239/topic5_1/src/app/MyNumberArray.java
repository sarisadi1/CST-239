package app;

public class MyNumberArray {
	
	
	
	public <E> void printArray(E[] inputArray) {
		
		for(E element: inputArray) {
			System.out.printf("%s ", element);
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] intArray = {1,2,3,4,5,5};
		Double[] doubleArray = { 1.1,2.2,3.3,4.4};
		Character[] charArray = { 'H','E','L','L','O'};
		
		MyNumberArray myarray = new MyNumberArray();
		System.out.println("Array integerArray contains:");
		myarray.printArray(intArray);
		System.out.println("\nArray doubleArray contains:");
		myarray.printArray(doubleArray);
		System.out.println("\nArray characterArray contains:");
		myarray.printArray(charArray);
	}
	
}