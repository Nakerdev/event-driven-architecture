package domain.modules.share.Infrastructure.bus.event;

import domain.modules.share.Infrastructure.bus.event.serializableEvents.UserUpdatedSerializableEvent;
import domain.modules.share.domain.bus.event.Event;
import domain.modules.share.domain.bus.event.EventBus;
import domain.modules.share.domain.bus.event.SentEventUnit;
import domain.modules.users.application.updateuser.UserUpdatedEvent;
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
        UserUpdatedSerializableEvent rawEvent = null;
        if (event.getClass() == UserUpdatedEvent.class) {
            rawEvent = this.createEvent((UserUpdatedEvent) event);
        }
        this.rabbitTemplate.convertAndSend(rawEvent.getClass().getName(), rawEvent);
        return SentEventUnit.CreateUnit(event);
    }

    private UserUpdatedSerializableEvent createEvent(final UserUpdatedEvent UserUpdatedEvent) {
        //TODO: TECHNICAL DEBT, Maybe we can move this method within UserUpdatedSerializableEvent fi don't break the serialization
        return new UserUpdatedSerializableEvent(
                UserUpdatedEvent.getId(),
                UserUpdatedEvent.getName(),
                UserUpdatedEvent.getFirstName(),
                UserUpdatedEvent.getLastName(),
                UserUpdatedEvent.getAge()
        );
    }
}
