package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumTest {

    @Test
    public void compute_sum() {
        assertThat(Sum.sum(1, 1), equalTo(2));
    }

    @Test
    public void compute_sum_with_0_to_100_numbers() {
        assertThat(Sum.sum(1, 10), equalTo(11));
    }

    @Test
    public void throw_error_when_numbers_not_between_1_to_100() {
        assertThat(Sum.sum(1, 10), equalTo(11));
    }
}