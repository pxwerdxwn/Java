class Engine {
    void addEngine() {
        System.out.println("Добавлен двигатель");
    }
}

class Transmission {
    void addTransmission() {
        System.out.println("Добавлена трансмиссия");
    }
}

class Electronics {
    void addElectronics() {
        System.out.println("Добавлена электроника");
    }
}

class CarFacade {
    private Engine engine;
    private Transmission transmission;
    private Electronics electronics;

    public CarFacade() {
        engine = new Engine();
        transmission = new Transmission();
        electronics = new Electronics();
    }

    public void assembleCar() {
        System.out.println("Начало сборки автомобиля");
        engine.addEngine();
        transmission.addTransmission();
        electronics.addElectronics();
        System.out.println("Автомобиль собран.");
    }
}

public class Facade {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.assembleCar();
    }
}
