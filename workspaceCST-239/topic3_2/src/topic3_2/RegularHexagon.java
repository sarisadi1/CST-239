package topic3_2;

public class RegularHexagon extends ShapeBase {

	int side;
	public RegularHexagon (String name, int rad, int radtwo, int radthree)
	{
		super(name, rad,  radtwo);
	}

	public int calculateArea()
	{
		return (int) ((3*Math.sqrt(3)*(side*side))/2);
	}
}
