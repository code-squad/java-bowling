package domain.frame.status;

import domain.Scores;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameStatusTest {
    private FrameStatus status;
    private Scores scores;

    @Before
    public void setUp() throws Exception {
        scores = new Scores();
        status = FrameStatus.getInitStatus();
    }

    @Test
    public void 프레임_상태_진행중() {
        assertFalse(status.isFinish());
    }

    @Test
    public void 프레임_상태_스트라이크() {
        scores.addScore(10);
        status = status.changeStatus(scores);
        assertTrue(status.isFinish() && status.isBonus());
    }

    @Test
    public void 프레임_상태_스페어() {
        scores.addScore(3);
        scores.addScore(7);
        status = status.changeStatus(scores);
        assertTrue(status.isFinish() && status.isBonus());
    }

    @Test
    public void 프레임_상태_미쓰() {
        scores.addScore(6);
        scores.addScore(2);
        status = status.changeStatus(scores);
        assertTrue(status.isFinish() && !status.isBonus());
    }

    @Test
    public void 스트라이크_보너스카운트() {
        scores.addScore(10);
        status = status.changeStatus(scores);
        assertEquals(2, status.getBonusCount());
    }

    @Test
    public void 스페어_보너스카운트() {
        scores.addScore(3);
        scores.addScore(7);
        status = status.changeStatus(scores);
        assertEquals(1, status.getBonusCount());
    }

    @Test
    public void 미쓰_보너스카운트() {
        scores.addScore(6);
        scores.addScore(2);
        status = status.changeStatus(scores);
        assertEquals(0, status.getBonusCount());
    }
}