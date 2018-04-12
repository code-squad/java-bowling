package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameTest {
    BowlingGame bowlingGame = null;
    Frame frame = null;
    @Before
    public void setup() {
        bowlingGame = new BowlingGame("HTW");
        frame = new NormalFrame();
    }

    @Test
    public void isFirstThrowing() {
        assertTrue(frame.isFirst());
    }

    @Test
    public void isSecondThrowing() {
        assertFalse(frame.isSecond());
    }

    @Test
    public void getThrowing() {
        List<Frame> frames = bowlingGame.createFrame();
        frame = frames.get(0);
        assertEquals(4, frame.getThrowing(6));
    }

    @Test(expected = RuntimeException.class)
    public void getThrowingFail() {
        frame.getThrowing(11);
    }

    @Test
    public void isEnd() {
        frame.getThrowing(10); //strike
        assertTrue(frame.isEnd());
    }
}
