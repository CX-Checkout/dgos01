package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelloTest {
    @Test
    public void should_return_a_message() {
        assertThat(Hello.hello("John"), is("Hello, John!"));
    }
}
