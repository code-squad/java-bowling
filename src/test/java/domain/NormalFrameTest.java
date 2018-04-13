package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NormalFrameTest {
    NormalFrame normalFrame;

    @Before
    public void setup() {
        normalFrame = new NormalFrame("htw");
    }

    @Test
    public void firstThrowing() {
        assertTrue(normalFrame.isFirst());
    }

    @Test
    public void secondThrowing() {
        normalFrame.throwing(1);
        assertTrue(normalFrame.isSecond());
    }

    @Test
    public void firstThrowingPins() {
        assertEquals(6, normalFrame.throwing(4));
    }

    @Test
    public void secondThrowingPins() {
        normalFrame.throwing(4); // 남은 핀 6개
        assertEquals(1, normalFrame.throwing(5));
    }

    @Test
    public void setStrikeStatus() {
        normalFrame = new NormalFrame(10,0);
        assertEquals(Status.STRIKE, normalFrame.createStatus());
    }

    @Test
    public void isStatus() {
        normalFrame.throwing(7);
        normalFrame.throwing(3);
        assertTrue(normalFrame.isStatus(Status.SPARE));
    }
}
