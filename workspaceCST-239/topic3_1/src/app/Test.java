package app;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
	
		Person[] persons = new Person[4];
		persons[0] = new Person("Justine","Reha", 1);
		persons[1] = new Person("Brianna","Reha", 2);
		persons[2] = new Person("Mary","Reha", 3);
		persons[3] = new Person("Mark","Reha", 4);
		Arrays.sort(persons);
		for (int x=0;x<4;++x)
		{
			System.out.println(persons[x]);
		}
		

	}}
