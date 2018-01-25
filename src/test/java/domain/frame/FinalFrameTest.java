package domain.frame;

import domain.score.Pin;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FinalFrameTest {

    private NormalFrame spare;

    private NormalFrame strike;

    private FinalFrame finalFrame;

    @Before
    public void setUp() throws Exception {
        spare = new NormalFrame(new Pin(8));
        spare.addResult(new Pin(2));
        strike = new NormalFrame(new Pin(10));

        finalFrame = new FinalFrame(new Pin(3));
        finalFrame.addResult(new Pin(7));
        finalFrame.addResult(new Pin(8));
    }

    @Test
    public void calculateAdditionalScore_이전이STRIKE() throws Exception {
        assertThat(finalFrame.calculateAdditionalScore(strike).isPresent()).isTrue();
        assertThat(finalFrame.calculateAdditionalScore(strike).get()).isEqualTo(20);
    }

    @Test
    public void calculateAdditionalScore_이전이STRIKE_FinalFrame이첫번째시도만한경우() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new Pin(7));
        assertThat(finalFrame.calculateAdditionalScore(strike).isPresent()).isFalse();
    }

    @Test
    public void calculateAdditionalScore_이전이SPARE() throws Exception {
        assertThat(finalFrame.calculateAdditionalScore(spare).isPresent()).isTrue();
        assertThat(finalFrame.calculateAdditionalScore(spare).get()).isEqualTo(13);
    }

    @Test
    public void calculateAdditionalScore_이전이SPARE_FinalFrame이첫번째시도만한경우() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new Pin(3));

        assertThat(finalFrame.calculateAdditionalScore(spare).isPresent()).isTrue();
        assertThat(finalFrame.calculateAdditionalScore(spare).get()).isEqualTo(13);
    }

    @Test
    public void calculateAdditionalScore_STRIKESTRIKE() throws Exception {
        assertThat(finalFrame.calculateAdditionalScore(strike, strike).isPresent()).isTrue();
        assertThat(finalFrame.calculateAdditionalScore(strike, strike).get()).isEqualTo(23);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAdditionalScore_STRIKESPARE() throws Exception {
        finalFrame.calculateAdditionalScore(strike, spare);
    }
}