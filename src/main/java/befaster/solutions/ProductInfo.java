package befaster.solutions;

public class ProductInfo {
    private int pricePerUnit;
    private Discounts amountDiscounts;
    private ProductDiscount productDiscount;

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
        productDiscount = new ProductDiscount(numberOfItems, itemToDiscount);
    }
}