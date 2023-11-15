package junit;

public class Calculator {

	public static void main(String[] args) {
		Calculator calc= new Calculator();
		System.out.println("Adding 1 + 2 is " +calc.add(1, 2));
		System.out.println("Subtracting 2 from 1 is "+calc.subtract(2, 1));
		System.out.println("Multplication of 10 and 2 is "+calc.multiply(10, 2));
		System.out.println("Division of 10 by 2 is " + calc.divide(10, 2));

	}
	
	//Method that adds
	public int add(int a, int b) {
	
		return a+b;
	}
	//method that subtracts
	public int subtract (int a , int b) {
		return a-b;
	}
	//method that multiply
	public int multiply(int a , int b) {
		return a*b;
	}
	//method that devides
	public int divide (int a, int b) {
		return a/b;
	}
	

}
