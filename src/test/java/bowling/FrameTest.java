package bowling;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    private Frame frame;

    @Before
    public void setup() {
        frame = new Frame();
    }

    @Test
    public void displayText_투구전() {
        assertThat(frame.displayText()).isEqualTo("");
    }

    @Test
    public void displayText_첫번째_투구() {
        frame.bowl(7);
        assertThat(frame.displayText()).isEqualTo("7");
    }

    @Test
    public void displayText_strike() {
        frame.bowl(10);
        assertThat(frame.displayText()).isEqualTo("X");
    }

    @Test
    public void displayText_spare() {
        frame.bowl(8);
        frame.bowl(2);
        assertThat(frame.displayText()).isEqualTo("8|/");
    }

    @Test
    public void displayText_miss() {
        frame.bowl(8);
        frame.bowl(1);
        assertThat(frame.displayText()).isEqualTo("8|1");
    }

    @Test
    public void isFinish_running() {
        assertThat(frame.isFinish()).isFalse();

        frame.bowl(8);
        assertThat(frame.isFinish()).isFalse();
    }

    @Test
    public void isFinish_finished() {
        frame.bowl(10);
        assertThat(frame.isFinish()).isTrue();

        frame = new Frame();
        frame.bowl(8);
        frame.bowl(2);
        assertThat(frame.isFinish()).isTrue();

        frame = new Frame();
        frame.bowl(8);
        frame.bowl(1);
        assertThat(frame.isFinish()).isTrue();
    }
}
