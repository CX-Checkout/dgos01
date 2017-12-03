package befaster.solutions;

import java.util.Optional;

public class ProductInfo {
    private int price;
    private Optional<Offer> offer;
    private Optional<Discount> discount;

    public ProductInfo(int price) {
        this.price = price;
        this.offer = Optional.empty();
        this.discount = Optional.empty();
    }

    public ProductInfo(int price, Optional<Offer> offer) {
        this.price = price;
        this.offer = offer;
    }

    public void addDiscount(Discount discount) {
        this.discount = Optional.of(discount);
    }

    public int getPrice() {
        return price;
    }

    public boolean hasOffer() {
        return offer.isPresent();
    }

    public Offer getOffer() {
        return offer.get();
    }
}
