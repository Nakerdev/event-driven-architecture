package domain.modules.users.application.updateuser;

public class Pizza {
    private final String img;
    private final String name;
    private final float price;

    public Pizza(final String img, final String name, final float price) {
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
}
