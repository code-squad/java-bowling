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
        testFrame.roll(10);
        assertEquals(30, testFrame.getScore().getScore());
    }

    @Test
    public void 정규투구_스패어_점수합계() {
        testFrame.roll(5);
        testFrame.roll(5);
        testFrame.roll(10);
        assertEquals(20, testFrame.getScore().getScore());
    }

    @Test
    public void 정규투구_미쓰_점수합계() {
        testFrame.roll(3);
        testFrame.roll(5);
        assertEquals(8, testFrame.getScore().getScore());
    }

    @Test
    public void 정규투구_스트라이크_출력메세지() {
        testFrame.roll(10);
        testFrame.roll(5);
        testFrame.roll(10);
        assertEquals("X", testFrame.getRecordPinMessage());
    }

    @Test
    public void 정규투구_스패어_출력메세지() {
        testFrame.roll(5);
        testFrame.roll(5);
        testFrame.roll(0);
        assertEquals("-", testFrame.getRecordPinMessage());
    }

    @Test
    public void 정규투구_미쓰_출력메세지() {
        testFrame.roll(3);
        testFrame.roll(6);
        assertEquals("6", testFrame.getRecordPinMessage());
    }
}