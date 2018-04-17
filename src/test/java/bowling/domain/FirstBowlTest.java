package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstBowlTest {
    private FirstBowl firstBowl;

    @Before
    public void setUp() throws Exception {
        firstBowl = new FirstBowl();
    }

    @Test
    public void updateBowl() {
        assertEquals(new Integer(9), firstBowl.updateBowl(9));
    }

    @Test
    public void isPlayed_True() {
        firstBowl.updateBowl(9);
        assertTrue(firstBowl.firstIsPlayed());
    }

    @Test
    public void isPlayed_False() {
        assertFalse(firstBowl.firstIsPlayed());
    }
}