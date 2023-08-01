public class GeometricObjectTest{
	public static void main(String[] args){
		GeometricObject[] shapes = new GeometricObject[2];
		shapes[0] = new Circle();
		shapes[1] = new Rectangle();

		for (GeometricObject shape:shapes){
			System.out.println("\n" +  shape);

			if(shape instanceof Circle){
				Circle circle = (Circle) shape;
				System.out.println("\nRadius="+circle.getRadius());
			}else if(shape instanceof Rectangle){
				Rectangle rec = (Rectangle) shape;
				System.out.println("\nWidth="+rec.getWidth()+", Height="+rec.getHeight());
			}
		}
	}
}