interface Car extends Cloneable {
    Car clone();
    void info();
}

class ConcreteCar implements Car {
    private String model;

    public ConcreteCar(String model) {
        this.model = model;
    }

    public Car clone() {
        return new ConcreteCar(this.model);
    }

    public void info() {
        System.out.println("Модель автомобиля: " + model);
    }
}

class CarFactory {
    private Car prototype;

    public CarFactory(Car prototype) {
        this.prototype = prototype;
    }

    public Car createCar() {
        return prototype.clone();
    }
}

public class Prototype {
    public static void main(String[] args) {
        Car prototypeCar = new ConcreteCar("Sedan Model");

        CarFactory factory = new CarFactory(prototypeCar);

        Car car1 = factory.createCar();
        Car car2 = factory.createCar();

        car1.info(); 
        car2.info(); 
}
}