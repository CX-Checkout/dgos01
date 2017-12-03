package befaster.solutions;

import java.util.HashMap;

public class Catalog {

    HashMap<Character, ProductInfo> values;

    public Catalog() {
        values = new HashMap<>();
        ProductInfo productInfo = new ProductInfo(50);
        productInfo.addDiscount(new Discount(3, 20));
        productInfo.addDiscount(new Discount(3, 20));
        values.put('A', productInfo);
        productInfo = new ProductInfo(30, new Discount(2, 15));
        values.put('B', productInfo);
        values.put('C', new ProductInfo(20));
        values.put('D', new ProductInfo(15));
    }

    public Integer getPriceFor(char item) {
        return values.get(item).getPricePerUnit();
    }

    public boolean containsDiscountFor(char item, Integer numberOfItems) {
        ProductInfo productInfo = values.get(item);
        return productInfo.hasDiscount() && productInfo.getDiscount().applyFor(numberOfItems);
    }

    public int getDiscountFor(char item, Integer numberOfItems) {
        ProductInfo productInfo = values.get(item);
        return productInfo.getDiscount().getAmountToDiscountFor(numberOfItems);
    }
}