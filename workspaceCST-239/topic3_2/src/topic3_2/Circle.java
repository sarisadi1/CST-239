package topic3_2;

public class Circle extends ShapeBase {
	
	public Circle (String name, int rad )
	{
		super(name, rad, rad);
	}

	public int calculateArea()
	{
		return (int) (Math.PI * (width * height));
	}

}
