package bowling.domain;

import bowling.type.ScoreType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    private List<Score> scores;

    @Before
    public void setUp() throws Exception {
        scores = new ArrayList<>();
    }

    @Test
    public void match_거터() {
        ScoreType type = Score.match(scores, 0);
        assertThat(type).isEqualTo(ScoreType.GUTTER);

        scores.add(new Score(ScoreType.MISS, 8));
        type = Score.match(scores, 0);
        assertThat(type).isEqualTo(ScoreType.GUTTER);
    }

    @Test
    public void match_스트라이크() {
        ScoreType type = Score.match(scores, 10);
        assertThat(type).isEqualTo(ScoreType.STRIKE);
    }

    @Test
    public void match_미스() {
        ScoreType type = Score.match(scores, 5);
        assertThat(type).isEqualTo(ScoreType.MISS);
    }

    @Test
    public void match_미스_스페어() {
        scores.add(new Score(ScoreType.MISS, 1));

        ScoreType type = Score.match(scores, 9);
        assertThat(type).isEqualTo(ScoreType.SPARE);

    }

    @Test
    public void match_거터_스페어() {
        scores.add(new Score(ScoreType.GUTTER, 0));

        ScoreType type = Score.match(scores, 10);
        assertThat(type).isEqualTo(ScoreType.SPARE);
    }

    @Test
    public void is() {
        Score score = new Score(ScoreType.GUTTER, 0);

        assertThat(score.is(ScoreType.GUTTER)).isTrue();
        assertThat(score.is(ScoreType.STRIKE)).isFalse();

    }

    @Test
    public void express() {
        Score score = new Score(ScoreType.GUTTER, 0);
        assertThat(score.express()).isEqualTo("-");

        Score strike = new Score(ScoreType.STRIKE, 10);
        assertThat(strike.express()).isEqualTo("X");

        Score spare = new Score(ScoreType.SPARE, 10);
        assertThat(spare.express()).isEqualTo("/");

        Score miss = new Score(ScoreType.MISS, 8);
        assertThat(miss.express()).isEqualTo("8");

    }
}