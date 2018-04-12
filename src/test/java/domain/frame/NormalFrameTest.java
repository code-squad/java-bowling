package domain.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private Frame testFrame;

    @Before
    public void setUp() throws Exception {
        testFrame = Frame.of(1);
    }

    @Test
    public void 스트라이크_상태변화() {
        testFrame.roll(10);
        assertTrue(testFrame.isFinish());
    }

    @Test
    public void 스패어_상태변화() {
        testFrame.roll(5);
        testFrame.roll(5);
        assertTrue(testFrame.isFinish());
    }

    @Test
    public void 미쓰_상태변화() {
        testFrame.roll(3);
        assertFalse(testFrame.isFinish());
    }

    @Test
    public void 진행중_변화() {
        assertFalse(testFrame.isFinish());
    }
}