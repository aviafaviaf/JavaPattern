package Practice8.mediator;

public abstract class Colleague {
    protected IMediator mediator;

    public Colleague(IMediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.send(this, message);
    }


    public abstract void notify(String message);
}
