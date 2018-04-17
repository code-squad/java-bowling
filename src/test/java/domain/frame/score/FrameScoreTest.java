package domain.frame.score;

import domain.frame.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrameScoreTest {
    private Frame testFrame;
    private FrameScore frameScore;

    @Before
    public void setUp() throws Exception {
        testFrame = Frame.of(1);
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
    public void 정규점수_스패어_문자열() {
        frameScore.roll(5);
        frameScore.roll(5);
        assertEquals("5|/", frameScore.makeScoreMessage(testFrame));
    }

    @Test
    public void 정규점수_미쓰_문자열() {
        frameScore.roll(1);
        frameScore.roll(7);
        assertEquals("1|7", frameScore.makeScoreMessage(testFrame));
    }

    @Test
    public void 정규점수_미쓰_0점_문자열() {
        frameScore.roll(1);
        frameScore.roll(0);
        assertEquals("1|-", frameScore.makeScoreMessage(testFrame));
    }

    @Test
    public void 정규점수_진행_문자열() {
        frameScore.roll(1);
        assertEquals("1", frameScore.makeScoreMessage(testFrame));
    }

    @Test
    public void 보너스점수_진행_문자열() {
        frameScore.roll(3);
        frameScore.roll(7);
        frameScore.increaseLeftCount();
        assertEquals("3|/", frameScore.makeScoreMessage(testFrame));
    }

    @Test
    public void 보너스점수_스트라이크_진행완료() {
        frameScore.roll(10);
        frameScore.increaseLeftCount();
        frameScore.roll(10);
        frameScore.roll(10);
        assertTrue(frameScore.isBonusFinish());
    }

    @Test
    public void 보너스점수_스패어_진행완료() {
        frameScore.roll(5);
        frameScore.roll(5);
        frameScore.increaseLeftCount();
        frameScore.roll(10);
        assertTrue(frameScore.isBonusFinish());
    }

    @Test
    public void 보너스점수_미쓰_진행완료() {
        frameScore.roll(3);
        frameScore.roll(5);
        frameScore.increaseLeftCount();
        assertTrue(frameScore.isBonusFinish());
    }
}