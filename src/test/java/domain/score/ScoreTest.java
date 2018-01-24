package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void isStrike() throws Exception {
        Score score = new Score(Pin.TEN);
        assertThat(score.isStrike()).isTrue();
        assertThat(score.toString()).isEqualTo("X");
    }

    @Test
    public void gutter() throws Exception {
        Score zero = new Score(Pin.ZERO);
        assertThat(zero.toString()).isEqualTo("-");
    }

    @Test
    public void toString_SPARE() throws Exception {
        Score s = new Score(Pin.ZERO);
        s.addSecond(Pin.TEN);

        assertThat(s.toString()).isEqualTo("-|/");
    }

}