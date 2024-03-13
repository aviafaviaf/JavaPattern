package Practice7.facade;

public class Facade {
    private Headlights headlights;
    private Engine engine;

    public Facade() {
        headlights = new Headlights();
        engine = new Engine();
    }

    public void startCar() {
        engine.start();
        headlights.start();
    }

    public void stopCar() {
        headlights.stop();
        engine.stop();
    }
}
