package bowling;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class FrameTest {

    private Frame frame;

    @Before
    public void setup() {
        this.frame = Frame.initialFrame();
    }

    @Test
    public void 스트라이크() {
        frame.shot(10);

        assertThat(frame.getScore()).isEqualTo("X");
    }

    @Test
    public void 스페어() {
        frame.shot(8);
        frame.shot(2);

        assertThat(frame.getScore()).isEqualTo("8|/");
    }

    @Test
    public void 거터() {
        frame.shot(0);

        assertThat(frame.getScore()).isEqualTo("-");
    }

    @Test
    public void 미스() {
        frame.shot(5);
        frame.shot(3);

        assertThat(frame.getScore()).isEqualTo("5|3");
    }

    @Test
    public void 다음프레임_이동() {
        Frame nextFrame = null;

        while (frame.canThrowBowling()) {
            nextFrame = frame.shot(3);
        }

        assertThat(nextFrame.current()).isEqualTo(2);
    }

    @Test
    public void name() {
        Frame nextFrame = frame.shot(10);

        nextFrame.shot(5);
        nextFrame.shot(5);

        assertThat(Score.result(nextFrame)).contains("X", "5|/");
    }
}
