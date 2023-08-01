class Circle extends GeometricObject{
	private double radius;

	public Circle(double r){
		super();
		radius = r;
	}

	public Circle(){
		this(1);
	}

	public double getRadius(){
		return radius;
	}

	public void setRadius(double r){
		radius = r;
	}

	@Override
	public double getArea(){
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public double getPerimeter(){
		return Math.PI * 2 * getRadius();
	}

	public String toString(){
		String s = "";
		s += "Circle: radius=" + getRadius() + ", area=" + getArea() + ", Perimeter=" + getPerimeter() + "\n";
		s += super.toString();
		return s;
	}
}