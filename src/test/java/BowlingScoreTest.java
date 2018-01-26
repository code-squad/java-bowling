import model.BowlingScore;
import model.Frame;
import model.NormalFrame;
import model.Score;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void addFirstAndSecond(){
        bowlingScore.addNewScore(Score.ONE);
        assertThat(bowlingScore.addFirstAndSecond()).isEqualTo(7);
    }

    @Test
    public void hasStrikeOrSpare(){
        bowlingScore.addNewScore(Score.SPARE);
        assertThat(bowlingScore.hasStrikeOrSpare()).isTrue();
    }

}
