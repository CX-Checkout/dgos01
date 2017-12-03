package befaster.solutions;

import java.util.HashMap;
import java.util.Optional;

public class Catalog {

    HashMap<Character, ProductInfo> values;

    public Catalog() {
        values = new HashMap<>();
        values.put('A', new ProductInfo(50, Optional.of(new Offer(3, 130))));
        values.put('B', new ProductInfo(30, Optional.of(new Offer(2, 45))));
        values.put('C', new ProductInfo(20));
        values.put('D', new ProductInfo(15));
    }


    public Integer getPriceFor(char item) {
        return values.get(item).getPrice();
    }

    public boolean containsOfferFor(char item) {
        return values.get(item).hasOffer();
    }

    public Offer getOfferFor(char item) {
        return values.get(item).getOffer();
    }
}