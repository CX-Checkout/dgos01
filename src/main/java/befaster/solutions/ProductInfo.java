package befaster.solutions;

import java.util.Optional;

public class ProductInfo {
    private int pricePerUnit;
    private Optional<Discount> discount;

    public ProductInfo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.discount = Optional.empty();
    }

    public ProductInfo(int pricePerUnit, Discount discount) {
        this.pricePerUnit = pricePerUnit;
        this.discount = Optional.of(discount);
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public boolean hasDiscount() {
        return discount.isPresent();
    }

    public Discount getDiscount() {
        return discount.get();
    }
}