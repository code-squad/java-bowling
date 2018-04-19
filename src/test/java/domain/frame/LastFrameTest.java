package domain.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {
    private Frame testFrame;

    @Before
    public void setUp() throws Exception {
        testFrame = Frame.of(10);
    }

    @Test
    public void 스트라이크_상태변화() {
        testFrame.roll(10);
        assertFalse(testFrame.isFinish());
    }

    @Test
    public void 스패어_상태변화() {
        testFrame.roll(5);
        testFrame.roll(5);
        assertFalse(testFrame.isFinish());
    }

    @Test
    public void 미쓰_상태변화() {
        testFrame.roll(3);
        assertFalse(testFrame.isFinish());
    }

    @Test
    public void 스트라이크_투구_미완료_점수합계() {
        testFrame.roll(10);
        testFrame.roll(5);
        assertEquals(Frame.CANNOT_CALC_SCORE_STATE, testFrame.getResult().getScore());
    }

    @Test
    public void 스패어_투구_미완료_점수합계() {
        testFrame.roll(5);
        testFrame.roll(5);
        assertEquals(Frame.CANNOT_CALC_SCORE_STATE, testFrame.getResult().getScore());
    }

    @Test
    public void 진행중_투구_점수합계() {
        testFrame.roll(9);
        assertEquals(Frame.CANNOT_CALC_SCORE_STATE, testFrame.getResult().getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 투구_스트라이크시_보너스_오류() {
        testFrame.roll(10);
        testFrame.roll(3);
        testFrame.roll(10);
    }

    @Test
    public void 투구_스트라이크_보너스_출력메세지() {
        testFrame.roll(10);
        testFrame.roll(5);
        testFrame.roll(5);
        assertEquals("X|5|/", testFrame.getResult().getMessage());
    }

    @Test
    public void 투구_스패어_보너스_출력메세지() {
        testFrame.roll(5);
        testFrame.roll(5);
        testFrame.roll(0);
        assertEquals("5|/|-", testFrame.getResult().getMessage());
    }

    @Test
    public void 투구_미쓰_출력메세지() {
        testFrame.roll(3);
        testFrame.roll(6);
        assertEquals("3|6", testFrame.getResult().getMessage());
    }

    @Test
    public void 투구_진행중_출력메세지() {
        testFrame.roll(3);
        assertEquals("3", testFrame.getResult().getMessage());
    }

    @Test
    public void 다른프레임_미전환() {
        assertSame(testFrame, testFrame.roll(10));
    }

    @Test
    public void 다른프레임_미전환2() {
        testFrame.roll(3);
        assertSame(testFrame, testFrame.roll(7));
    }

    @Test
    public void 다른프레임_미전환3() {
        assertSame(testFrame, testFrame.roll(7));
    }
}