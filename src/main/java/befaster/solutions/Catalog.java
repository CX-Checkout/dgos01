package befaster.solutions;

import java.util.HashMap;
import java.util.Optional;

public class Catalog {

//    HashMap<Character, Integer> pricePerProduct;
//    HashMap<Character, Offer> offerPerProduct;
    HashMap<Character, ProductInfo> values;

    public Catalog() {
//        pricePerProduct = new HashMap<>();
//        pricePerProduct.put('A', 50);
//        pricePerProduct.put('B', 30);
//        pricePerProduct.put('C', 20);
//        pricePerProduct.put('D', 15);
//
//        offerPerProduct = new HashMap<>();
//        offerPerProduct.put('A', new Offer(3, 130));
//        offerPerProduct.put('B', new Offer(2, 45));

        values = new HashMap<>();
        values.put('A', new ProductInfo(50, Optional.of(new Offer(3, 130))));
        values.put('B', new ProductInfo(30, Optional.of(new Offer(2, 45))));
        values.put('C', new ProductInfo(20));
        values.put('D', new ProductInfo(15));
    }


    public Integer getPriceFor(char item) {
        return values.get(item).getPrice();
//        return pricePerProduct.get(item);
    }

    public boolean containsOfferFor(char item) {
        return values.get(item).hasOffer();
//        return offerPerProduct.containsKey(item);
    }

    public Offer getOfferFor(char item) {
        return values.get(item).getOffer();
//        return offerPerProduct.get(item);
    }
}
