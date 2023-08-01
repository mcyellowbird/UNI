class Circle {
    public double r;

    public Circle(double rad) {
        r = rad;
    }

    public Circle(Circle circle){
        r = circle.r;
    }

    public double calCircumference() {
        return 2 * Math.PI * r;
    }

    public double calArea() {
        return Math.PI * r * r;
    }

    public void setRadius(double rad){
        r = rad;
    }

    public double getRadius(){
        return r;
    }
}
class CircleApp2 {
    public static void main(String[] args) {
        double rd = 3;//Double.parseDouble(args[0]);

        System.out.println("Circle radius = " + rd);

        // Create an object of Circle with the radius rd
        Circle circle1 = new Circle(rd);

        double cir = circle1.calCircumference();
        double area = circle1.calArea();

        System.out.println("Circumference = " + cir);
        System.out.println("Area = " + area);

        Circle circle2 = circle1;
        System.out.println("\nCircle2 Circumference = " + circle2.calCircumference());
        System.out.println("Circle2 Area = " + circle2.calArea());

        circle1.setRadius(6);
        rd = circle1.getRadius();
        cir = circle1.calCircumference();
        area = circle1.calArea();
        System.out.println("\nNew Radius: " + rd);
        System.out.println("New Circumference = " + cir);
        System.out.println("New Area = " + area);

        System.out.println("\nCircle2 Radius after change: " + circle2.getRadius()); // circle2's radius is affected by the change of 'rd', because it is a clone of circle1
    
        Circle circle3 = circle2;
        System.out.println("Circle3 Radius after cloning = " + circle3.getRadius()); // circle3 is a clone of circle2, so the values are the same

        circle3.setRadius(9);
        System.out.println("\nCircle2 Radius after circle3 change = " + circle2.getRadius());
        System.out.println("Circle3 Radius after change = " + circle3.getRadius());

        // Because each clone is not independant, the changed values will be the same for each clone.
    }
}