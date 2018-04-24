package bowling.domain.frame.score;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    private Score score;

    @Test
    public void oneBowlAway_True_Spare() {
        score = Score.ofSpare();
        assertTrue(score.isOneBowlAway());
    }

    @Test
    public void twoBowlsAway_Strike() {
        score = Score.ofStrike();
        assertTrue(score.isTwoBowlsAway());
    }

    @Test
    public void bowl_readyForDisplay() {
        score = Score.ofStrike();
        score.bowl(8);
        score.bowl(1);
        assertTrue(score.isReadyForDisplay());
    }

    @Test
    public void bowl_oneBowlAway() {
        score = Score.ofStrike();
        score.bowl(8);
        assertTrue(score.isOneBowlAway());
    }

    @Test
    public void calculateNewTotal() {
        score = Score.ofStrike(); //10
        score.bowl(5); //+5
        score.bowl(3); //+3
        assertEquals(28, score.calculateNewTotal(10)); //+10 = 28
    }
}