package befaster.solutions;

import java.util.HashMap;
import java.util.Set;

public class Basket {

    HashMap<Character, Integer> quantityPerProduct;

    public Basket(String skus) {
        quantityPerProduct = new HashMap<>();
        for (char item: skus.toCharArray()) {
            if (!quantityPerProduct.containsKey(item)) {
                quantityPerProduct.put(item, 1);
                continue;
            }
            int quantity = quantityPerProduct.get(item);
            quantityPerProduct.replace(item, quantity + 1);
        }
    }

    public Set<Character> getItems() {
        return quantityPerProduct.keySet();
    }

    public int getNumberOfItemsFor(char item) {
        return quantityPerProduct.get(item);
    }
}
