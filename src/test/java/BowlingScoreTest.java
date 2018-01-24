import model.BowlingScore;
import model.NormalFrame;
import model.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingScoreTest {

    private BowlingScore bowlingScore;

    @Before
    public void setUp() {
        bowlingScore = new BowlingScore(Score.SIX);
    }

    @Test
    public void addNewScore() {
        bowlingScore.addNewScore(Score.GUTTER);
        assertThat(bowlingScore.toString()).isNotEmpty();
    }

    @Test
    public void hasAnyScore() {
        assertThat(bowlingScore.hasAnyScore()).isTrue();
    }

    @Test
    public void isItOverAndHasNextFrame() {
        assertThat(bowlingScore.isItOverAndHasNextFrame(new NormalFrame())).isFalse();
    }

    @Test
    public void isItOver() {
        assertThat(bowlingScore.isItOver(new NormalFrame())).isFalse();
    }

    @Test
    public void tostring() {
        assertThat(bowlingScore.toString()).isEqualTo("6   ");
    }
}
