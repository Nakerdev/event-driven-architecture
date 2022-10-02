package domain.modules.users.application.updateuser;

import domain.modules.share.domain.bus.event.Event;

public class UserUpdatedEvent implements Event {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String name;
    private final int age;

    public UserUpdatedEvent(
            final int id,
            final String name,
            final String firstName,
            final String lastName,
            final int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }
}