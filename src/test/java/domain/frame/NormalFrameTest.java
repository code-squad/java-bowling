package domain.frame;

import domain.frame.result.FrameResult;
import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static org.junit.Assert.*;

public class NormalFrameTest {

    private Frame testFrame;

    @Before
    public void setUp() throws Exception {
        testFrame = FrameFactory.of(1);
        testFrame.addScore(5);
        testFrame.addScore(4);
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
        assertTrue(testFrame.isFinish());
    }

    @Test
    public void 스트라이크_결과() {
        FrameResult result = testFrame.addScore(10);
        assertEquals("X", result);
    }

    @Test
    public void 스패어_결과() {
        testFrame.addScore(5);
        testFrame.addScore(5);
        assertEquals("5|/", testFrame);
    }

    @Test
    public void 미쓰_결과() {
        testFrame.addScore(5);
        testFrame.addScore(3);
        assertEquals("5|3", testFrame);
    }

    @Test
    public void 미쓰_0점_포함_결과() {
        testFrame.addScore(5);
        testFrame.addScore(0);
        assertEquals("5|-", testFrame);
    }

    @Test
    public void 진행중_결과() {
        testFrame.addScore(3);
        assertEquals("3", testFrame);
    }
}