package com.webapplication.users.controllers.postUpdateUserController;

public class UserResponseDto {

    private String name;
    private String firstName;
    private String lastName;
    private int age;

    public UserResponseDto() {
    }

    public UserResponseDto(String name, String firstName, String lastName, int age) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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
