package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BonusThrowTest {
    private BonusThrow bonusThrow;

    @Before
    public void setUp() throws Exception {
        bonusThrow = new BonusThrow();
    }

    @Test
    public void updateScore() {
        assertEquals(8, bonusThrow.updateScore(8));
    }

    @Test
    public void toStringTest_Empty() {
        assertEquals("| ", bonusThrow.toString());
    }

    @Test
    public void toStringTest_Number() {
        bonusThrow.updateScore(8);
        assertEquals("|8", bonusThrow.toString());
    }

    @Test
    public void toStringTest_Strike() {
        bonusThrow.updateScore(10);
        assertEquals("|X", bonusThrow.toString());
    }
}