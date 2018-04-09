package domain.frame;

import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static org.junit.Assert.*;

public class LastFrameTest {
    private Frame lastFrame;

    @Before
    public void setUp() throws Exception {
        lastFrame = FrameFactory.of(Frames.LIMIT_NUM);
    }

    @Test
    public void 보너스상황() {
        lastFrame.addScore(10);
        assertFalse(lastFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스투구_미완료() {
        lastFrame.addScore(10);
        lastFrame.addScore(10);
        assertFalse(lastFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스투구_완료() {
        lastFrame.addScore(10);
        lastFrame.addScore(10);
        lastFrame.addScore(5);
        assertTrue(lastFrame.isFinish());
    }

    @Test
    public void 스패어_보너스투구_미완료() {
        lastFrame.addScore(5);
        lastFrame.addScore(5);
        assertFalse(lastFrame.isFinish());
    }

    @Test
    public void 스패어_보너스투구_완료() {
        lastFrame.addScore(5);
        lastFrame.addScore(5);
        lastFrame.addScore(0);
        assertTrue(lastFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스10점_결과() {
        lastFrame.addScore(10);
        lastFrame.addScore(0);
        assertEquals("X", lastFrame.addScore(10));
    }

    @Test
    public void 스트라이크_보너스0점_결과() {
        lastFrame.addScore(10);
        lastFrame.addScore(5);
        assertEquals("-", lastFrame.addScore(0));
    }

    @Test
    public void 스패어_보너스10점_결과() {
        lastFrame.addScore(5);
        lastFrame.addScore(5);
        assertEquals("X", lastFrame.addScore(10));
    }

    @Test
    public void 스패어_보너스0점_결과() {
        lastFrame.addScore(5);
        lastFrame.addScore(5);
        assertEquals("-", lastFrame.addScore(0));
    }
}