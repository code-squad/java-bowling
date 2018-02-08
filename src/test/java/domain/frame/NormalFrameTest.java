package domain.frame;

import domain.score.Pin;
import domain.score.Ready;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    @Test
    public void bowl_SPARE() throws Exception {
        NormalFrame normalFrame = new NormalFrame(Ready.bowl(Pin.ZERO));

        normalFrame.bowl(Pin.TEN);
        assertThat(normalFrame.getFrameScore().isPresent()).isFalse();

        normalFrame.bowl(new Pin(3));
        assertThat(normalFrame.getFrameScore().isPresent()).isTrue();
        assertThat(normalFrame.getFrameScore().get()).isEqualTo(13);
        assertThat(normalFrame.toString()).isEqualTo("-|/");
    }

    @Test
    public void bowl_STRIKE() throws Exception {
        NormalFrame normalFrame = new NormalFrame(Ready.bowl(Pin.TEN));

        assertThat(normalFrame.getFrameScore().isPresent()).isFalse();

        normalFrame.bowl(Pin.TEN)
                   .ifPresent(f -> f.bowl(Pin.TEN));

        assertThat(normalFrame.getFrameScore().isPresent()).isTrue();
        assertThat(normalFrame.getFrameScore().get()).isEqualTo(30);
        assertThat(normalFrame.toString()).isEqualTo("X");
    }

    @Test
    public void bowl_MISS() throws Exception {
        NormalFrame normalFrame = new NormalFrame(Ready.bowl(Pin.ZERO));

        normalFrame.bowl(new Pin(7));
        assertThat(normalFrame.getFrameScore().isPresent()).isTrue();
        assertThat(normalFrame.getFrameScore().get()).isEqualTo(7);
        assertThat(normalFrame.toString()).isEqualTo("-|7");
    }

    @Test
    public void NormalScore_거터() throws Exception {
        NormalFrame zero = new NormalFrame(Ready.bowl(Pin.ZERO));

        assertThat(zero.toString()).isEqualTo("-");
    }

    @Test(expected = IllegalArgumentException.class)
    public void NormalScore_총합이10이넘는경우() throws Exception {
        NormalFrame normalScore = new NormalFrame(Ready.bowl(new Pin(7)));
        normalScore.bowl(new Pin(4));
    }

}