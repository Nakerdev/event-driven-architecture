package domain.modules.users.application.updateuser;

import domain.modules.share.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUseCase {

    private final EventBus queue;
    private final UserPostgrestRepository repository;

    @Autowired
    public UpdateUserUseCase(final EventBus queue, final UserPostgrestRepository repository) {
        this.queue = queue;
        this.repository = repository;
    }

    public User execute(final UpdateUserRequest request) {
        final var user = new User(
                request.getId(),
                request.getName(),
                request.getFirstName(),
                request.getLastName(),
                request.getAge());
        final var result = this.repository.updateUser(user);
        this.queue.dispatch(this.createEvent(user));
        return result;
    }

    private UserUpdatedEvent createEvent(final User user) {
        return new UserUpdatedEvent(
                user.getId(),
                user.getName(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge()
        );
    }
}
