package com.webapplication.controllers.postUpdateUserController;

public class AddUserRequestDto {
    private String img;
    private String name;
    private String price;

    public String getImg() {
        return this.img;
    }

    public void setImg(final String img) {
        this.img = img;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(final String price) {
        this.price = price;
    }
}
