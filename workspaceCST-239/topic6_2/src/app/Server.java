package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	
	public void start(int port) throws IOException{
		//wait for a client connection
		System.out.println("Waiting for a Client connection.....");
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		//if you get here then a client connected to this server to ctreate some input and output network budders
		System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		//wait for command (String that is terminated by a line feed character)
		String inputLine;
		while((inputLine = in.readLine()) != null) {
			//if period command then shut the server down
			if(".".equals(inputLine)) {
				System.out.println("Got a message to shut the Server down");
				out.println("Quit");
				break;
			}
			else {
				//command was processed succesfully
				System.out.println("Got a message of: " + inputLine);
				out.println("OK");
			}
			
		}//exit message that server is shutdown
		System.out.println("server is shut down");
	}
	
	public void cleanup() throws IOException {
		//Close all input and output network buffers and sockets
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	


	public static void main(String[] args) throws IOException{
		//Create an instance of this server
		//Start the server on port 6666 
		//Then on exit clean everything up
		Server server= new Server();
		server.start(6666);
		server.cleanup();

	}

}
