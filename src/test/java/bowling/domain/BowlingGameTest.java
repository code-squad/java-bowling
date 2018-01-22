package bowling.domain;

import bowling.enums.FrameStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void init() {
        bowlingGame = new BowlingGame(Arrays.asList(
                new Player("KH1")
        ));
    }

    @Test
    public void getCurrentPlayerTest() {
        assertThat(bowlingGame.getCurrentPlayer()).isEqualTo(new Player("KH1"));
    }

    @Test
    public void rollBowlingBallTest() {
        bowlingGame.rollBowlingBall(new Pin(10));
        assertThat(bowlingGame.getCurrentPlayer().getState()).isEqualTo(FrameStatus.STRIKE);
    }

    @Test
    public void rotatePlayerTest() {
        bowlingGame.rollBowlingBall(new Pin(10));
        bowlingGame.updatePlayerQueue();
        assertThat(bowlingGame.getCurrentPlayer().getState()).isEqualTo(FrameStatus.NOT_START);
    }
}
