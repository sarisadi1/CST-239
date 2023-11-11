package app;

public class CounterWorker {
	
	public static void main (String args[]) throws InterruptedException
{
		System.out.println("This is the intital value of the counter " + Counter.getCount());
		
		//Number of counters to create
		int numberCounters=1000;
		
		//Create 1000 counters that can each run in their own thread
		CounterThread[] counters = new CounterThread[numberCounters];
		for(int x= 0; x<1000;++x)
			counters[x]= new CounterThread();
		
		//Start all 1000 counter threads
		for(int x=0;x<1000;++x)
			counters[x].start();
		
		//wait for 100 counter threads to finish
		for(int x=0;x<1000;++x)
			counters[x].join();
		
		//what value did the counter end up with 
		System.out.println("This is the end value of the Counter"+ Counter.getCount());
		
		
		
		
}
	
		//print the message
	
}
