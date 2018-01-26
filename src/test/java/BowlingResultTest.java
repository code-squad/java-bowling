import model.BowlingGame;
import model.BowlingResult;
import model.CreateFrame;
import model.Frame;
import model.NormalFrame;
import model.Player;
import model.Score;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingResultTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame(new Player("CJH"));
    }

    @Test
    public void getTotalScore() {
        Frame frame = new NormalFrame();
        bowlingGame.getBowlingResult().calculateUntilNow(frame);
        List<String> result = bowlingGame.getBowlingResult().getTotalScore();
        assertThat(result).isEmpty();
    }
}
