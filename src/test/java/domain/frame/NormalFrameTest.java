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

    @Test
    public void 정규투구_스트라이크_점수합계() {
        testFrame.roll(10);
        testFrame.roll(10);
        testFrame.refreshPinNum(testFrame);
        testFrame.roll(10);
        testFrame.refreshPinNum(testFrame);
        assertEquals(30, testFrame.getResult(0).getScore());
    }

    @Test
    public void 정규투구_스패어_점수합계() {
        testFrame.roll(5);
        testFrame.roll(5);
        testFrame.roll(10);
        testFrame.refreshPinNum(testFrame);
        assertEquals(20, testFrame.getResult(0).getScore());
    }

    @Test
    public void 정규투구_미쓰_점수합계() {
        testFrame.roll(9);
        testFrame.roll(0);
        assertEquals(9, testFrame.getResult(0).getScore());
    }

    @Test
    public void 스트라이크_투구_미완료_점수합계() {
        testFrame.roll(10);
        testFrame.roll(5);
        assertEquals(Frame.CANNOT_CALC_SCORE_STATE, testFrame.getResult(0).getScore());
    }

    @Test
    public void 스패어_투구_미완료_점수합계() {
        testFrame.roll(5);
        testFrame.roll(5);
        assertEquals(Frame.CANNOT_CALC_SCORE_STATE, testFrame.getResult(0).getScore());
    }

    @Test
    public void 진행중_투구_점수합계() {
        testFrame.roll(9);
        assertEquals(Frame.CANNOT_CALC_SCORE_STATE, testFrame.getResult(0).getScore());
    }

    @Test
    public void 투구_스트라이크_출력메세지() {
        testFrame.roll(10);
        testFrame.roll(5);
        testFrame.refreshPinNum(testFrame);
        testFrame.roll(10);
        testFrame.refreshPinNum(testFrame);
        assertEquals("X", testFrame.getResult(0).getMessage());
    }

    @Test
    public void 투구_스패어_출력메세지() {
        testFrame.roll(5);
        testFrame.roll(5);
        testFrame.roll(0);
        testFrame.refreshPinNum(testFrame);
        assertEquals("5|/", testFrame.getResult(0).getMessage());
    }

    @Test
    public void 투구_미쓰_출력메세지() {
        testFrame.roll(3);
        testFrame.roll(6);
        assertEquals("3|6", testFrame.getResult(0).getMessage());
    }

    @Test
    public void 투구_진행중_출력메세지() {
        testFrame.roll(3);
        assertEquals("3", testFrame.getResult(0).getMessage());
    }

    @Test
    public void 정규투구_스트라이크_다른프레임전환() {
        assertNotSame(testFrame, testFrame.roll(10));
    }

    @Test
    public void 정규투구_스패어_다른프레임전환() {
        testFrame.roll(3);
        assertNotSame(testFrame, testFrame.roll(7));
    }

    @Test
    public void 정규투구_미쓰_다른프레임전환() {
        testFrame.roll(2);
        assertNotSame(testFrame, testFrame.roll(6));
    }
}