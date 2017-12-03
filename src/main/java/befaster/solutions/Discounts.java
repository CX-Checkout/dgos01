package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

public class Discounts {
    List<Discount> values;

    public Discounts() {
        values = new ArrayList<>();
    }

    public boolean isEmpty() {
        return values.size() == 0;
    }

    public void add(int numberOfItems, int quantityToDiscount) {
        values.add(new Discount(numberOfItems, quantityToDiscount));
    }
    public boolean applyFor(int numberOfItems) {
        for (Discount discount : values)
            if (numberOfItems >= discount.getNumberOfItems())
                return true;
        return false;
    }

    public int getAmountToDiscountFor(int numberOfItems) {
        int total = 0;
        int numberOfItemsConsidered = numberOfItems;
        for (Discount discount: values) {
            int packs = numberOfItemsConsidered / discount.getNumberOfItems();
            numberOfItemsConsidered -= packs * discount.getNumberOfItems();
            total += packs * discount.getQuantityToDiscount();
        }
        return total;
    }
}