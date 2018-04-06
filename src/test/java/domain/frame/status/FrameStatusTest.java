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
        status = FrameStatus.of(scores);
    }

    @Test
    public void 프레임_상태_진행중() {
        assertSame(FrameStatus.ING, status);
    }

    @Test
    public void 프레임_상태_스트라이크() {
        scores.addScore(10);
        status = FrameStatus.of(scores);
        assertSame(FrameStatus.STRIKE, status);
    }

    @Test
    public void 프레임_상태_스페어() {
        scores.addScore(3);
        scores.addScore(7);
        status = FrameStatus.of(scores);
        assertSame(FrameStatus.SPARE, status);
    }

    @Test
    public void 프레임_상태_미쓰() {
        scores.addScore(6);
        scores.addScore(2);
        status = FrameStatus.of(scores);
        assertSame(FrameStatus.MISS, status);
    }
}