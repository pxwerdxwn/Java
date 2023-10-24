class Car {
    private String model;
    private String engine;
    private String transmission;
    private String color;

    public Car(String model) {
        this.model = model;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showInfo() {
        System.out.println("Модель: " + model);
        System.out.println("Двигатель: " + engine);
        System.out.println("Трансмиссия: " + transmission);
        System.out.println("Цвет: " + color);
    }
}

interface CarBuilder {
    void buildEngine();
    void buildTransmission();
    void paintCar();
    Car getResult();
}

class SedanBuilder implements CarBuilder {
    private Car car;

    public SedanBuilder(String model) {
        car = new Car(model);
    }

    public void buildEngine() {
        car.setEngine("1.6L");
    }

    public void buildTransmission() {
        car.setTransmission("Автоматическая");
    }

    public void paintCar() {
        car.setColor("Синий");
    }

    public Car getResult() {
        return car;
    }
}

class CarDirector {
    private CarBuilder builder;

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructCar() {
        builder.buildEngine();
        builder.buildTransmission();
        builder.paintCar();
        return builder.getResult();
    }
}

public class Builder {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();
        CarBuilder sedanBuilder = new SedanBuilder("Sedan Model");
        
        director.setBuilder(sedanBuilder);
        Car sedanCar = director.constructCar();
        
        sedanCar.showInfo();
    }
}
