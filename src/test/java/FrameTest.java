import model.BowlingScore;
import model.Frame;
import model.NormalFrame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() {
        frame = new NormalFrame();
    }

    @Test
    public void obtainScore() {
        assertThat(frame.obtainScore(3)).isInstanceOf(BowlingScore.class);
    }

    @Test
    public void isItOverAndHasNextFrame() {
        frame.obtainScore(2);
        Frame result = new NormalFrame();
        result.obtainScore(1);
        result.obtainScore(1);

//        assertThat(frame.isItOverAndHasNextFrame(result)).isFalse();
    }

    @Test
    public void isDone() {
        assertThat(frame.isDone()).isFalse();
    }
}
