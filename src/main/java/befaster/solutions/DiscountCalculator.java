package befaster.solutions;

public class DiscountCalculator {
    private Catalog catalog;

    public DiscountCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculateDiscountFor(Basket basket) {
        int toDiscount = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            if (catalog.containsDiscountFor(item)) {
                Discount discount = catalog.getDiscountFor(item);
                if (discount.matches(quantity)) {
                    toDiscount += discount.getDiscount(quantity);
                    continue;
                }
            }
        }
        return toDiscount;
    }
}
