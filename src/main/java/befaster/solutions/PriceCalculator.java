package befaster.solutions;

public class PriceCalculator {
    private Catalog catalog;

    public PriceCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculatePriceFor(Basket basket) {
        int total = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            total += quantity * catalog.getPriceFor(item);
        }
        return total;
    }
}
