package domain.frame;

import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private Frame currentFrame;
    private Frame nextFrame;

    @Before
    public void setUp() throws Exception {
        currentFrame = FrameFactory.of(1);
    }

    @Test
    public void 프레임_점수_추가() {
        currentFrame.addScore(5);
        currentFrame.addScore(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 프레임_점수_오버추가() {
        currentFrame.addScore(10);
        currentFrame.addScore(2);
    }

    @Test
    public void 프레임_종료_체크() {
        assertFalse(currentFrame.isFinish());
    }

    @Test
    public void 스트라이크_결과() {
        assertEquals("X", currentFrame.addScore(10));
    }

    @Test
    public void 스패어_결과() {
        currentFrame.addScore(3);
        assertEquals("/", currentFrame.addScore(7));
    }

    @Test
    public void 미쓰_결과() {
        currentFrame.addScore(1);
        assertEquals("5", currentFrame.addScore(5));
    }

    @Test
    public void 미쓰_0점_포함_결과() {
        currentFrame.addScore(5);
        assertEquals("-", currentFrame.addScore(0));
    }

    @Test
    public void 진행중_결과() {
        assertEquals("5", currentFrame.addScore(5));
    }

    @Test
    public void 보너스상황() {
        currentFrame.addScore(10);
        assertFalse(currentFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스투구_미완료() {
        currentFrame.addScore(10);
        assertFalse(currentFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스투구_완료() {
        currentFrame.addScore(10);

        /* 보너스 어떻게 이끌어나갈지 - add 할 때 이전 프레임에 보너스 상황인지 묻고 점수를 던져줄 것인가? */
        assertTrue(currentFrame.isFinish());
    }

    @Test
    public void 스패어_보너스투구_미완료() {
        currentFrame.addScore(5);
        assertFalse(currentFrame.isFinish());
    }

    @Test
    public void 스패어_보너스투구_완료() {
        currentFrame.addScore(5);
        currentFrame.addScore(5);

        /* 보너스 어떻게 이끌어나갈지 - add 할 때 이전 프레임에 보너스 상황인지 묻고 점수를 던져줄 것인가? */
        assertTrue(currentFrame.isFinish());
    }
}