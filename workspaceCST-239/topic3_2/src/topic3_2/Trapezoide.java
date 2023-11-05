package topic3_2;

public class Trapezoide extends ShapeBase {
	
	int base;
	
	public Trapezoide (String name, int base, int basetwo, int basethree )
	{
		super(name, base,  basetwo);
	}

	public int calculateArea()
	{
		return ((base + width)/2)*height;
	}

}
