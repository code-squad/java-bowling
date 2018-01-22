package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTypeTest {

    @Test
    public void valueOf() {
        assertThat(ScoreType.valueOf(new ScoreNumber(9), new ScoreNumber(1))).isEqualTo(ScoreType.SPARE);
        assertThat(ScoreType.valueOf(new ScoreNumber(8), new ScoreNumber(2))).isEqualTo(ScoreType.SPARE);
        assertThat(ScoreType.valueOf(new ScoreNumber(7), new ScoreNumber(1))).isEqualTo(ScoreType.MISS);
        assertThat(ScoreType.valueOf(new ScoreNumber(6), new ScoreNumber(2))).isEqualTo(ScoreType.MISS);
        assertThat(ScoreType.valueOf(new ScoreNumber(3), new ScoreNumber(4))).isEqualTo(ScoreType.MISS);
    }

    @Test
    public void valueOf_스트라이크() {
        assertThat(ScoreType.valueOf(new ScoreNumber(10))).isEqualTo(ScoreType.STRIKE);
    }

    @Test
    public void valueOf_GUTTER() {
        assertThat(ScoreType.valueOf(new ScoreNumber(0))).isEqualTo(ScoreType.GUTTER);
        assertThat(ScoreType.valueOf(new ScoreNumber(8), new ScoreNumber(0))).isEqualTo(ScoreType.GUTTER);

    }

    @Test
    public void isDisplay() {
        assertThat(ScoreType.STRIKE.isDisplay()).isTrue();
        assertThat(ScoreType.SPARE.isDisplay()).isTrue();
        assertThat(ScoreType.GUTTER.isDisplay()).isTrue();
        assertThat(ScoreType.MISS.isDisplay()).isFalse();
        assertThat(ScoreType.NONE.isDisplay()).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_음수인경우() {
        ScoreType.valueOf(new ScoreNumber(0), new ScoreNumber(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_합이10보다큰경우() {
        ScoreType.valueOf(new ScoreNumber(10), new ScoreNumber(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_첫번째점수가스트라이크인경우() {
        ScoreType.valueOf(new ScoreNumber(10), new ScoreNumber(0));
    }
}