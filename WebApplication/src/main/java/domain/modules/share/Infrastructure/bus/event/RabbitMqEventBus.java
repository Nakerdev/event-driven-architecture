package domain.modules.share.Infrastructure.bus.event;

import domain.modules.share.domain.bus.event.Event;
import domain.modules.share.domain.bus.event.EventBus;
import domain.modules.share.domain.bus.event.SentEventUnit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventBus implements EventBus {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqEventBus(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public <T extends Event> SentEventUnit<T> dispatch(final T event) {
        this.rabbitTemplate.convertAndSend(event.getClass().getName(), event);
        return SentEventUnit.CreateUnit(event);
    }
}
