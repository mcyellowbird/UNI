class Circle {
    public double r; // Previously: private double r // Has to be public

    public Circle(double rad) { // Previously: public void Circle(double r) // Has to be constructor, not a void // Needed to change received value name
        r = rad; // Previously: r = r // Needed r = r
    }

    public double calCircumference() { // Previously: private double calCircumference() // Has to be public
        return 2 * Math.PI * r;
    }

    public double calArea() { // Previously: public static double calArea() // Doesn't need to be static
        return Math.PI * r * r;
    }
}
class CircleApp {
    public static void main(String[] args) {
        double rd = Double.parseDouble(args[0]);

        System.out.println("Circle radius = " + rd);

        // Create an object of Circle with the radius rd
        Circle circle1 = new Circle(rd);

        double cir = circle1.calCircumference();
        double area = circle1.calArea();

        System.out.println("Circumference = " + cir);
        System.out.println("Area = " + area);
    }
}