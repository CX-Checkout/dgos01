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
                if (apply(discounts, numberOfItems))
                    total += getAmountToDiscount(discounts, numberOfItems);
            }
        }
        return total;
    }

    private boolean apply(Discounts discounts, int numberOfItems) {
        for (Discount discount : discounts.getValues())
            if (discount.apply(numberOfItems))
                return true;
        return false;
    }

    private int getAmountToDiscount(Discounts discounts, int numberOfItems) {
        int amountToDiscount = 0;
        int numberOfItemsConsidered = numberOfItems;
        for (Discount discount: discounts.getValues()) {
            numberOfItemsConsidered -= discount.getNumberOfAffectedItems(numberOfItemsConsidered);
            amountToDiscount += discount.getAmountToDiscount(numberOfItemsConsidered);
        }
        return amountToDiscount;
    }
}
