package befaster.solutions;

public class DiscountCalculator {
    private Catalog catalog;

    public DiscountCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculateDiscountFor(Basket basket) {
        int total = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            if (catalog.containsDiscountFor(item, quantity)) {
                total += catalog.getDiscountFor(item, quantity);
                continue;
            }
        }
        return total;
    }
}
