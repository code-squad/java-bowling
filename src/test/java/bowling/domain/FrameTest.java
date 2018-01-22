package bowling.domain;

import bowling.enums.FrameStatus;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameTest {
    private Frame frame;

    @Before
    public void init() {
        frame = new Frame();
    }

    @Test
    public void frameStatusTest() {
        assertThat(frame.status()).isEqualTo(FrameStatus.NOT_START);
    }

    @Test
    public void printFrame() {
        assertThat(frame.printFrame()).isEqualTo("      ");
    }

    @Test
    public void firstBowlTest() {
        frame.firstBowl(new Pin(10));
        assertThat(frame.status()).isEqualTo(FrameStatus.STRIKE);
    }

    @Test
    public void firstBowlTest2() {
        frame.firstBowl(new Pin(7));
        assertThat(frame.status()).isEqualTo(FrameStatus.NOT_END);
    }
}
