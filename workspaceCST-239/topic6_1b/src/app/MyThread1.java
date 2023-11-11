package app;

import java.lang.Thread;
//Create a thread that extends the Thread class

public class MyThread1 extends Thread {

	public void run()
	{
		for(int x=0; x< 1000;++x) {
			System.out.println("MyThread1 is running iteration" + x);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
	}
		}
	
	
	
	
}
