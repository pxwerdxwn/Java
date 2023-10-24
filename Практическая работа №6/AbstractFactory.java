interface Engine {
    void start();
}

interface Wheels {
    void roll();
}

class CarEngine implements Engine {
    public void start() {
        System.out.println("Двигатель автомобиля запущен");
    }
}

class CarWheels implements Wheels {
    public void roll() {
        System.out.println("Колеса автомобиля крутятся");
    }
}

class BikeEngine implements Engine {
    public void start() {
        System.out.println("Двигатель велосипеда запущен");
    }
}

class BikeWheels implements Wheels {
    public void roll() {
        System.out.println("Колеса велосипеда крутятся");
    }
}

interface VehicleFactory {
    Engine createEngine();
    Wheels createWheels();
}

class CarFactory implements VehicleFactory {
    public Engine createEngine() {
        return new CarEngine();
    }

    public Wheels createWheels() {
        return new CarWheels();
    }
}

class BikeFactory implements VehicleFactory {
    public Engine createEngine() {
        return new BikeEngine();
    }

    public Wheels createWheels() {
        return new BikeWheels();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Engine carEngine = carFactory.createEngine();
        Wheels carWheels = carFactory.createWheels();

        carEngine.start(); 
        carWheels.roll(); 

        VehicleFactory bikeFactory = new BikeFactory();
        Engine bikeEngine = bikeFactory.createEngine();
        Wheels bikeWheels = bikeFactory.createWheels();

        bikeEngine.start(); 
        bikeWheels.roll(); 
    }
}
