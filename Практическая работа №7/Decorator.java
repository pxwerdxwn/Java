interface Car {
    void assemble();
}

class BasicCar implements Car {
    public void assemble() {
        System.out.println("Собран базовый автомобиль");
    }
}

class CarWithGPS implements Car {
    private Car car;

    public CarWithGPS(Car car) {
        this.car = car;
    }

    public void assemble() {
        car.assemble();
        System.out.println("Добавлен GPS");
    }
}

class CarWithLeatherSeats implements Car {
    private Car car;

    public CarWithLeatherSeats(Car car) {
        this.car = car;
    }

    public void assemble() {
        car.assemble();
        System.out.println("Добавлены кожаные сидения");
    }
}

public class Decorator {
    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        basicCar.assemble();

        System.out.println("------");

        Car carWithGPS = new CarWithGPS(basicCar);
        carWithGPS.assemble();

        System.out.println("------");

        Car carWithGPSAndLeatherSeats = new CarWithLeatherSeats(carWithGPS);
        carWithGPSAndLeatherSeats.assemble();
    }
}
