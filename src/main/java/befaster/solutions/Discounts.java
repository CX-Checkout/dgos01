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

    public void add(Discount discount) {
        values.add(discount);
    }

    public List<Discount> getValues() {
        return values;
    }
}