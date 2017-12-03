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

        productInfo = new ProductInfo(10);
        productInfo.addDiscount(10, 20);
        productInfo.addDiscount(5, 5);
        values.put('H', productInfo);

        values.put('I', new ProductInfo(35));
        values.put('J', new ProductInfo(60));

        productInfo = new ProductInfo(70);
        productInfo.addDiscount(2, 20);
        values.put('K', productInfo);

        values.put('L', new ProductInfo(90));
        values.put('M', new ProductInfo(15));


        productInfo = new ProductInfo(40);
        productInfo.addProductDiscount(3, 'M');
        values.put('N', productInfo);

        values.put('O', new ProductInfo(10));

        productInfo = new ProductInfo(50);
        productInfo.addDiscount(5, 50);
        values.put('P', productInfo);

        productInfo = new ProductInfo(30);
        productInfo.addDiscount(3, 10);
        values.put('Q', productInfo);

        productInfo = new ProductInfo(50);
        productInfo.addProductDiscount(3, 'Q');
        values.put('R', productInfo);

        values.put('S', new ProductInfo(30));
        values.put('T', new ProductInfo(20));

        productInfo = new ProductInfo(40);
        productInfo.addProductDiscount(3, 'U');
        values.put('U', productInfo);

        productInfo = new ProductInfo(50);
        productInfo.addDiscount(3, 20);
        productInfo.addDiscount(2, 10);
        values.put('V', productInfo);

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