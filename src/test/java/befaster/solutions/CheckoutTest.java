package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckoutTest {
    @Test
    public void not_calculate_when_illegal_input() {
        assertThat(Checkout.checkout("123"), is(-1));
    }

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
        assertThat(Checkout.checkout("AD"), is(65));
    }

    @Test
    public void calculate_the_price_when_repeated_products_in_the_basket() {
        assertThat(Checkout.checkout("AABCCC"), is(190));
    }

    @Test
    public void calculate_the_price_when_repeated_products_and_offers_in_the_basket() {
        assertThat(Checkout.checkout("AAA"), is(130));
        assertThat(Checkout.checkout("BB"), is(45));
        assertThat(Checkout.checkout("AABAB"), is(175));
    }
}
