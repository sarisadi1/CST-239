package app;

import java.io.IOException;

public class ServerThread extends Thread{
	
	//Override the run() to put the code that will run in this thread
	public void run() {
		
		//Create the instance of a server 
		//Start the server on port 6666
		//Exit and clean everything.
		Server server = new Server();
		try {
			server.start(6666);
			server.cleanup();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}