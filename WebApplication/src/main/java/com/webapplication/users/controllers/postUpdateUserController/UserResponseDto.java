package com.webapplication.users.controllers.postUpdateUserController;

import domain.modules.users.application.updateuser.User;

public class UserResponseDto {

    private int id;
    private final String name;
    private String firstName;
    private String lastName;
    private int age;

    public UserResponseDto() {
        this.name = "jonya";
    }

    public UserResponseDto(final User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
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

    public float getAge() {
        return this.age;
    }
}
