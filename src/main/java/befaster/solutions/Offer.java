package befaster.solutions;

public class Offer {
    private final int quantity;
    private final int price;

    public Offer(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public boolean matches(int quantity) {
        return this.quantity == quantity;
    }

    public int getPrice() {
        return price;
    }
}
