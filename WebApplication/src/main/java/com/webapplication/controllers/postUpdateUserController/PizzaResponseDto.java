package com.webapplication.controllers.postUpdateUserController;

import domain.modules.users.application.updateuser.User;

public class PizzaResponseDto {
    private final String img;
    private final String name;
    private final float price;

    public PizzaResponseDto(final User user) {
        this.img = user.getImg();
        this.name = user.getName();
        this.price = user.getPrice();
    }

    public String getImg() {
        return this.img;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }
}
