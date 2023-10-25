package topic4d;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePlay {
	
	
	private static void copyFile(String InFile, String OutFile) throws FileNotFoundException, IOException{
		BufferedReader in = null;  
		BufferedWriter out = null;

		in = new BufferedReader(new FileReader(InFile));
		out = new BufferedWriter(new FileWriter(OutFile));

		String line;
		while(( line = in.readLine()) != null) {
			String[] tokens = line.split("\\|");
			out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
		}
		
		try {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		 
	}
	
	public static void main(String[] args) {
		try {
			FilePlay.copyFile("InUsers.txt","OutUser.txt");
			System.out.println("File was copied successfully");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File could not be opened.");
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("File I/O error.");
		}
	}
}
