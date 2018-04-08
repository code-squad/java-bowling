package domain.frame.status;

import domain.Scores;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameStatusTest {
    private FrameStatus status;
    private Scores scores;

    @Before
    public void setUp() throws Exception {
        scores = new Scores();
        status = FrameStatus.changeStatus(scores);
    }

    @Test
    public void 프레임_상태_진행중() {
        assertTrue(FrameStatus.isIng(status));
    }

    @Test
    public void 프레임_상태_스트라이크() {
        scores.addScore(10);
        status = FrameStatus.changeStatus(scores);
        assertTrue(FrameStatus.isStrike(status));
    }

    @Test
    public void 프레임_상태_스페어() {
        scores.addScore(3);
        scores.addScore(7);
        status = FrameStatus.changeStatus(scores);
        assertTrue(FrameStatus.isSpare(status));
    }

    @Test
    public void 프레임_상태_미쓰() {
        scores.addScore(6);
        scores.addScore(2);
        status = FrameStatus.changeStatus(scores);
        assertTrue(FrameStatus.isMiss(status));
    }
}