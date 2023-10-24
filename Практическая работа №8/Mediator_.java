interface Mediator {
    void notify(Component component, String event);
}

abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendEvent(String event);
    public abstract void receiveEvent(String event);
}

class Engine extends Component {
    public Engine(Mediator mediator) {
        super(mediator);
    }

    public void sendEvent(String event) {
        mediator.notify(this, event);
    }

    public void receiveEvent(String event) {
        System.out.println("Двигатель получил сигнал: " + event);
    }
}

class Transmission extends Component {
    public Transmission(Mediator mediator) {
        super(mediator);
    }

    public void sendEvent(String event) {
        mediator.notify(this, event);
    }

    public void receiveEvent(String event) {
        System.out.println("Трансмиссия получила сигнал: " + event);
    }
}

class Electronics extends Component {
    public Electronics(Mediator mediator) {
        super(mediator);
    }

    public void sendEvent(String event) {
        mediator.notify(this, event);
    }

    public void receiveEvent(String event) {
        System.out.println("Электроника получила сигнал: " + event);
    }
}

class CarMediator implements Mediator {
    private Engine engine;
    private Transmission transmission;
    private Electronics electronics;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setElectronics(Electronics electronics) {
        this.electronics = electronics;
    }

    public void notify(Component component, String event) {
        if (component == engine) {
            transmission.receiveEvent(event);
            electronics.receiveEvent(event);
        } else if (component == transmission) {
            engine.receiveEvent(event);
            electronics.receiveEvent(event);
        } else if (component == electronics) {
            engine.receiveEvent(event);
            transmission.receiveEvent(event);
        }
    }
}

public class Mediator_ {
    public static void main(String[] args) {
        CarMediator mediator = new CarMediator();

        Engine engine = new Engine(mediator);
        Transmission transmission = new Transmission(mediator);
        Electronics electronics = new Electronics(mediator);

        mediator.setEngine(engine);
        mediator.setTransmission(transmission);
        mediator.setElectronics(electronics);

        engine.sendEvent("Запуск двигателя");
        transmission.sendEvent("Переключение передачи");
        electronics.sendEvent("Запуск системы навигации");
    }
}
