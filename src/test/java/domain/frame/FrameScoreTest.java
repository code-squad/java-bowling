package domain.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameScoreTest {
    private FrameScore frameScore;

    @Before
    public void setUp() throws Exception {
        frameScore = new FrameScore(Frame.REGULAR_COUNT);
    }

    @Test
    public void 유효한점수_등록() {
        frameScore.roll(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지않은점수_등록() {
        frameScore.roll(11);
    }

    @Test
    public void 점수카운트소진시_점수겟하기() {
        frameScore.roll(5);
        frameScore.roll(5);
        frameScore.get();
    }

    @Test(expected = RuntimeException.class)
    public void 점수카운트미소진시_점수겟하기() {
        frameScore.roll(5);
        frameScore.get();
    }

    @Test
    public void 정규점수_스트라이크_문자열() {
        frameScore.roll(10);
        assertEquals("X", frameScore.getLatestSavedPinMessage());
    }

    @Test
    public void 정규점수_스패어_문자열() {
        frameScore.roll(5);
        frameScore.roll(5);
        assertEquals("/", frameScore.getLatestSavedPinMessage());
    }

    @Test
    public void 정규점수_미쓰_문자열() {
        frameScore.roll(1);
        frameScore.roll(7);
        assertEquals("7", frameScore.getLatestSavedPinMessage());
    }

    @Test
    public void 정규점수_미쓰_0점_문자열() {
        frameScore.roll(1);
        frameScore.roll(0);
        assertEquals("-", frameScore.getLatestSavedPinMessage());
    }

    @Test
    public void 정규점수_진행_문자열() {
        frameScore.roll(1);
        assertEquals("1", frameScore.getLatestSavedPinMessage());
    }

    @Test
    public void 보너스점수_진행_문자열() {
        frameScore.roll(3);
        frameScore.roll(7);
        frameScore.increaseLeftCount();
        frameScore.roll(10);
        assertEquals("X", frameScore.getLatestSavedPinMessage());
    }

    @Test
    public void 보너스점수_스트라이크_진행완료() {
        frameScore.roll(10);
        frameScore.increaseLeftCount();
        frameScore.roll(10);
        frameScore.roll(10);
        assertTrue(frameScore.isBonusFinish());
    }

    @Test(expected = RuntimeException.class)
    public void 보너스점수_스트라이크_진행미완료() {
        frameScore.roll(10);
        frameScore.increaseLeftCount();
        frameScore.roll(10);
        frameScore.get();
    }

    @Test
    public void 보너스점수_스패어_진행완료() {
        frameScore.roll(5);
        frameScore.roll(5);
        frameScore.increaseLeftCount();
        frameScore.roll(10);
        assertTrue(frameScore.isBonusFinish());
    }

    @Test(expected = RuntimeException.class)
    public void 보너스점수_스패어_진행미완료() {
        frameScore.roll(5);
        frameScore.roll(5);
        frameScore.increaseLeftCount();
        frameScore.get();
    }

    @Test
    public void 보너스점수_미쓰_진행완료() {
        frameScore.roll(3);
        frameScore.roll(5);
        frameScore.increaseLeftCount();
        assertTrue(frameScore.isBonusFinish());
    }
}