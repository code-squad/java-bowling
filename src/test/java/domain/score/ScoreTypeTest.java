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
    public void valueOf_스트라이크() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(10));
        assertThat(ScoreType.valueOf(totalScore)).isEqualTo(STRIKE);
    }

    @Test
    public void valueOf_스페어() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        totalScore.addSecondScore(new Score(3));

        assertThat(ScoreType.valueOf(totalScore)).isEqualTo(SPARE);
    }

    @Test
    public void valueOf_미스() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        totalScore.addSecondScore(new Score(2));

        assertThat(ScoreType.valueOf(totalScore)).isEqualTo(MISS);
    }

    @Test
    public void valueOf_거터() throws Exception {
        assertThat(ScoreType.valueOf(new ScoreNumber(0))).isEqualTo(GUTTER);
    }

    @Test
    public void valueOf_NONE() throws Exception {
        assertThat(ScoreType.valueOf(new ScoreNumber(7))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new ScoreNumber(1))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new ScoreNumber(2))).isEqualTo(NONE);
        assertThat(ScoreType.valueOf(new ScoreNumber(9))).isEqualTo(NONE);
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