package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StrikeTest {
    @Test
    public void toString_STRIKE() throws Exception {
        assertThat(new Strike().toString()).isEqualTo("X");
    }

}