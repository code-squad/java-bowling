package domain.frame;

import domain.Player;
import domain.TestScoreBoard;
import domain.TestStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame(new Player("KKJ", new TestStrategy()), new TestScoreBoard());
    }

    @Test
    public void toString_Frames() throws Exception {
        assertThat(bowlingGame.toString()).isEqualTo("| KKJ  |");
    }

}