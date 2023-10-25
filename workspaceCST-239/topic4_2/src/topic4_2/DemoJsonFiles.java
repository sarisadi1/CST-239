package topic4_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJsonFiles {

	
	private static void saveToFile(String filename, Car car, boolean append) {
		PrintWriter pw;
		try {
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			pw.flush();
			
			
			pw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		Car[] cars = new Car[5];
		cars[0] = new Car(2000, "NA", "NA", 1, 1);
		cars[0] = new Car(2000, "NA", "NA", 1, 1);
		cars[0] = new Car(2000, "NA", "NA", 1, 1);
		cars[0] = new Car(2000, "NA", "NA", 1, 1);
		
		
		for(int x=0; x <= 4; ++x) {
			saveToFile("out.json", cars[x], true);
		}
		
		ArrayList<Car>carsList = readFromFile("out.json");
		
		for(Car car : carsList) {
			String text = Integer.toString(car.getYear()) + "," +
											car.getMake() + "," + 
											car.getModel() + "," +
											Integer.toString(car.getOdometer()) + "," +
											Double.toString(car.getEngingeLiters());
			
			System.out.println(text);
		}
	}

	
	private static ArrayList<Car> readFromFile(String filename) {
		ArrayList<Car> cars = new ArrayList<Car>();
		try {
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			while(s.hasNext()) {
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				Car car = objectMapper.readValue(json, Car.class);
				cars.add(car);
			}
			s.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return cars;
	}
}
