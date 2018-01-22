package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void init() {
        bowlingGame = new BowlingGame("KKH");
    }

    @Test
    public void showStateTest() {
        assertThat(bowlingGame.printView()).isEqualTo(
                "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n" +
                "|  KKH |      |      |      |      |      |      |      |      |      |      |"
        );
    }

    @Test
    public void getCurrentInfo() {
        assertThat(bowlingGame.getCurrentInfo()).isEqualTo(new CurrentInfo("KKH", 0));
    }

    @Test
    public void rollBowlingBallTest() {
        bowlingGame.rollBowlingBall(new CurrentInfo("KKH", 0), new Pin(10));
        assertThat(bowlingGame.printView()).isEqualTo(
                "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n" +
                "|  KKH |  X   |      |      |      |      |      |      |      |      |      |"
        );
    }
}
