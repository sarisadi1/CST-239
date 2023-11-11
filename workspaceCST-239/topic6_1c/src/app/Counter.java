package app;

public class Counter {

	//Static counter that starts at zero
	static int count=0;
	
	//Increament the counter
	static synchronized void increment()
	{
		count=count+1;
		
	}
	//Get the counter value
	static int getCount()
	{
		return count;
	}
}
