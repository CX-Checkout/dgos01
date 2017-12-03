package befaster.solutions;

import java.util.HashMap;

public class Catalog {

    HashMap<Character, ProductInfo> values;

    public Catalog() {
        values = new HashMap<>();

        ProductInfo productInfo = new ProductInfo(50);
        productInfo.addDiscount(5, 50);
        productInfo.addDiscount(3, 20);
        values.put('A', productInfo);

        productInfo = new ProductInfo(30);
        productInfo.addDiscount(2, 15);
        values.put('B', productInfo);

        values.put('C', new ProductInfo(20));
        values.put('D', new ProductInfo(15));

//        productInfo = new ProductInfo(40);
//        productInfo.addProductDiscount(2, 'B');
//        values.put('E', productInfo);
    }

    public Integer getPriceFor(char item) {
        ProductInfo productInfo = values.get(item);
        return productInfo.getPricePerUnit();
    }

    public Discounts getDiscountsFor(char item) {
        ProductInfo productInfo = values.get(item);
        return productInfo.getDiscounts();
    }
}