package domain.modules.users.application.updateuser;

public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String name;
    private final int age;

    public User(
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
