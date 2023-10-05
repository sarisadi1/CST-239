package app;

//Class
public class Person {

	//variables
		private int age;
		private String name;
		private float weight;
		
	//main method
	public static void main(String[] args) 
	{
		Person person = new Person("Sari", 23, (float)182.30);
		System.out.println("My name is "+person.getName());
		person.walk();
		person.run(10);

	}
	//no return method. 
	public Person(String name, int age, float weight)
	{
		super();
		this.age=age;
		this.name=name;
		this.weight=weight;
		
	}
	
	

	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public float getWeight()
	{
		return weight;
	}
	
	
	public void walk()
	{
		System.out.println("I am in walk()");
	}
	public float run (float distance)
	{
		System.out.println("I am in run()");
		return 0;
	}
	
	
	

}
