package domain.frame;

import org.junit.Before;
import org.junit.Test;

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
}