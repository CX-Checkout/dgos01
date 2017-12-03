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
            Discounts amountDiscounts = catalog.getDiscountsFor(item);
            if (!amountDiscounts.isEmpty() && applyFor(amountDiscounts, numberOfItems)) {
                total += getAmountToDiscountFor(amountDiscounts, numberOfItems);
                continue;
            }

            if (catalog.hasProductDiscount(item)) {
                ProductDiscount productDiscount = catalog.getProductDiscount(item);
                if (numberOfItems >= productDiscount.getNumberOfItems()) {
                    if (basket.contains(productDiscount.getProductToDiscount())) {
                        int packs = numberOfItems / productDiscount.getNumberOfItems();
                        int availableProductsToDiscount = basket.getNumberOfItemsFor(productDiscount.getProductToDiscount());
                        if (availableProductsToDiscount >= packs)
                            total += packs * catalog.getPriceFor(productDiscount.getProductToDiscount());
                        else
                            total += availableProductsToDiscount * catalog.getPriceFor(productDiscount.getProductToDiscount());
                    }
                }
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