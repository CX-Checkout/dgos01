package befaster.solutions;

import java.util.Optional;

public class ProductInfo {
    private int pricePerUnit;
    private Discounts amountDiscounts;
    private Optional<ProductDiscount> productDiscount;
    private Optional<PackDiscount> packDiscount;

    public ProductInfo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.amountDiscounts = new Discounts();
        this.productDiscount = Optional.empty();
        this.packDiscount = Optional.empty();
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

    public void addPackDiscount(PackDiscount packDiscount) {
        this.packDiscount = Optional.of(packDiscount);
    }
}