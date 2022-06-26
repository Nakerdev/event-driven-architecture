package domain.modules.share.domain.bus.event;

public interface EventHandler<E extends Event> {
    void invoke(E event);
}
