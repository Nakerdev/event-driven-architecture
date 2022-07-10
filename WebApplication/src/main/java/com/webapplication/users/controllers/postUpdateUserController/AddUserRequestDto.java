package com.webapplication.users.controllers.postUpdateUserController;

public class AddUserRequestDto {
    private String id;
    private String name;
    private String firstname;
    private String lastname;
    private String age;
    
    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(final String age) {
        this.age = age;
    }
}
