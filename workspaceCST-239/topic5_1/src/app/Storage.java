package app;

public class Storage <T>{
	
	private T s = null;
	
	public Storage (T s)
	{
		this.s=s;
	}
	public T getData()
	{
		return this.s;
	}


	
	
	
	public static void main(String[] args) {
		Storage<String> storage1 = new Storage<String>("Mark Reha");
		System.out.println("This is the data "+ storage1.getData());
		Storage<Integer>storage2 = new Storage<Integer>(0);
		System.out.println("This is the data "+ storage2.getData());

	}

}
