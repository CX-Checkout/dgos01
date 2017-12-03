package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {
        if (!isValid(skus)) return -1;

        Catalog catalog = new Catalog();
        Basket basket = new Basket(skus);

        int total = 0;
        for (char item: basket.getItems()) {
            Integer quantity = basket.getQuantityFor(item);
            if (catalog.containsOfferFor(item)) {
                Offer offer = catalog.getOfferFor(item);
                if (offer.matches(quantity)) {
                    total += offer.getOfferPrice(quantity);
                    total += offer.getOutOfOfferProducts(quantity) * catalog.getPriceFor(item);
                    continue;
                }
            }
            total += quantity * catalog.getPriceFor(item);
        }
        return total;
    }

    private static boolean isValid(String skus) {
        return skus.matches("[A-Z]*");
    }
}
