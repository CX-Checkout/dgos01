package befaster.solutions;

import java.util.Optional;

public class ProductInfo {
    private int price;
    private Optional<Offer> offer;

    public ProductInfo(int price) {
        this.price = price;
        this.offer = Optional.empty();
    }

    public ProductInfo(int price, Optional<Offer> offer) {
        this.price = price;
        this.offer = offer;
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
