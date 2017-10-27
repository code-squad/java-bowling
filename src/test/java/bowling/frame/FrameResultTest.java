package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameResultTest {
    @Test
    public void addTotalScore() throws Exception {
        FrameResult result = new FrameResult("8 | 1", 9);
        assertEquals(19, result.addTotalScore(10));
    }

    @Test
    public void addTotalScoreWhenUnScore() throws Exception {
        FrameResult result = new FrameResult("8 | ", Frame.UN_SCORE_STATE);
        assertEquals(Frame.UN_SCORE_STATE, result.addTotalScore(10));
    }

    @Test
    public void getFrameResultWhenMiss() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(8).bowl(1);
        FrameResult result = frame.getFrameResult();
        assertEquals(new FrameResult("8 | 1", 9), result);
    }

    @Test
    public void getFrameResultWhenNotReady() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(8);
        FrameResult result = frame.getFrameResult();
        assertEquals(new FrameResult("8 | ", Frame.UN_SCORE_STATE), result);
    }

    @Test
    public void getFrameResultWhenSpare() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(8).bowl(2).bowl(9);
        FrameResult result = frame.getFrameResult();
        assertEquals(new FrameResult("8 | /", 19), result);
    }

    @Test
    public void getFrameResultWhenNotSpareNotReady() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(8).bowl(2);
        FrameResult result = frame.getFrameResult();
        assertEquals(new FrameResult("8 | /", Frame.UN_SCORE_STATE), result);
    }

    @Test
    public void getFrameResultWhenStrike() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(10).bowl(10).bowl(8);
        FrameResult result = frame.getFrameResult();
        assertEquals(new FrameResult("X", 28), result);
    }

    @Test
    public void getFrameResultWhenNotStrikeNotReady() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(10).bowl(10);
        FrameResult result = frame.getFrameResult();
        assertEquals(new FrameResult("X", Frame.UN_SCORE_STATE), result);
    }
}
