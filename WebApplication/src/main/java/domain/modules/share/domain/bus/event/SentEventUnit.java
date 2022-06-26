package domain.modules.share.domain.bus.event;

public class SentEventUnit<T> implements Unit {

    private SentEventUnit() {
    }

    public static <T> SentEventUnit<T> CreateUnit(final T arg) {

        return new SentEventUnit<T>();
    }
}
