package befaster.solutions;

import java.util.HashMap;
import java.util.Optional;

public class Catalog {

    HashMap<Character, ProductInfo> values;

    public Catalog() {
        values = new HashMap<>();
        ProductInfo AInfo = new ProductInfo(50, Optional.of(new Offer(3, 130)));
        AInfo.addDiscount(new Discount(3, 20));
        values.put('A', AInfo);
        ProductInfo BInfo = new ProductInfo(30, Optional.of(new Offer(2, 45)));
        BInfo.addDiscount(new Discount(2, 15));
        values.put('B', BInfo);

        values.put('C', new ProductInfo(20));
        values.put('D', new ProductInfo(15));
    }

    public Integer getPriceFor(char item) {
        return values.get(item).getPrice();
    }

    public boolean containsOfferFor(char item) {
        return values.get(item).hasOffer();
    }

    public boolean containsDiscountFor(char item) {
        return values.get(item).hasDiscount();
    }

    public Offer getOfferFor(char item) {
        return values.get(item).getOffer();
    }

    public Discount getDiscountFor(char item) {
        return values.get(item).getDiscount().get();
    }
}
