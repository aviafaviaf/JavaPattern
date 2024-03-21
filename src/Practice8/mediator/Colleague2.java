package Practice8.mediator;

public class Colleague2 extends Colleague {
    public Colleague2(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("to colleague 2: " + message);
    }
}
