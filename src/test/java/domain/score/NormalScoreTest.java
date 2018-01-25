package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalScoreTest {

    @Test
    public void NormalScore_거터() throws Exception {
        NormalScore zero = new NormalScore(Pin.ZERO);

        assertThat(zero.toString()).isEqualTo("-");
        assertThat(zero.isFinish()).isFalse();
        assertThat(zero.getFrameScore().isPresent()).isFalse();
        assertThat(zero.getSumOfFirstAndSecondScore().isPresent()).isFalse();
    }

    @Test
    public void NormalScore_끝나지않은Frame() throws Exception {
        NormalScore score = new NormalScore(new Pin(7));

        assertThat(score.toString()).isEqualTo("7");
        assertThat(score.isStrike()).isFalse();
        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.getSumOfFirstAndSecondScore().isPresent()).isFalse();
    }

    @Test
    public void NormalScore_스트라이크() throws Exception {
        NormalScore strike = new NormalScore(Pin.TEN);

        assertThat(strike.toString()).isEqualTo("X");
        assertThat(strike.isStrike()).isTrue();
        assertThat(strike.isFinish()).isTrue();
        assertThat(strike.getFrameScore().isPresent()).isFalse();
        assertThat(strike.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(strike.getSumOfFirstAndSecondScore().get()).isEqualTo(10);
    }

    @Test
    public void NormalScore_스페어() throws Exception {
        NormalScore spare = new NormalScore(new Pin(7));
        spare.addResult(new Pin(3));

        assertThat(spare.toString()).isEqualTo("7|/");
        assertThat(spare.isFinish()).isTrue();
        assertThat(spare.getFrameScore().isPresent()).isFalse();
        assertThat(spare.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(spare.getSumOfFirstAndSecondScore().get()).isEqualTo(10);
    }

    @Test
    public void NormalScore_미스() throws Exception {
        NormalScore spare = new NormalScore(new Pin(7));
        spare.addResult(new Pin(2));

        assertThat(spare.toString()).isEqualTo("7|2");
        assertThat(spare.isFinish()).isTrue();
        assertThat(spare.getFrameScore().isPresent()).isTrue();
        assertThat(spare.getFrameScore().get()).isEqualTo(9);
        assertThat(spare.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(spare.getSumOfFirstAndSecondScore().get()).isEqualTo(9);
    }

}