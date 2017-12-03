package befaster.solutions;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ProductInfo {
    private int pricePerUnit;
    private Discounts amountDiscounts;
    private Optional<ProductDiscount> productDiscount;

    public ProductInfo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.amountDiscounts = new Discounts();
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void addDiscount(int numberOfItems, int quantityToDiscount) {
        amountDiscounts.add(numberOfItems, quantityToDiscount);
    }

    public Discounts getAmountDiscounts() {
        return amountDiscounts;
    }

    public void addProductDiscount(int numberOfItems, char itemToDiscount) {
        productDiscount = Optional.of(new ProductDiscount(numberOfItems, itemToDiscount));
    }

    public boolean hasProductDiscount() {
        return productDiscount.isPresent();
    }

    public ProductDiscount getProductDiscount() {
        return productDiscount.get();
    }
}