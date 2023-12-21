package representation;

public abstract class Decorator implements Event {
    private final Event decoratedEvent;

    public Decorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    @Override
    public void display() {
        decoratedEvent.display();
    }

    @Override
    public Displayable chooseNext() {
        return decoratedEvent.chooseNext();
    }
}
