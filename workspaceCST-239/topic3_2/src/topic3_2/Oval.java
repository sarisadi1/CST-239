package topic3_2;

public class Oval extends ShapeBase {

	
	public Oval (String name, int rad, int radtwo )
	{
		super(name, rad, rad);
	}

	public int calculateArea()
	{
		return (int) (Math.PI * (width * height));
	}

}
