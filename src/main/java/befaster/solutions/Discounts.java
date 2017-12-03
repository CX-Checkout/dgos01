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
}
