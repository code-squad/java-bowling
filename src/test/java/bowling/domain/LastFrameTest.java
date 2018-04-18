package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {
    private LastFrame frame;

    @Before
    public void setUp() throws Exception {
        frame = new LastFrame();
    }

    @Test
    public void bowl_First_Bowl() {
        frame.bowl(5);
        assertTrue(frame.firstIsPlayed());
        assertFalse(frame.secondIsPlayed());
        assertFalse(frame.bonusIsPlayed());
    }

    @Test
    public void bowl_Second_Bowl() {
        frame.bowl(5);
        frame.bowl(5);
        assertTrue(frame.firstIsPlayed());
        assertTrue(frame.secondIsPlayed());
        assertFalse(frame.bonusIsPlayed());
    }

    @Test
    public void bowl_Bonus_Bowl() {
        frame.bowl(5);
        frame.bowl(5);
        frame.bowl(9);
        assertTrue(frame.firstIsPlayed());
        assertTrue(frame.secondIsPlayed());
        assertTrue(frame.bonusIsPlayed());
    }

    @Test
    public void firstIsStrike_True() {
        frame.bowl(10);
        assertTrue(frame.firstIsStrike());
    }

    @Test
    public void firstIsStrike_False() {
        frame.bowl(9);
        assertFalse(frame.firstIsStrike());
    }

    @Test
    public void secondIsStrike_True() {
        frame.bowl(10);
        frame.bowl(10);
        assertTrue(frame.secondIsStrike());
    }

    @Test
    public void secondIsStrike_False() {
        frame.bowl(10);
        frame.bowl(9);
        assertFalse(frame.secondIsStrike());
    }

    @Test
    public void secondIsSpare_True() {
        frame.bowl(9);
        frame.bowl(1);
        assertTrue(frame.secondIsSpare());
    }

    @Test
    public void secondIsSpare_False() {
        frame.bowl(8);
        frame.bowl(1);
        assertFalse(frame.secondIsSpare());
    }

    @Test
    public void toStringTest() {
    }
}