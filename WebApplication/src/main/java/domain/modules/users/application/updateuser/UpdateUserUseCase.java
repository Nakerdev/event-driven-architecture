package domain.modules.users.application.updateuser;

import domain.modules.share.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {

    private final EventBus queue;
    private final PizzaRepository repository;

    @Autowired
    public UpdateUserUseCase(final EventBus queue, final PizzaRepository repository) {
        this.queue = queue;
        this.repository = repository;
    }

    public Pizza Execute(final CreatePizzaRequest request) {
        final var pizza = new Pizza(request.getImg(), request.getName(), request.getPrice());
        final var result = this.repository.CreatePizza(pizza);
        this.queue.dispatch(this.createPizzaCreatedEvent(pizza));
        return result;
    }

    public PizzaCreatedEvent createPizzaCreatedEvent(final Pizza pizza) {
        final var event = new PizzaCreatedEvent();
        event.name = pizza.getName();
        event.price = Float.toString(pizza.getPrice());
        event.img = pizza.getImg();
        return event;
    }
}