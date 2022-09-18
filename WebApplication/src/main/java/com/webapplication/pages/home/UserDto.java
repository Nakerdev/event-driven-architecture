package com.webapplication.pages.home;

public class UserDto {
    private String name;
    private String firstName;
    private String lastName;
    private int age;

    public UserDto(String name, String firstName, String lastName, int age) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
