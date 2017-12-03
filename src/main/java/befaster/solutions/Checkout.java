package befaster.solutions;

import java.util.HashMap;

public class Checkout {
    public static Integer checkout(String skus) {
        if (skus.length() == 0) return 0;
        if (!skus.matches("[A-Z]+")) return -1;

        HashMap<Character, Integer> pricePerProduct = new HashMap<Character, Integer>();
        pricePerProduct.put('A', 50);
        pricePerProduct.put('B', 30);
        pricePerProduct.put('C', 20);
        pricePerProduct.put('D', 15);

        HashMap<Character, Offer> offerPerProduct = new HashMap<Character, Offer>();
        offerPerProduct.put('A', new Offer(3, 130));
        offerPerProduct.put('B', new Offer(2, 45));

        Basket basket = new Basket(skus);
        HashMap<Character, Integer> quantityPerProduct = new HashMap<>();
        for (char item: skus.toCharArray()) {
            if (!quantityPerProduct.containsKey(item)) {
                quantityPerProduct.put(item, 1);
                continue;
            }
            int quantity = quantityPerProduct.get(item);
            quantityPerProduct.replace(item, quantity + 1);
        }

        int total = 0;
        for (char item: quantityPerProduct.keySet()) {
            Integer quantity = quantityPerProduct.get(item);
            if (offerPerProduct.containsKey(item)) {
                Offer offer = offerPerProduct.get(item);
                if (offer.matches(quantity)) {
                    total += offer.getOfferPrice(quantity);
                    total += offer.getOutOfOfferProducts(quantity) * pricePerProduct.get(item);
                    continue;
                }
            }
            total += quantity * pricePerProduct.get(item);
        }
        return total;
    }
}
