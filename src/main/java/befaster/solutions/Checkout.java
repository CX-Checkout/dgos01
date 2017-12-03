package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {
        if (!isValid(skus)) return -1;

        Catalog catalog = new Catalog();
        Basket basket = new Basket(skus);

        PriceCalculator priceCalculator = new PriceCalculator(catalog);
        int totalPrice = priceCalculator.calculatePriceFor(basket);
        int total = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            total += quantity * catalog.getPriceFor(item);
        }

        int toDiscount = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            if (catalog.containsDiscountFor(item)) {
                Discount discount = catalog.getDiscountFor(item);
                if (discount.matches(quantity)) {
                    toDiscount += discount.getDiscount(quantity);
                    continue;
                }
            }
        }
        return total - toDiscount;
    }

    private static boolean isValid(String skus) {
        return skus.matches("[A-Z]*");
    }
}
