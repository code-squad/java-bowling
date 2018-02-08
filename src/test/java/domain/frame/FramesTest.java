package domain.frame;

import domain.score.Pin;
import domain.score.Ready;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FramesTest {

    private Frames frames;

    private NormalFrame firstFrame;

    @Before
    public void setUp() throws Exception {
        frames = new Frames();

        firstFrame = new NormalFrame(Ready.bowl(new Pin(10)));
        frames.updateFrame(firstFrame);
    }

    @Test
    public void getUpdateScoreResult_스트라이크후첫번째시도() throws Exception {
        frames.updateFrame(firstFrame.bowl(new Pin(7)).get());
        assertThat(frames.sumOfScores()).isEqualTo("");
    }

    @Test
    public void getUpdateScoreResult_스트라이크후미스() throws Exception {
        Frame next = firstFrame.bowl(new Pin(2)).orElseThrow(IllegalStateException::new);
        next.bowl(new Pin(7));
        frames.updateFrame(next);

        assertThat(frames.sumOfScores()).isEqualTo("19  |28  ");
    }

    @Test
    public void getUpdateScoreResult_스트라이크후스페어() throws Exception {
        Frame next = firstFrame.bowl(new Pin(3)).orElseThrow(IllegalStateException::new);
        next.bowl(new Pin(7));
        frames.updateFrame(next);

        assertThat(frames.sumOfScores()).isEqualTo("20  ");
    }

    @Test
    public void getUpdateScoreResult_스트라이크후스페어후첫번째시도() throws Exception {
        Frame next = firstFrame.bowl(new Pin(3)).orElseThrow(IllegalStateException::new);
        next.bowl(new Pin(7));
        frames.updateFrame(next);

        Frame thenNext = next.bowl(new Pin(7)).orElseThrow(IllegalStateException::new);
        frames.updateFrame(thenNext);

        assertThat(frames.sumOfScores()).isEqualTo("20  |37  ");

    }
}