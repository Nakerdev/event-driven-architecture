package domain.modules.users.application.updateuser;

public class CreateUserRequest {
    private final String img;
    private final String name;
    private final float price;

    public CreateUserRequest(final String img, final String name, final float price) {
        this.img = img;
        this.name = name;
        this.price = price;
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

    private static float formatPrice(final String price) {
        return Float.parseFloat(price);
    }

    public static CreateUserRequest create(final String img, final String name, final String price) {
        return new CreateUserRequest(img, name, formatPrice(price));
    }
}
