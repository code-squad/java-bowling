package bowling.domain.score;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoresTest {
    private Scores scores;

    @Before
    public void setUp() throws Exception {
        scores = new Scores();
    }

    @Test
    public void firstThrowIsPlayed() {
        scores.updateFirstThrow(8);
        assertTrue(scores.firstThrowIsPlayed());
    }

    @Test
    public void isStrike() {
        scores.updateFirstThrow(10);
        assertTrue(scores.isStrike());
    }

    @Test
    public void secondThrowIsPlayed() {
        scores.updateFirstThrow(8);
        scores.updateSecondThrow(2);
        assertTrue(scores.secondThrowIsPlayed());
    }

    @Test
    public void isSpare() {
        scores.updateFirstThrow(8);
        scores.updateSecondThrow(2);
        assertTrue(scores.isSpare());
    }

    @Test
    public void isValidScore_Over_Max() {
        assertFalse(scores.isValidScore(11));
    }

    @Test
    public void isValidScore_Under_Max() {
        assertFalse(scores.isValidScore(-1));
    }

    @Test
    public void isValidScore_More_Than_Pins_Standing() {
        scores.updateFirstThrow(6);
        assertFalse(scores.isValidScore(5));
    }
}