package Practice7.facade;

public class Test {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stopCar();
    }
}
