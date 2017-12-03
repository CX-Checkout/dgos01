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
            if (!discounts.isEmpty() && applyFor(discounts, numberOfItems)) {
                total += getAmountToDiscountFor(discounts, numberOfItems);
                continue;
            }
        }
        return total;
    }

    public boolean applyFor(Discounts discounts, int numberOfItems) {
        for (Discount discount : discounts.getValues())
            if (numberOfItems >= discount.getNumberOfItems())
                return true;
        return false;
    }

    public int getAmountToDiscountFor(Discounts discounts, int numberOfItems) {
        int amountToDiscount = 0;
        int numberOfItemsConsidered = numberOfItems;
        for (Discount discount: discounts.getValues()) {
            int packs = numberOfItemsConsidered / discount.getNumberOfItems();
            numberOfItemsConsidered -= packs * discount.getNumberOfItems();
            amountToDiscount += packs * discount.getAmountToDiscountPerPack();
        }
        return amountToDiscount;
    }
}
