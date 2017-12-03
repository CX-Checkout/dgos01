package befaster.solutions;

public class DiscountCalculator {
    private Catalog catalog;

    public DiscountCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculateDiscountFor(Basket basket) {
        Basket basketForDiscounts = basket;
        int total = 0;

        for (char item: basketForDiscounts.getItems()) {
            Integer numberOfItems = basketForDiscounts.getNumberOfItemsFor(item);
            if (!catalog.hasProductDiscount(item))
                continue;
            ProductDiscount productDiscount = catalog.getProductDiscount(item);
            if (numberOfItems >= productDiscount.getNumberOfItems()) {
                char itemToDiscount = productDiscount.getItemToDiscount();
                if (basketForDiscounts.contains(itemToDiscount)) {
                    int packs = numberOfItems / productDiscount.getNumberOfItems();
                    int availableProductsToDiscount = basketForDiscounts.getNumberOfItemsFor(itemToDiscount);
                    int itemsForDiscount = 0;
                    if (availableProductsToDiscount >= packs)
                        itemsForDiscount = packs;
                    else
                        itemsForDiscount = availableProductsToDiscount;
                    total += itemsForDiscount * catalog.getPriceFor(itemToDiscount);
                    basketForDiscounts.remove(itemToDiscount, itemsForDiscount);
                }
            }
        }

        for (char item: basketForDiscounts.getItems()) {
            Integer numberOfItems = basketForDiscounts.getNumberOfItemsFor(item);
            Discounts amountDiscounts = catalog.getDiscountsFor(item);
            if (!amountDiscounts.isEmpty() && applyFor(amountDiscounts, numberOfItems)) {
                total += getAmountToDiscountFor(amountDiscounts, numberOfItems);
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

    private int getAmountToDiscountFor(Discounts discounts, int numberOfItems) {
        int amountToDiscount = 0;
        int numberOfItemsConsidered = numberOfItems;
        for (AmountDiscount discount: discounts.getValues()) {
            amountToDiscount += discount.getAmountToDiscount(numberOfItemsConsidered);
            numberOfItemsConsidered -= discount.getNumberOfAffectedItems(numberOfItemsConsidered);
        }
        return amountToDiscount;
    }
}
