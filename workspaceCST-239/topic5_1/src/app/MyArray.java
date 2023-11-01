package app;

public class MyArray {
	
	
	public <E extends Number> void printArray(E[] inputArray) {
		
		for(E element: inputArray) {
			System.out.printf("%s ", element);
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] intArray = {1,2,3,4,5,5};
		Double[] doubleArray = { 1.1,2.2,3.3,4.4};
		Float[] floatArray = { 0.0f, 1.0f, 2.5f, 3.5f};
		
		MyArray myarray = new MyArray();
		System.out.println("Array integerArray contains:");
		myarray.printArray(intArray);
		System.out.println("\nArray doubleArray contains:");
		myarray.printArray(doubleArray);
		System.out.println("\nArray floatArray contains:");
		myarray.printArray(floatArray);
	}
	
}

