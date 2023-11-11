package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	
	
	
	public void start(String ip, int port) throws UnknownHostException, IOException{
		
		//Connect to the remote server on the specified IP address and port
		clientSocket = new Socket(ip,port);
		//Create some input and output network buffers to communicate back and forth with the server
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public String sendMessage(String msg) throws IOException{
		//Send a message to server with a terminating line feed
		out.println(msg);
		//Return the response from the server
		return in.readLine();
	}
	public void cleanup() throws IOException{
		//Close all inpit and output network buffers and sockets
		in.close();
		out.close();
		clientSocket.close();
	}
	
	public static void main(String[] args) throws IOException{
		//Create a client and connect to the remote server on the specified IP address and port
		Client client = new Client();
		client.start("127.0.0.1", 6666);
		//Send 10 Messages  to the server 
		String response;
		for(int count = 0; count < 10; ++count) {
			
			//Send message to the server and on the 9th one send a shutdown command to server
			String message;
			if(count != 9) {
				message = "Hello from Client " + count;
			}
			else {
				message = ".";
			}
			response = client.sendMessage(message);
			//Print out the server reponse and if we get a QUIT response exit this program
			System.out.println("Server response was " + response);
			if(response.equals("q"))
				break;
		}
		//On exit clean everything up
		client.cleanup();
	}
	
}
