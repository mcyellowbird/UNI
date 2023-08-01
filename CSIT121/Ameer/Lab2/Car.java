public class Car {
    enum CarType {
        SUV,
        LUX,
        HATCH,
        COUPE,
        SEDAN
    }

    String model;
    CarType type;
    int ManufacturingYear;
    double price;

    public Car(String model, CarType type, int mY, double price){
        this.model = model;
        this.type = type;
        this.ManufacturingYear = mY;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Car Details:" +
                "\n  Model: " + model +
                "\n  Type: " + type +
                "\n  Manufacturing Year: " + ManufacturingYear +
                "\n  Price: " + price;
    }

    public double getPrice(){
        return price;
    }
}
