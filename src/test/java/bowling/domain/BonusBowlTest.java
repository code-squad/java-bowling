package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BonusBowlTest {
    private BonusBowl bonus;

    @Before
    public void setUp() throws Exception {
        bonus = new BonusBowl();
    }

    @Test
    public void bowl() {
        assertEquals(new Integer(8), bonus.bowl(8));
    }

    @Test
    public void isPlayed_False() {
        assertFalse(bonus.isPlayed());
    }

    @Test
    public void isPlayed_True() {
        bonus.bowl(0);
        assertTrue(bonus.isPlayed());
    }
}