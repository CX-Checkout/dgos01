package befaster.solutions;

public class DiscountCalculator {
    private Catalog catalog;

    public DiscountCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculateDiscountFor(Basket basket) {
        int total = 0;
        for (char item: basket.getItems()) {
            Integer numberOfItems = basket.getNumberOfItemsFor(item);
            Discounts discounts = catalog.getDiscountsFor(item);
            if (!discounts.isEmpty()) {
                for (Discount discount: discounts.getValues()) {

                }
//            if (catalog.containsDiscountFor(item, numberOfItems)) {
//                total += catalog.getAmountToDiscountFor(item, numberOfItems);
//                total += catalog.getAmountToDiscountFor(item, numberOfItems);
//                continue;
            }
        }
        return total;
    }
}