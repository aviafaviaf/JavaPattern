package Practice7.proxy;

public class ProxyCar implements Car {
    private RealCar car;
    @Override
    public void start() {
        if (car == null)
            car = new RealCar();
        car.start();
    }

    @Override
    public void stop() {
        if (car == null)
            car = new RealCar();
        car.stop();
    }
}
