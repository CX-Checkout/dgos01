package befaster.solutions;

public class DiscountCalculator {
    private Catalog catalog;

    public DiscountCalculator(Catalog catalog) {
        this.catalog = catalog;
    }

    public int calculateDiscountFor(Basket initialBasket) {
        Basket basket = initialBasket;
        int total = 0;

        for (char item : basket.getItems()) {
            if (!catalog.hasProductDiscount(item))
                continue;
            ProductDiscount productDiscount = catalog.getProductDiscount(item);
            char itemToDiscount = productDiscount.getItemToDiscount();
            Integer numberOfItems = basket.getNumberOfItemsFor(item);
            while (productDiscount.apply(item, numberOfItems) && basket.contains(itemToDiscount)) {
                total += catalog.getPriceFor(itemToDiscount);
                basket.remove(item, productDiscount.getNumberOfItems());
                basket.remove(itemToDiscount, 1);
                numberOfItems = basket.getNumberOfItemsFor(item);
            }
        }

        for (char item : basket.getItems()) {
            Discounts amountDiscounts = catalog.getDiscountsFor(item);
            if (amountDiscounts.isEmpty())
                continue;
            for (AmountDiscount discount : amountDiscounts.getValues()) {
                Integer numberOfItems = basket.getNumberOfItemsFor(item);
                while (discount.apply(numberOfItems)) {
                    total += discount.getAmountToDiscountPerPack();
                    basket.remove(item, discount.getNumberOfItems());
                    numberOfItems = basket.getNumberOfItemsFor(item);
                }
            }
        }
        return total;
    }
}