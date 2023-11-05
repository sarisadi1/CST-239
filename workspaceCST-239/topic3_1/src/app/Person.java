package app;

public class Person implements PersonInterface, Comparable<Person> {
	private String firstName="Mark";
	private String lastName="Reha";
	private boolean running;
	private Integer age;
	
	public Person(String firstName,String lastName, int age)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
	}
	public Person(Person person)
	{
		this.firstName=person.getFirstName();
		this.lastName= person.getLastName();
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	
	public boolean equals(Object other)
	{
		if (other==this)
		{
			System.out.println("I am here in other == this");
			return true;
		}
		if (other==null)
		{
			System.out.println("I am here in other == null");
			return false;
		}
		if(getClass()!=other.getClass())
		{
			System.out.println("I am here in getClass()!=other.getClass()");
			return false;
		}
		Person person = (Person)other;
		return(this.firstName==person.firstName&&this.lastName==person.lastName);
	}
	
	public String toString()
	{
		return "my class is " + getClass()+ " " + this.firstName+ " "+this.lastName; 
	}


	@Override
	public void walk() {
		System.out.println("I am walking");
		running = false;
	}

	
	@Override
	public void run() {
		System.out.println("I am running");
		running = true;
	}
	
	@Override
	public boolean isRunning() {
		return running;
	}
	
	@Override
	public int compareTo(Person p) {
		int value = this.age.compareTo(p.age);
		return value;
		
	}
	
	
	
	
	
}

