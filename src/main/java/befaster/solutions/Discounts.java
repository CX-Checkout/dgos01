package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

public class Discounts {
    List<AmountDiscount> values;

    public Discounts() {
        values = new ArrayList<>();
    }

    public boolean isEmpty() {
        return values.size() == 0;
    }

    public void add(int numberOfItems, int quantityToDiscount) {
        values.add(new AmountDiscount(numberOfItems, quantityToDiscount));
    }

    public List<AmountDiscount> getValues() {
        return values;
    }
}