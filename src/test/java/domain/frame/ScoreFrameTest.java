package domain.frame;

import domain.score.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScoreFrameTest {

    private Score score;

    @Before
    public void setUp() throws Exception {
        score = new Score(new Score(10));
    }

    @Test
    public void nextFrame_9번째프레임() throws Exception {
        NormalFrame frame = new NormalFrame(score, 9);

        Frame next = frame.nextFrame(score);
        assertThat(next instanceof FinalFrame).isTrue();
    }

    @Test
    public void nextFrame() throws Exception {
        NormalFrame frame = new NormalFrame(score, 8);

        Frame next = frame.nextFrame(score);
        assertThat(next instanceof NormalFrame).isTrue();
    }
}