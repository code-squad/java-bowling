package domain.frame;

import domain.score.Score;
import domain.score.TotalScore;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame("KKJ");
    }

    @Test
    public void toString_Frames() throws Exception {
        assertThat(bowlingGame.toString()).isEqualTo("| KKJ  |    |    |    |    |    |    |    |    |    |    |");
        bowlingGame.addFrame(new NormalFrame(new TotalScore(new Score(10)), 1));
        assertThat(bowlingGame.toString()).isEqualTo("| KKJ  |X   |    |    |    |    |    |    |    |    |    |");
    }

}