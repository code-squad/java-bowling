package domain.frame;

import domain.score.Pin;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    private NormalFrame spare;

    private NormalFrame strike;

    private NormalFrame miss;

    @Before
    public void setUp() throws Exception {
        spare = new NormalFrame(new Pin(8));
        spare.bowl(new Pin(2));

        strike = new NormalFrame(new Pin(10));

        miss = new NormalFrame(new Pin(7));
        miss.bowl(new Pin(2));
    }
    
    @Test
    public void NormalScore_거터() throws Exception {
        NormalFrame zero = new NormalFrame(Pin.ZERO);

        assertThat(zero.toString()).isEqualTo("-");
    }

    @Test
    public void NormalScore_끝나지않은Frame() throws Exception {
        NormalFrame score = new NormalFrame(new Pin(7));

        assertThat(score.toString()).isEqualTo("7");
        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.getSumOfFirstAndSecondScore().isPresent()).isFalse();
    }

    @Test
    public void NormalScore_스트라이크() throws Exception {
        NormalFrame strike = new NormalFrame(Pin.TEN);

        assertThat(strike.isStrike()).isTrue();
        assertThat(strike.getFrameScore().isPresent()).isFalse();
        assertThat(strike.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(strike.getSumOfFirstAndSecondScore().get()).isEqualTo(10);
    }

    @Test
    public void NormalScore_스페어() throws Exception {
        NormalFrame spare = new NormalFrame(new Pin(7));
        spare.bowl(new Pin(3));

        assertThat(spare.toString()).isEqualTo("7|/");
        assertThat(spare.isFinish()).isTrue();
        assertThat(spare.getFrameScore().isPresent()).isFalse();
        assertThat(spare.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(spare.getSumOfFirstAndSecondScore().get()).isEqualTo(10);
    }

    @Test
    public void NormalScore_미스() throws Exception {
        NormalFrame spare = new NormalFrame(new Pin(7));
        spare.bowl(new Pin(2));

        assertThat(spare.toString()).isEqualTo("7|2");
        assertThat(spare.isFinish()).isTrue();
        assertThat(spare.getFrameScore().isPresent()).isTrue();
        assertThat(spare.getFrameScore().get()).isEqualTo(9);
        assertThat(spare.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(spare.getSumOfFirstAndSecondScore().get()).isEqualTo(9);
    }

    @Test
    public void toString_스페어() throws Exception {
        NormalFrame normalScore = new NormalFrame(new Pin(0));
        normalScore.bowl(Pin.TEN);
        assertThat(normalScore.isStrike()).isFalse();
        assertThat(normalScore.toString()).isEqualTo("-|/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void NormalScore_74() throws Exception {
        NormalFrame normalScore = new NormalFrame(new Pin(7));
        normalScore.bowl(new Pin(4));

    }

    @Test
    public void calculateScoreWithBefore_SPARE점수계산() throws Exception {
        assertThat(spare.getFrameScore().isPresent()).isFalse();

        assertThat(miss.calculateScoreWithBefore(spare).isPresent()).isTrue();
        assertThat(miss.calculateScoreWithBefore(spare).get()).isEqualTo(17);
    }

    @Test
    public void calculateScoreWithBefore_STRIKE점수계산() throws Exception {
        assertThat(strike.getFrameScore().isPresent()).isFalse();

        assertThat(miss.calculateScoreWithBefore(strike).isPresent()).isTrue();
        assertThat(miss.calculateScoreWithBefore(strike).get()).isEqualTo(19);
    }

    @Test
    public void calculateScoreWithBefore_STRIKE후SPARE() throws Exception {
        assertThat(strike.getFrameScore().isPresent()).isFalse();

        assertThat(spare.calculateScoreWithBefore(strike).isPresent()).isTrue();
        assertThat(spare.calculateScoreWithBefore(strike).get()).isEqualTo(20);
    }

    @Test
    public void calculateScoreWithBefore_SPARE후STRIKE() throws Exception {
        assertThat(spare.getFrameScore().isPresent()).isFalse();

        assertThat(strike.calculateScoreWithBefore(spare).isPresent()).isTrue();
        assertThat(strike.calculateScoreWithBefore(spare).get()).isEqualTo(20);
    }

    @Test
    public void calculateScoreWithBefore_2연속STRIKE() throws Exception {
        assertThat(strike.getFrameScore().isPresent()).isFalse();

        assertThat(strike.calculateScoreWithBefore(strike).isPresent()).isFalse();
        assertThat(miss.calculateScoreWithBefore(strike, strike).isPresent()).isTrue();
        assertThat(miss.calculateScoreWithBefore(strike, strike).get()).isEqualTo(27);
    }

    @Test
    public void calculateScoreWithBefore_3연속STRIKE() throws Exception {
        assertThat(strike.getFrameScore().isPresent()).isFalse();

        assertThat(strike.calculateScoreWithBefore(strike, strike).isPresent()).isTrue();
        assertThat(strike.calculateScoreWithBefore(strike, strike).get()).isEqualTo(30);
    }
}