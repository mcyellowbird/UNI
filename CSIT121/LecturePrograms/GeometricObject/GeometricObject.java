abstract class GeometricObject{
	private String colour;
	private boolean filled;

	protected GeometricObject() {
		colour = "white";
		filled = false;
	}

	public String getColour(){
		return colour;
	}

	public void setColour(String c){
		colour = c;
	}

	public boolean isFilled(){
		return filled;
	}

	public void setFilled(boolean f){
		filled = f;
	}

	public String toString(){
		return getColour() + ", " + isFilled();
	}

	public abstract double getArea();

	public abstract double getPerimeter();
}