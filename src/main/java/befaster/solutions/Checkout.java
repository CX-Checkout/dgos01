package befaster.solutions;

public class Checkout {
    public static Integer checkout(String skus) {
//        if (skus.length() == 0) return 0;
        if (!skus.matches("[A-Z]*")) return -1;

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
}
