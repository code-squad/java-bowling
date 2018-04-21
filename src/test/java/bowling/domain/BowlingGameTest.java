package bowling.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void 볼링_게임_시작() {
        String playerName = "KHG";
        BowlingGame bowlingGame = new BowlingGame(playerName);

        assertThat(bowlingGame.toString())
                .isEqualTo(
                        "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n" +
                        "|  KHG |      |      |      |      |      |      |      |      |      |      |");
    }
}