package befaster.solutions;

import java.util.HashMap;

public class Checkout {
    public static Integer checkout(String skus) {
        if (skus.length() == 0) return 0;
        if (!skus.matches("[A-Z]+")) return -1;

//        HashMap<Character, Integer> pricePerProduct = new HashMap<Character, Integer>();
//        pricePerProduct.put('A', 50);
//        pricePerProduct.put('B', 30);
//        pricePerProduct.put('C', 20);
//        pricePerProduct.put('D', 15);

        HashMap<Character, Offer> offerPerProduct = new HashMap<Character, Offer>();
        offerPerProduct.put('A', new Offer(3, 130));
        offerPerProduct.put('B', new Offer(2, 45));

        Catalog catalog = new Catalog();
        Basket basket = new Basket(skus);

        int total = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            if (offerPerProduct.containsKey(item)) {
                Offer offer = offerPerProduct.get(item);
                if (offer.matches(quantity)) {
                    total += offer.getOfferPrice(quantity);
                    total += offer.getOutOfOfferProducts(quantity) * catalog.getPriceFor(item);
//                    total += offer.getOutOfOfferProducts(quantity) * pricePerProduct.get(item);
                    continue;
                }
            }
            total += quantity * catalog.getPriceFor(item);
//            total += quantity * pricePerProduct.get(item);
        }
        return total;
    }
}
