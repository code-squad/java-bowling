package domain.frame;

import domain.CustomPlayStrategy;
import domain.Referee;
import domain.score.FirstScore;
import domain.score.SecondScore;
import domain.score.TotalScore;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {

    private Referee referee;

    @Before
    public void setUp() throws Exception {
        referee = new Referee(new CustomPlayStrategy(new FirstScore(3),
                                                     new SecondScore(3, 7)));
    }

    @Test
    public void playNextFrame_스트라이크인경우() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new TotalScore(new FirstScore(10)), 10);

        Optional<Frame> nextFrame = finalFrame.playNextFrame(referee);
        assertThat(nextFrame.isPresent()).isTrue();
        assertThat(nextFrame.get().playNextFrame(referee).isPresent()).isTrue();
    }

    @Test
    public void playNextFrame_스페어인경우() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new TotalScore(7, 3), 10);

        Optional<Frame> nextFrame = finalFrame.playNextFrame(referee);
        assertThat(nextFrame.isPresent()).isTrue();
        assertThat(nextFrame.get().playNextFrame(referee).isPresent()).isFalse();
    }

    @Test
    public void playNextFrame_MISS인경우() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new TotalScore(5, 3), 10);

        Optional<Frame> nextFrame = finalFrame.playNextFrame(referee);
        assertThat(nextFrame.isPresent()).isFalse();
    }
}