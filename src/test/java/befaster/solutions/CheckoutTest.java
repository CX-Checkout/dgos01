package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckoutTest {
    @Test
    public void calculate_the_price_when_no_products_in_the_basket() {
        assertThat(Checkout.checkout(""), is(0));
    }

    @Test
    public void calculate_the_price_when_only_one_product_in_the_basket() {
        assertThat(Checkout.checkout("A"), is(50));
    }

    @Test
    public void calculate_the_price_when_two_products_in_the_basket() {
        assertThat(Checkout.checkout("AB"), is(80));
    }
}
