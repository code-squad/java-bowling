package domain.frame;

import domain.score.Pin;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    @Test
    public void bowl_SPARE() throws Exception {
        NormalFrame normalFrame = new NormalFrame(Pin.ZERO);
        assertThat(normalFrame.isFinish()).isFalse();

        normalFrame.bowl(Pin.TEN);
        assertThat(normalFrame.isFinish()).isTrue();
        assertThat(normalFrame.getFrameScore().isPresent()).isFalse();

        normalFrame.bowl(new Pin(3));
        assertThat(normalFrame.getFrameScore().isPresent()).isTrue();
        assertThat(normalFrame.getFrameScore().get()).isEqualTo(13);
    }

    @Test
    public void bowl_STRIKE() throws Exception {
        NormalFrame normalFrame = new NormalFrame(Pin.TEN);
        ;
        assertThat(normalFrame.isFinish()).isTrue();
        assertThat(normalFrame.getFrameScore().isPresent()).isFalse();

        normalFrame.bowl(Pin.TEN)
                   .ifPresent(f -> f.bowl(Pin.TEN));

        assertThat(normalFrame.isFinish()).isTrue();
        assertThat(normalFrame.getFrameScore().isPresent()).isTrue();
        assertThat(normalFrame.getFrameScore().get()).isEqualTo(30);
    }

    @Test
    public void bowl_MISS() throws Exception {
        NormalFrame normalFrame = new NormalFrame(Pin.ZERO);
        assertThat(normalFrame.isFinish()).isFalse();

        normalFrame.bowl(new Pin(7));
        assertThat(normalFrame.isFinish()).isTrue();
        assertThat(normalFrame.getFrameScore().isPresent()).isTrue();
        assertThat(normalFrame.getFrameScore().get()).isEqualTo(7);
    }

    @Test
    public void NormalScore_거터() throws Exception {
        NormalFrame zero = new NormalFrame(Pin.ZERO);

        assertThat(zero.toString()).isEqualTo("-");
    }

    @Test(expected = IllegalArgumentException.class)
    public void NormalScore_총합이10이넘는경우() throws Exception {
        NormalFrame normalScore = new NormalFrame(new Pin(7));
        normalScore.bowl(new Pin(4));
    }

}