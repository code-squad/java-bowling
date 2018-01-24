package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalScoreTest {

    @Test
    public void gutter() throws Exception {
        NormalScore zero = new NormalScore(Pin.ZERO);
        assertThat(zero.toString()).isEqualTo("-");
    }

}