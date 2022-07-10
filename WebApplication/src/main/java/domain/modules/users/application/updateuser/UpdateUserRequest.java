package domain.modules.users.application.updateuser;

public class UpdateUserRequest {
    private final int id;
    private final String name;
    private final String firstName;
    private final String lastName;
    private final int age;

    public UpdateUserRequest(
            final int id,
            final String name,
            final String firstName,
            final String lastName,
            final int age) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public static UpdateUserRequest create(
            final String id,
            final String name,
            final String firstName,
            final String lastName,
            final String age) {
        return new UpdateUserRequest(
                Integer.parseInt(id),
                name,
                firstName,
                lastName,
                Integer.parseInt(age));
    }
}
