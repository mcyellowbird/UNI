/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

enum CarType {
    SUV,
    SEDAN,
    COUPE,
    HATCH,
    WAGON
};
class Car {
    private String model;
    private CarType type;
    private int manufacturingYear;
    protected double price;
    public Car(String model, CarType type, int manufacturingYear, double price) {
        this.model = model;
        this.type = type;
        this.manufacturingYear = manufacturingYear;
        this.price = price;
    } //constructor method
    public Car(Car car) {
        this.model = car.model;
        this.type = car.type;
        this.manufacturingYear = car.manufacturingYear;
        this.price = car.price;
    }
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
    public String toString() {
        return "Model:" + model + ", Type:" + type + ", Year:" + manufacturingYear + ", Price:" + ((double) Math.round(price * 100d) / 100d); //put all of the info about the car into a string
    }
    public void print() {
        System.out.print("Model:" + model + ", Type:" + type + ", Year:" + manufacturingYear + ", Price:" + (double) Math.round(price * 100d) / 100d);
    }

    public void priceRise(double rise) {
        price = price * (1 + rise);
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public CarType getType() {
        return type;
    }
    public void setType(CarType type) {
        this.type = type;
    }
    public int getManufacturingYear() {
        return manufacturingYear;
    }
    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}