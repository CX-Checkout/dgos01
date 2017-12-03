package befaster.solutions;

import java.util.HashMap;

public class Catalog {

    HashMap<Character, Integer> pricePerProduct;
    HashMap<Character, Offer> offerPerProduct;

    public Catalog() {
        pricePerProduct = new HashMap<>();
        pricePerProduct.put('A', 50);
        pricePerProduct.put('B', 30);
        pricePerProduct.put('C', 20);
        pricePerProduct.put('D', 15);

        offerPerProduct = new HashMap<>();
        offerPerProduct.put('A', new Offer(3, 130));
        offerPerProduct.put('B', new Offer(2, 45));
    }


    public Integer getPriceFor(char item) {
        return pricePerProduct.get(item);
    }

    public boolean containsOfferFor(char item) {
        return offerPerProduct.containsKey(item);
    }

    public Offer getOfferFor(char item) {
        return offerPerProduct.get(item);
    }
}
