package befaster.solutions;

import java.util.HashMap;

public class Checkout {
    public static Integer checkout(String skus) {
        HashMap<Character, Integer> pricePerProduct = new HashMap<Character, Integer>();
        pricePerProduct.put('A', 50);
        pricePerProduct.put('B', 30);
        pricePerProduct.put('C', 20);

        HashMap<Character, Offer> offerPerProduct = new HashMap<Character, Offer>();
        offerPerProduct.put('A', new Offer(3, 130));

        HashMap<Character, Integer> quantityPerProduct = new HashMap<>();

        if (skus.length() == 0) return 0;
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
            total += quantityPerProduct.get(item) * pricePerProduct.get(item);
        }
        return total;
    }
}
