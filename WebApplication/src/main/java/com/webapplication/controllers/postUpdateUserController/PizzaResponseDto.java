package com.webapplication.controllers.postUpdateUserController;

import domain.modules.users.application.updateuser.Pizza;

public class PizzaResponseDto {
    private final String img;
    private final String name;
    private final float price;

    public PizzaResponseDto(final Pizza pizza) {
        this.img = pizza.getImg();
        this.name = pizza.getName();
        this.price = pizza.getPrice();
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
