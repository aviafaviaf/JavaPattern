package Practice7.proxy;

public class Test {
    public static void main(String[] args) {
        Car car = new ProxyCar();
        car.start();
        car.stop();
    }
}
