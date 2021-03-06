package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

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

        PackDiscount packDiscount = new PackDiscount(3, 45, 'Z', 'S', 'T', 'Y', 'X');
        for (char item: packDiscount.getItems()) {
            while (basket.contains(item)) {
                List<Character> candidates = new ArrayList<>();
                candidates.add(item);
                basket.remove(item, 1);
                int index = 0;
                while (candidates.size() < packDiscount.getNumberOfItems() && index < packDiscount.getSizeOfPossibleItems()) {
                    char possibleCandidate = packDiscount.getItemForIndex(index);
                    if (basket.contains(possibleCandidate)) {
                        candidates.add(possibleCandidate);
                        basket.remove(possibleCandidate, 1);
                    } else
                        index++;
                }
                if (candidates.size() != packDiscount.getNumberOfItems()) {
                    for (char candidate : candidates)
                        basket.add(candidate, 1);
                    break;
                }

                for (char candidate : candidates) {
                    total += catalog.getPriceFor(candidate);
                }
                total -= packDiscount.getPricePerPack();
            }
        }
        return total;
    }
}