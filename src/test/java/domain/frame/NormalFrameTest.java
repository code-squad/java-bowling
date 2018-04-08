package domain.frame;

import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private Frame testFrame;

    @Before
    public void setUp() throws Exception {
        testFrame = FrameFactory.of(1);
    }

    @Test
    public void 프레임_점수_추가() {
        testFrame.addScore(5);
        testFrame.addScore(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 프레임_점수_오버추가() {
        testFrame.addScore(10);
        testFrame.addScore(2);
    }

    @Test
    public void 프레임_종료_체크() {
        assertFalse(testFrame.isFinish());
    }

    @Test
    public void 스트라이크_결과() {
        assertEquals("X", testFrame.addScore(10));
    }

    @Test
    public void 스패어_결과() {
        testFrame.addScore(3);
        assertEquals("/", testFrame.addScore(7));
    }

    @Test
    public void 미쓰_결과() {
        testFrame.addScore(1);
        assertEquals("5", testFrame.addScore(5));
    }

    @Test
    public void 미쓰_0점_포함_결과() {
        testFrame.addScore(5);
        assertEquals("-", testFrame.addScore(0));
    }

    @Test
    public void 진행중_결과() {
        assertEquals("5", testFrame.addScore(5));
    }
}