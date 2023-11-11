package app;

public class ServerApp {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//Create instance of serverthread
		ServerThread serverThread = new ServerThread();
		//start the thread
		serverThread.start();
		//loop while the thread is still running 
		for(int i = 0; i< 1000; i++) {
			System.out.println(".");
			
			Thread.sleep(5000);
		}
	}}
