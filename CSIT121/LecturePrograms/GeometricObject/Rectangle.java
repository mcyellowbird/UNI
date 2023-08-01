class Rectangle extends GeometricObject{
	private double width, height;

	public Rectangle(double w, double h){
		super();
		width = w;
		height = h;
	}

	public Rectangle(){
		this(1,1);
	}

	public double getWidth(){
		return width;
	}

	public void setWidth(double w){
		width = w;
	}

	public double getHeight(){
		return height;
	}

	public void setHeight(double h){
		height = h;
	}

	@Override
	public double getArea(){
		return getWidth() * getHeight();
	}

	@Override
	public double getPerimeter(){
		return 2 * (getWidth() + getHeight());
	}

	public String toString(){
		String s = "";
		s += "Rectangle: width=" + getWidth() + ", height=" + getHeight() + ", area=" + getArea() + ", Perimeter=" + getPerimeter() + "\n";
		s += super.toString();
		return s;
	}
}