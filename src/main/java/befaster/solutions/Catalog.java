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

        productInfo = new ProductInfo(40);
        productInfo.addProductDiscount(2, 'B');
        values.put('E', productInfo);

        productInfo = new ProductInfo(10);
        productInfo.addProductDiscount(2, 'F');
        values.put('F', productInfo);

        values.put('G', new ProductInfo(20));
        values.put('H', new ProductInfo(10));    | 5H for 45, 10H for 80  |
        values.put('I', new ProductInfo(35));
        values.put('J', new ProductInfo(60));
        values.put('K', new ProductInfo(80));    | 2K for 150             |
        values.put('L', new ProductInfo(90));
        values.put('M', new ProductInfo(15));
        values.put('N', new ProductInfo(40));    | 3N get one M free      |
        values.put('O', new ProductInfo(10));
        values.put('P', new ProductInfo(50));    | 5P for 200             |
        values.put('Q', new ProductInfo(30));    | 3Q for 80              |
        values.put('R', new ProductInfo(50));    | 3R get one Q free      |
        values.put('S', new ProductInfo(30));
        values.put('T', new ProductInfo(20));
        values.put('U', new ProductInfo(40));    | 3U get one U free      |
        values.put('V', new ProductInfo(50));    | 2V for 90, 3V for 130  |
        values.put('W', new ProductInfo(20));
        values.put('X', new ProductInfo(90));
        values.put('Y', new ProductInfo(10));
        values.put('Z', new ProductInfo(50));
    }

    public Integer getPriceFor(char item) {
        ProductInfo productInfo = values.get(item);
        return productInfo.getPricePerUnit();
    }

    public Discounts getDiscountsFor(char item) {
        ProductInfo productInfo = values.get(item);
        return productInfo.getAmountDiscounts();
    }

    public boolean hasProductDiscount(char item) {
        ProductInfo productInfo = values.get(item);
        return productInfo.hasProductDiscount();
    }

    public ProductDiscount getProductDiscount(char item) {
        ProductInfo productInfo = values.get(item);
        return productInfo.getProductDiscount();
    }
}