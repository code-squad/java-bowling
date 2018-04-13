package bowling.domain;

import bowling.domain.score.BonusScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BonusScoreTest {
    private BonusScore bonusScore;

    @Before
    public void setUp() throws Exception {
        bonusScore = new BonusScore();
    }

    @Test
    public void updateScore() {
        assertEquals(8, bonusScore.updateScore(8));
    }

    @Test
    public void toStringTest_Not_Played() {
        assertEquals("  ", bonusScore.toString());
    }

    @Test
    public void toStringTest_Number() {
        bonusScore.updateScore(8);
        assertEquals("|8", bonusScore.toString());
    }

    @Test
    public void toStringTest_Strike() {
        bonusScore.updateScore(10);
        assertEquals("|X", bonusScore.toString());
    }

    @Test
    public void toStringTest_Zero() {
        bonusScore.updateScore(0);
        assertEquals("|-", bonusScore.toString());
    }
}