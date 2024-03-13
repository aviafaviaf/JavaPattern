package Practice7.proxy;

public class RealCar implements Car{
    @Override
    public void start() {
        System.out.println("Машина заведена");
    }

    @Override
    public void stop() {
        System.out.println("Машина заглушена");
    }
}
