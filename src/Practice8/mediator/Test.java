package Practice8.mediator;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        mediator.colleague1.send("111");
        mediator.colleague2.send("222");
    }
}
