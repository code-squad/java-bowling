package domain.frame.result.score;

import domain.Pins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameScoreTest {
    private FrameScore score;

    @Before
    public void setUp() throws Exception {
        Pins pins = new Pins();
        pins.recordPins(5);
        pins.recordPins(5);
        score = new FrameScore(pins, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 점수추가에러() {
        score.addBonusPins(11);
    }

    @Test
    public void 점수추가() {
        score.addBonusPins(10);
        assertTrue(score.isSettingDone());
    }

    @Test
    public void 점수계산() {
        score.addBonusPins(10);
        assertEquals(20, score.getScore());
    }

    @Test
    public void 점수추가_시작안했을때() {
        assertFalse(score.isSettingDone());
    }

    @Test
    public void 점수추가_시작했을때() {
        score.addBonusPins(10);
        assertTrue(score.isStartedRecord());
    }
}