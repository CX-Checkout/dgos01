package befaster.solutions;

import java.util.HashMap;

public class Catalog {

    HashMap<Character, ProductInfo> values;

    public Catalog() {
        values = new HashMap<>();
        values.put('A', new ProductInfo(50, new Discount(3, 20)));
        values.put('B', new ProductInfo(30, new Discount(2, 15)));
        values.put('C', new ProductInfo(20));
        values.put('D', new ProductInfo(15));
    }

    public Integer getPriceFor(char item) {
        return values.get(item).getPrice();
    }

    public boolean containsDiscountFor(char item, Integer quantity) {
        return values.get(item).hasDiscount() && values.get(item).getDiscount().matches(quantity);
    }

    public int getDiscountFor(char item, Integer quantity) {
        return values.get(item).getDiscount().getDiscount(quantity);
    }
}
