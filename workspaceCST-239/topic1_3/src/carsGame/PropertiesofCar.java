package carsGame;
//Class
public class PropertiesofCar 
//Properties
{
	int engine;
	int tires;
	int tireOne, tireTwo, tireThree, tireFour;
	int PSI;
	int speed;
	boolean status;
	//contructor
	public PropertiesofCar(int engine, int tires, int tireOne,int tireTwo, int tireThree, int tireFour, int speed, boolean status){

		this.engine = engine;
		this.tires = tires;
		this.tireOne = tireOne;
		this.tireTwo = tireTwo;
		this.tireThree = tireThree;
		this.tireFour = tireFour;
		this.speed = speed;
		this.status=status;

		}
//Set requiremnt to go through
	public boolean requirment(){
		if (engine!=1)
		{
			return false;
		}
		
		else if (tires!=4)
		{
			return false;
		}
		else if (tireOne!=32)
		{
			return false;
		}
		else if (tireTwo!=32)
		{
			return false;
		}
		else if (tireThree!=32)
		{
			return false;
		}
		else if (tireFour!=32)
		{
			return false;
		}
		else if(speed>1 && speed<60)
		{
			return false;
		}
		
		else if (status==false)
		{
			return false;
		}
		else{
			return true;
		}
	}
}
