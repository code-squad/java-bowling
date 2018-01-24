import model.BowlingGame;
import model.BowlingScore;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {
    private Player player;
    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        player = new Player("CJH");
        bowlingGame = new BowlingGame(player);
    }

    @Test
    public void progressGame() {
        Integer before = bowlingGame.getCurrentFrameNumber();
        bowlingGame.progressGame(3);
        bowlingGame.progressGame(3);
        Integer after = bowlingGame.getCurrentFrameNumber();

        assertThat(after).isGreaterThan(before);
    }

    @Test
    public void getResult() {
        bowlingGame.progressGame(3);
        bowlingGame.progressGame(3);
        List<BowlingScore> result = bowlingGame.getResult();

        assertThat(result.get(0).toString()).isEqualTo("3|3 ");
    }

    @Test
    public void getPlayerName() {
        assertThat(bowlingGame.getPlayerName()).isEqualTo("CJH");
    }

    @Test
    public void isItOverAndHasNextFrame() {
        bowlingGame.progressGame(3);
        assertThat(bowlingGame.isItOverAndHasNextFrame()).isFalse();
    }

    @Test
    public void getCurrentFrameNumber() {
        assertThat(bowlingGame.getCurrentFrameNumber()).isEqualTo(1);
    }

    @Test
    public void isLast() {
        assertThat(bowlingGame.isLast()).isFalse();
    }
}
