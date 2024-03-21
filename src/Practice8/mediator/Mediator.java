package Practice8.mediator;

public class Mediator implements IMediator {
    public Colleague colleague1 = new Colleague1(this);
    public Colleague colleague2 = new Colleague2(this);

    @Override
    public void send(Colleague colleague, String message) {
        if (colleague instanceof Colleague1)
            colleague2.notify(message);
        else if (colleague instanceof Colleague2)
            colleague1.notify(message);
    }
}
