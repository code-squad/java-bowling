package bowling.domain.frame.score;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    private Score score;

    @Test
    public void isReadyForDisplay_oneBowlAway_Spare() {
        score = Score.ofSpare();
        assertFalse(score.isReadyForDisplay());
    }

    @Test
    public void isReadyForDisplay_oneBowlAway_PlayedOnce() {
        score = Score.ofPlayedOnce(9);
        assertFalse(score.isReadyForDisplay());
    }

    @Test
    public void isReadyForDisplay_twoBowlsAway() {
        score = Score.ofStrike();
        assertFalse(score.isReadyForDisplay());
    }

    @Test
    public void isReadyForDisplay() {
        score = Score.ofStrike();
        score.bowl(8);
        score.bowl(1);
        assertTrue(score.isReadyForDisplay());
    }

    @Test
    public void calculateNewTotal() {
        score = Score.ofStrike(); //10
        score.bowl(5); //+5
        score.bowl(3); //+3
        assertEquals(28, score.calculateNewTotal(10)); //+10 = 28
    }
}