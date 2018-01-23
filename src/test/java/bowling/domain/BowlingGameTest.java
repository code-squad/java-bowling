package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static bowling.enums.FrameStatus.*;
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
        bowlingGame.rollBowlingBall(new Pin(5));
        assertThat(bowlingGame.getCurrentPlayer().getState()).isEqualTo(NOT_END);
    }

    @Test
    public void rotatePlayerTest() {
        bowlingGame.rollBowlingBall(new Pin(10));
        assertThat(bowlingGame.getCurrentPlayer().getState()).isEqualTo(NOT_START);
    }
}
