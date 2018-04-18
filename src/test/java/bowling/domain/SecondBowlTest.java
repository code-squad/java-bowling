package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondBowlTest {
    private SecondBowl second;

    @Before
    public void setUp() throws Exception {
        second = new SecondBowl();
    }

    @Test
    public void bowl() {
        assertEquals(new Integer(5), second.bowl(6, 5));
    }

    @Test
    public void isPlayed_False() {
        assertFalse(second.isPlayed());
    }

    @Test
    public void isPlayed_True() {
        second.bowl(8, 5);
        assertTrue(second.isPlayed());
    }

    @Test
    public void isSpare_False() {
        second.bowl(4, 3);
        assertFalse(second.isSpare());
    }

    @Test
    public void isSpare_True() {
        second.bowl(4, 4);
        assertTrue(second.isSpare());
    }

    @Test
    public void calculatePinsLeft() {
        second.bowl(5, 4);
        assertEquals(1, second.calculatePinsLeft());
    }
}