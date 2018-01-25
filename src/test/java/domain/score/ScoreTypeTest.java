package domain.score;

import org.junit.Test;

import static domain.score.ScoreType.GUTTER;
import static domain.score.ScoreType.MISS;
import static domain.score.ScoreType.NONE;
import static domain.score.ScoreType.SPARE;
import static domain.score.ScoreType.STRIKE;
import static domain.score.ScoreType.UNDEFINED;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTypeTest {

    @Test
    public void valueOf_거터() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(0))).isEqualTo(GUTTER);
    }

    @Test
    public void valueOf_STRIKE() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(10))).isEqualTo(STRIKE);
    }

    @Test
    public void valueOf_NONE() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(7))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new Pin(1))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new Pin(2))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new Pin(9))).isEqualTo(NONE);
    }

    @Test
    public void valueOf_SPARE() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(3), new Pin(7))).isEqualTo(SPARE);
        assertThat(ScoreType.valueOf(new Pin(2), new Pin(8))).isEqualTo(SPARE);
        assertThat(ScoreType.valueOf(new Pin(1), new Pin(9))).isEqualTo(SPARE);
        assertThat(ScoreType.valueOf(new Pin(5), new Pin(5))).isEqualTo(SPARE);
        assertThat(ScoreType.valueOf(new Pin(0), new Pin(10))).isEqualTo(SPARE);
    }

    @Test
    public void valueOf_MISS() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(3), new Pin(6))).isEqualTo(MISS);
        assertThat(ScoreType.valueOf(new Pin(2), new Pin(7))).isEqualTo(MISS);
        assertThat(ScoreType.valueOf(new Pin(1), new Pin(8))).isEqualTo(MISS);
        assertThat(ScoreType.valueOf(new Pin(5), new Pin(4))).isEqualTo(MISS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_합이10이넘은경우() throws Exception {
        ScoreType.valueOf(new Pin(7), new Pin(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_스트라이크가있는경우() throws Exception {
        ScoreType.valueOf(new Pin(10), new Pin(0));
    }

    @Test
    public void getDisplay() throws Exception {
        assertThat(STRIKE.getDisplay()).isEqualTo("X");
        assertThat(SPARE.getDisplay()).isEqualTo("/");
        assertThat(GUTTER.getDisplay()).isEqualTo("-");
    }

    @Test
    public void isDisplay() throws Exception {
        assertThat(UNDEFINED.isDisplay()).isFalse();
        assertThat(STRIKE.isDisplay()).isTrue();
        assertThat(SPARE.isDisplay()).isTrue();
        assertThat(GUTTER.isDisplay()).isTrue();
        assertThat(MISS.isDisplay()).isFalse();
        assertThat(NONE.isDisplay()).isFalse();

    }

}