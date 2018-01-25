package domain.frame;

import domain.score.Pin;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NormalFrameTest {

    private NormalFrame spare;

    private NormalFrame strike;

    private NormalFrame miss;

    @Before
    public void setUp() throws Exception {
        spare = new NormalFrame(new Pin(8));
        spare.addResult(new Pin(2));

        strike = new NormalFrame(new Pin(10));

        miss = new NormalFrame(new Pin(7));
        miss.addResult(new Pin(2));
    }

    @Test
    public void calculateAdditionalScore_SPARE점수계산() throws Exception {
        assertThat(spare.calculateFrameScore().isPresent()).isFalse();

        assertThat(miss.calculateAdditionalScore(spare).isPresent()).isTrue();
        assertThat(miss.calculateAdditionalScore(spare).get()).isEqualTo(17);
    }

    @Test
    public void calculateAdditionalScore_STRIKE점수계산() throws Exception {
        assertThat(strike.calculateFrameScore().isPresent()).isFalse();

        assertThat(miss.calculateAdditionalScore(strike).isPresent()).isTrue();
        assertThat(miss.calculateAdditionalScore(strike).get()).isEqualTo(19);
    }

    @Test
    public void calculateAdditionalScore_STRIKE후SPARE() throws Exception {
        assertThat(strike.calculateFrameScore().isPresent()).isFalse();

        assertThat(spare.calculateAdditionalScore(strike).isPresent()).isTrue();
        assertThat(spare.calculateAdditionalScore(strike).get()).isEqualTo(20);
    }

    @Test
    public void calculateAdditionalScore_SPARE후STRIKE() throws Exception {
        assertThat(spare.calculateFrameScore().isPresent()).isFalse();

        assertThat(strike.calculateAdditionalScore(spare).isPresent()).isTrue();
        assertThat(strike.calculateAdditionalScore(spare).get()).isEqualTo(20);
    }

    @Test
    public void calculateAdditionalScore_2연속STRIKE() throws Exception {
        assertThat(strike.calculateFrameScore().isPresent()).isFalse();

        assertThat(strike.calculateAdditionalScore(strike).isPresent()).isFalse();
        assertThat(miss.calculateAdditionalScore(strike, strike).isPresent()).isTrue();
        assertThat(miss.calculateAdditionalScore(strike, strike).get()).isEqualTo(27);
    }

    @Test
    public void calculateAdditionalScore_3연속STRIKE() throws Exception {
        assertThat(strike.calculateFrameScore().isPresent()).isFalse();

        assertThat(strike.calculateAdditionalScore(strike, strike).isPresent()).isTrue();
        assertThat(strike.calculateAdditionalScore(strike, strike).get()).isEqualTo(30);
    }
}