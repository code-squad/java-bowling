package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameScoreTest {

    @Test
    public void NormalScore_거터() throws Exception {
        NormalFrameScore zero = new NormalFrameScore(Pin.ZERO);

        assertThat(zero.toString()).isEqualTo("-");
    }

    @Test
    public void NormalScore_끝나지않은Frame() throws Exception {
        NormalFrameScore score = new NormalFrameScore(new Pin(7));

        assertThat(score.toString()).isEqualTo("7");
        assertThat(score.isFinish()).isFalse();
        assertThat(score.getFrameScore().isPresent()).isFalse();
        assertThat(score.getSumOfFirstAndSecondScore().isPresent()).isFalse();
    }

    @Test
    public void NormalScore_스트라이크() throws Exception {
        NormalFrameScore strike = new NormalFrameScore(Pin.TEN);

        assertThat(strike.isStrike()).isTrue();
        assertThat(strike.getFrameScore().isPresent()).isFalse();
        assertThat(strike.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(strike.getSumOfFirstAndSecondScore().get()).isEqualTo(10);
    }

    @Test
    public void NormalScore_스페어() throws Exception {
        NormalFrameScore spare = new NormalFrameScore(new Pin(7));
        spare.addResult(new Pin(3));

        assertThat(spare.toString()).isEqualTo("7|/");
        assertThat(spare.isFinish()).isTrue();
        assertThat(spare.getFrameScore().isPresent()).isFalse();
        assertThat(spare.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(spare.getSumOfFirstAndSecondScore().get()).isEqualTo(10);
    }

    @Test
    public void NormalScore_미스() throws Exception {
        NormalFrameScore spare = new NormalFrameScore(new Pin(7));
        spare.addResult(new Pin(2));

        assertThat(spare.toString()).isEqualTo("7|2");
        assertThat(spare.isFinish()).isTrue();
        assertThat(spare.getFrameScore().isPresent()).isTrue();
        assertThat(spare.getFrameScore().get()).isEqualTo(9);
        assertThat(spare.getSumOfFirstAndSecondScore().isPresent()).isTrue();
        assertThat(spare.getSumOfFirstAndSecondScore().get()).isEqualTo(9);
    }

    @Test
    public void toString_스페어() throws Exception {
        NormalFrameScore normalScore = new NormalFrameScore(new Pin(0));
        normalScore.addResult(Pin.TEN);
        assertThat(normalScore.isStrike()).isFalse();
        assertThat(normalScore.toString()).isEqualTo("-|/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void NormalScore_74() throws Exception {
        NormalFrameScore normalScore = new NormalFrameScore(new Pin(7));
        normalScore.addResult(new Pin(4));

    }
}