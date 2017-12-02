package befaster.solutions;

import java.util.HashMap;

public class Checkout {
    public static Integer checkout(String skus) {
        HashMap<Character, Integer> prices = new HashMap<Character, Integer>();
        prices.put('A', 50);
        prices.put('B', 30);

        if (skus.length() == 0) return 0;
        int total = 0;
        for (char item: skus.toCharArray()) {
            total += prices.get(item);
        }
        return total;
    }
}
