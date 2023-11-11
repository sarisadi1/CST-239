package app;

public class TestMyThreads {

	public static void main (String args[])
{
		//how to create and start a thread that extends
	MyThread1 thread1 = new MyThread1();
	thread1.start();
	
		//how to create and start a thread that implements
	Runnable runnable = new MyThread2();
	Thread thread2 = new Thread(runnable);
	thread2.start();
}
	
}
