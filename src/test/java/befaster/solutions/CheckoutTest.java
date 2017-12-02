package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckoutTest {
    @Test
    public void calculate_a_price_of_0_when_no_products_in_basket() {
        assertThat(Checkout.checkout(""), is(0));
    }
}
