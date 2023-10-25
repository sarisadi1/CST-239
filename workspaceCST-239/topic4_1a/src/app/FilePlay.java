package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePlay {

	public static void main(String[] args) {
		int err = FilePlay.copyFile("InUsers.txt","OutUser.txt");
		
		switch(err) {
			case 0:
				System.out.println("File was copied successfully");
				break;
			case -1:
				System.out.println("File could not be opened.");
				break;
			case -2:
				System.out.println("File I/O error");
				break;

	}}

	private static int copyFile(String InFile, String OutFile) {
		FileReader in = null;  
		FileWriter out = null;
		try {
			in = new FileReader(InFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		
		try {
			out = new FileWriter(OutFile);
		} 
		catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
		
		
		int c;
		try {
			while(( c = in.read()) != -1) {
				out.flush();
				out.write(c);
			}
		} 
		catch(NullPointerException e) {
			e.printStackTrace();
			return -1;
		}
		catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
		return 0;
		 
	}
	
	
		
	}

