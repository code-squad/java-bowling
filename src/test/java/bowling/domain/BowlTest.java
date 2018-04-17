package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlTest {
    private Bowl bowl;

    @Before
    public void setUp() throws Exception {
        bowl = new Bowl();
    }

    @Test
    public void updateBowl() {
        assertEquals(new Integer(9), bowl.updateBowl(9));
    }

    @Test
    public void isPlayed_True() {
        bowl.updateBowl(9);
        assertTrue(bowl.isPlayed());
    }

    @Test
    public void isPlayed_False() {
        assertFalse(bowl.isPlayed());
    }
}