package domain.score;

import org.junit.Test;

import static domain.score.ScoreNumber.TEN;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void addScore() throws Exception {
        Score s1 = new Score(3);
        Score s2 = new Score(7);

        assertThat(s1.addScore(s2)).isEqualTo(TEN);
    }

    @Test
    public void isStrike() throws Exception {
        Score score = new Score(10);
        assertThat(score.isStrike()).isTrue();
        assertThat(score.toString()).isEqualTo("X");
    }

    @Test
    public void gutter() throws Exception {
        Score zero = new Score(0);

        assertThat(zero.toString()).isEqualTo("-");
    }

    @Test
    public void isStrike_아닌경우() throws Exception {
        assertThat(new Score(8).isStrike()).isFalse();
        assertThat(new Score(7).isStrike()).isFalse();
        assertThat(new Score(2).isStrike()).isFalse();
        assertThat(new Score(1).isStrike()).isFalse();
        assertThat(new Score(0).isStrike()).isFalse();
    }

}