package Practice8.mediator;

public class Colleague1 extends Colleague {
    public Colleague1(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("To Colleague 1: " + message);
    }
}
