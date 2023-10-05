package carsGame;

public class RaceCarGame {

	public static void main(String[] args) {
	
		//Object
		PropertiesofCar raceCar = new PropertiesofCar(1,4,32,32,32,32,60,true);
		
		if (raceCar.requirment()==true) {
			System.out.print("The race car starts, drives and is able to stop.");
		}
		else {
			
				System.out.print("The race car is NOT able to start, drive and stop.");
			}
				
			
		}
		//method to return false or ture based on conditions
		
		

	}
	


