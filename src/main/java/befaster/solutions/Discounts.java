package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

public class Discounts {
    List<Discount> values;

    public Discounts() {
        values = new ArrayList<>();
    }

    public void add(Discount discount) {
        values.add(discount);
    }

    public int size() {
        return values.size();
    }

    public boolean applyFor(int numberOfItems) {
        for (Discount discount : values)
            if (numberOfItems >= discount.getNumberOfItems())
                return true;
        return false;
    }

    public int getAmountToDiscountFor(int numberOfItems) {
        // TODO: taking into account all discounts
        int packs = numberOfItems / this.values.get(0).getNumberOfItems();
        return packs * this.values.get(0).getQuantityToDiscount();
    }
}
