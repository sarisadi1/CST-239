package topic3_2;

public class Test {

	private static void displayArea (ShapeBase shape)
	{
		System.out.println("This is a shape named "+ shape.getName()+" with an area of "+shape.calculateArea());
	}
	public static void main(String[] args) {
		ShapeBase[]shapes = new ShapeBase[6];
		shapes[0]= new Rectangle("Rectangle", 10, 200);
		shapes[1]= new Triangle ("triangle", 10 ,50);
		shapes[2] = new Circle("Circle", 4);
		shapes[3] = new Oval("Oval", 2, 3);
		shapes[4] = new RegularHexagon("Hexagon", 5, 10 , 20);
		shapes[5] = new Trapezoide("Trapezoid", 20, 30 , 40);

		
		
		for (int x=0; x<shapes.length;++x)
		{
			displayArea(shapes[x]);
		}
	}

}
