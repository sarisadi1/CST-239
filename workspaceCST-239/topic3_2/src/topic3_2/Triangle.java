package topic3_2;

public class Triangle extends ShapeBase{
	public Triangle (String name, int width, int height)
	{
		super(name, width, height);
	}

	public int calculateArea()
	{
		return width * height/2;
	}
}
