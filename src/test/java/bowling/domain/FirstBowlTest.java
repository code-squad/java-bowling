package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstBowlTest {
    private FirstBowl first;

    @Before
    public void setUp() throws Exception {
        first = new FirstBowl();
    }

    @Test
    public void bowl() {
        assertEquals(new Integer(8), first.bowl(8));
    }

    @Test
    public void isPlayed_False() {
        assertFalse(first.isPlayed());
    }

    @Test
    public void isPlayed_True() {
        first.bowl(5);
        assertTrue(first.isPlayed());
    }

    @Test
    public void isStrike_False() {
        first.bowl(9);
        assertFalse(first.isStrike());
    }

    @Test
    public void isStrike_True() {
        first.bowl(10);
        assertTrue(first.isStrike());
    }

    @Test
    public void calculatePinsLeft() {
        first.bowl(8);
        assertEquals(2, first.calculatePinsLeft());
    }
}