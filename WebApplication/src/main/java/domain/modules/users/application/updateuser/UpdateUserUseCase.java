package domain.modules.users.application.updateuser;

import domain.modules.share.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {

    private final EventBus queue;
    private final UserRepository repository;

    @Autowired
    public UpdateUserUseCase(final EventBus queue, final UserRepository repository) {
        this.queue = queue;
        this.repository = repository;
    }

    public User Execute(final CreateUserRequest request) {
        final var pizza = new User(request.getImg(), request.getName(), request.getPrice());
        final var result = this.repository.CreatePizza(pizza);
        this.queue.dispatch(this.createPizzaCreatedEvent(pizza));
        return result;
    }

    public UserCreatedEvent createPizzaCreatedEvent(final User user) {
        final var event = new UserCreatedEvent();
        event.name = user.getName();
        event.price = Float.toString(user.getPrice());
        event.img = user.getImg();
        return event;
    }
}
