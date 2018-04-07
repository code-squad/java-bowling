package domain.frame;

import domain.frame.result.FrameResult;
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
    public void 보너스투구() {
        lastFrame.addScore(10);
        lastFrame.addScore(10);
        assertTrue(lastFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스10점_결과() {
        lastFrame.addScore(10);
        FrameResult result = lastFrame.addScore(10);
        assertEquals("X|X", result);
    }

    @Test
    public void 스패어_보너스10점_결과() {
        lastFrame.addScore(5);
        FrameResult result = lastFrame.addScore(5);
        assertEquals("5|/|X", result);
    }

    @Test
    public void 진행중_결과() {
        FrameResult result = lastFrame.addScore(5);
        assertEquals("5", result);
    }
}