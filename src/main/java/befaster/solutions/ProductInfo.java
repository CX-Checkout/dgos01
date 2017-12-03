package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo {
    private int pricePerUnit;
    private Discounts discounts;

    public ProductInfo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.discounts = new Discounts();
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    private boolean hasDiscounts() {
        return discounts.size() > 0;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public boolean hasDiscountsAndApplyFor(Integer numberOfItems) {
        return hasDiscounts() && discounts.applyFor(numberOfItems);
    }

    public int getAmountToDiscountFor(int numberOfItems) {
        return discounts.getAmountToDiscountFor(numberOfItems);
    }

    public void addDiscount(int numberOfItems, int quantityToDiscount) {
        discounts.add(new Discount(numberOfItems, quantityToDiscount));
    }
}