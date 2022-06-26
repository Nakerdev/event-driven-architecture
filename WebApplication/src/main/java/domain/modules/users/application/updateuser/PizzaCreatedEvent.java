package domain.modules.users.application.updateuser;

import domain.modules.share.domain.bus.event.Event;

import java.io.Serializable;

public class PizzaCreatedEvent implements Serializable, Event {
    public String img;
    public String name;
    public String price;

    public PizzaCreatedEvent() {
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