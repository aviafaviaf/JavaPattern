package Practice8.mediator;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        mediator.colleague1.send("From Colleague 1");
        mediator.colleague2.send("From Colleague 2");
    }
}
