package befaster.solutions;

public class Checkout {

    public static Integer checkout(String skus) {
        if (!isValid(skus)) return -1;

        Catalog catalog = new Catalog();
        Basket basket = new Basket(skus);

        PriceCalculator priceCalculator = new PriceCalculator(catalog);
        int totalPrice = priceCalculator.calculatePriceFor(basket);

        DiscountCalculator discountCalculator = new DiscountCalculator(catalog);
        int priceToDiscount = discountCalculator.calculateDiscountFor(basket);

        return totalPrice - priceToDiscount;
    }

    private static boolean isValid(String skus) {
        return skus.matches("[A-Z]*");
    }
}