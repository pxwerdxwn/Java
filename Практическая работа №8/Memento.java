// Класс представления состояния автомобиля
class CarShot {
    private String model;
    private String color;
    private String engineType;

    public CarShot(String model, String color, String engineType) {
        this.model = model;
        this.color = color;
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngineType() {
        return engineType;
    }
}

class Car {
    private String model;
    private String color;
    private String engineType;

    public Car(String model, String color, String engineType) {
        this.model = model;
        this.color = color;
        this.engineType = engineType;
    }

    public CarShot createSnapshot() {
        return new CarShot(model, color, engineType);
    }

    public void restoreSnapshot(CarShot snapshot) {
        this.model = snapshot.getModel();
        this.color = snapshot.getColor();
        this.engineType = snapshot.getEngineType();
    }

    public void displayInfo() {
        System.out.println("Модель: " + model);
        System.out.println("Цвет: " + color);
        System.out.println("Тип двигателя: " + engineType);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}

public class Memento {
    public static void main(String[] args) {
        Car car = new Car("Sedan", "Blue", "Gasoline");
        car.displayInfo();

        CarShot snapshot = car.createSnapshot();

        car.setModel("OffRoad");
        car.setColor("Red");
        car.setEngineType("Electric");
        car.displayInfo();

        car.restoreSnapshot(snapshot);
        System.out.println("Восстановленное состояние автомобиля:");
        car.displayInfo();
    }
}
