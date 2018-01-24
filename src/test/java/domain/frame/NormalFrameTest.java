package domain.frame;

import domain.score.Score;
import domain.score.TotalScore;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NormalFrameTest {

    private TotalScore totalScore;

    @Before
    public void setUp() throws Exception {
        totalScore = new TotalScore(new Score(10));
    }

    @Test
    public void nextFrame_9번째프레임() throws Exception {
        NormalFrame frame = new NormalFrame(totalScore, 9);

        Frame next = frame.nextFrame(totalScore);
        assertThat(next instanceof FinalFrame).isTrue();
    }

    @Test
    public void nextFrame() throws Exception {
        NormalFrame frame = new NormalFrame(totalScore, 8);

        Frame next = frame.nextFrame(totalScore);
        assertThat(next instanceof NormalFrame).isTrue();
    }
}