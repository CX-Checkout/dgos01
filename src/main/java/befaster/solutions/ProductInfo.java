package befaster.solutions;

import java.util.Optional;

public class ProductInfo {
    private int price;
    private Optional<Discount> discount;

    public ProductInfo(int price) {
        this.price = price;
        this.discount = Optional.empty();
    }

    public ProductInfo(int price, Discount discount) {
        this.price = price;
        this.discount = Optional.of(discount);
    }

    public int getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount.isPresent();
    }

    public Discount getDiscount() {
        return discount.get();
    }
}
