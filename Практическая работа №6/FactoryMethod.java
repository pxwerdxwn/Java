interface Car {
    void assemble();
}

class Sedan implements Car {
    public void assemble() {
        System.out.println("Собран седан");
    }
}

class OffRoad implements Car {
    public void assemble() {
        System.out.println("Собран внедорожник");
    }
}

abstract class CarFactory {
    abstract Car createCar();

    void deliverCar() {
        Car car = createCar();
        car.assemble();
    }
}

class SedanFactory extends CarFactory {
    Car createCar() {
        return new Sedan();
    }
}

class OffRoadFactory extends CarFactory {
    Car createCar() {
        return new OffRoad();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        CarFactory sedanFactory = new SedanFactory();
        sedanFactory.deliverCar(); 

        CarFactory suvFactory = new OffRoadFactory();
        suvFactory.deliverCar();
    }
}
