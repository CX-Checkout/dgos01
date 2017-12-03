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

    public boolean hasDiscounts() {
        return discounts.size() > 0;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }
}
