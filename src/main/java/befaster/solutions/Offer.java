package befaster.solutions;

public class Offer {
    private final int quantity;
    private final int price;

    public Offer(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public boolean matches(int quantity) {
        return quantity >= this.quantity;
    }

    public int getOfferPrice(int quantity) {
        int packs = quantity / this.quantity;
        return packs * price;
    }

    public int getOutOfOfferProducts(Integer quantity) {
        return quantity % this.quantity;
    }
}
