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
            if (!discounts.isEmpty() && applyFor(discounts, numberOfItems, basket)) {
                total += getAmountToDiscountFor(discounts, numberOfItems, basket);
                continue;
            }
        }
        return total;
    }

    private boolean applyFor(Discounts discounts, int numberOfItems, Basket basket) {
        for (Discount discount : discounts.getValues())
            if (discount.apply(numberOfItems, basket))
                return true;
        return false;
    }

    private int getAmountToDiscountFor(Discounts discounts, int numberOfItems, Basket basket) {
        int amountToDiscount = 0;
        int numberOfItemsConsidered = numberOfItems;
        for (Discount discount: discounts.getValues()) {
            amountToDiscount += discount.getAmountToDiscount(numberOfItemsConsidered, basket);
            numberOfItemsConsidered -= discount.getNumberOfAffectedItems(numberOfItemsConsidered, basket);
        }
        return amountToDiscount;
    }
}
