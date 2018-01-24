package bowling.domain;

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
        assertThat(bowlingGame.createBoard().getCurrentPlayerInfo().getName())
                .isEqualTo("KH1");
    }
}
