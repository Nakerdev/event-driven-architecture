package domain.modules.users.application.updateuser;

import domain.modules.share.domain.bus.event.Event;

import java.io.Serializable;

public class UserCreatedEvent implements Serializable, Event {
    public String img;
    public String name;
    public String price;

    public UserCreatedEvent() {
    }

    public String getImg() {
        return this.img;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}