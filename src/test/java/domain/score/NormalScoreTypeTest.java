package domain.score;

import org.junit.Test;

import static domain.score.ScoreType.GUTTER;
import static domain.score.ScoreType.MISS;
import static domain.score.ScoreType.NONE;
import static domain.score.ScoreType.SPARE;
import static domain.score.ScoreType.STRIKE;
import static domain.score.ScoreType.UNDEFINED;
import static org.assertj.core.api.Assertions.assertThat;

public class NormalScoreTypeTest {

    @Test
    public void valueOf_거터() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(0))).isEqualTo(GUTTER);
    }

    @Test
    public void valueOf_NONE() throws Exception {
        assertThat(ScoreType.valueOf(new Pin(7))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new Pin(1))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new Pin(2))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new Pin(9))).isEqualTo(NONE);
    }

    @Test
    public void getDisplay() throws Exception {
        assertThat(STRIKE.getDisplay()).isEqualTo("X");
        assertThat(SPARE.getDisplay()).isEqualTo("/");
        assertThat(GUTTER.getDisplay()).isEqualTo("-");
    }

    @Test
    public void isDisplay() throws Exception {
        assertThat(STRIKE.isDisplay()).isTrue();
        assertThat(SPARE.isDisplay()).isTrue();
        assertThat(GUTTER.isDisplay()).isTrue();
        assertThat(MISS.isDisplay()).isFalse();
        assertThat(NONE.isDisplay()).isFalse();
        assertThat(UNDEFINED.isDisplay()).isFalse();
    }

}