package domain.modules.share.domain.bus.event;

import org.springframework.stereotype.Component;

@Component
public interface EventBus {

    <T extends Event> void dispatch(T message);

}
