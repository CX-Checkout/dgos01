package befaster.solutions;

public class DiscountCalculator {
    private Catalog catalog;

    public DiscountCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculateDiscountFor(Basket basket) {
        Basket basketForDiscounts = basket;
        int total = 0;

        for (char item : basketForDiscounts.getItems()) {
            Integer numberOfItems = basketForDiscounts.getNumberOfItemsFor(item);
            if (!catalog.hasProductDiscount(item))
                continue;
            ProductDiscount productDiscount = catalog.getProductDiscount(item);
            if (productDiscount.apply(item, numberOfItems)) {
                char itemToDiscount = productDiscount.getItemToDiscount();
                if (basketForDiscounts.contains(itemToDiscount)) {
                    int packs = productDiscount.getNumberOfPacks(item, numberOfItems);
                    int availableProductsToDiscount = basketForDiscounts.getNumberOfItemsFor(itemToDiscount);
                    int numberOfItemsToDiscount = (availableProductsToDiscount >= packs) ? packs : availableProductsToDiscount;
                    total += numberOfItemsToDiscount * catalog.getPriceFor(itemToDiscount);
                    basketForDiscounts.remove(itemToDiscount, numberOfItemsToDiscount);
                }
            }
        }

        for (char item : basketForDiscounts.getItems()) {
            Integer numberOfItems = basketForDiscounts.getNumberOfItemsFor(item);
            Discounts amountDiscounts = catalog.getDiscountsFor(item);
            if (amountDiscounts.isEmpty())
                continue;
            if (applyFor(amountDiscounts, numberOfItems)) {
                int amountToDiscount = 0;
                int numberOfItemsConsidered = numberOfItems;
                for (AmountDiscount discount : amountDiscounts.getValues()) {
                    amountToDiscount += discount.getAmountToDiscount(numberOfItemsConsidered);
                    numberOfItemsConsidered -= discount.getNumberOfAffectedItems(numberOfItemsConsidered);
                }
                total += amountToDiscount;
            }
        }
        return total;
    }

    private boolean applyFor(Discounts discounts, int numberOfItems) {
        for (AmountDiscount discount : discounts.getValues())
            if (discount.apply(numberOfItems))
                return true;
        return false;
    }

}
