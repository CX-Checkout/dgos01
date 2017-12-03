package befaster.solutions;

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

    public boolean hasDiscountsAndApplyFor(Integer numberOfItems) {
        return !discounts.isEmpty() && discounts.applyFor(numberOfItems);
    }

    public int getAmountToDiscountFor(int numberOfItems) {
        return discounts.getAmountToDiscountFor(numberOfItems);
    }

    public void addDiscount(int numberOfItems, int quantityToDiscount) {
        discounts.add(numberOfItems, quantityToDiscount);
    }

    public Discounts getDiscounts() {
        return discounts;
    }
}