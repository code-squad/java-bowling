package bowling.enums;

import bowling.domain.Pin;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameStatusTest {
    @Test
    public void FrameStatusTest() {
        assertThat(FrameStatus.getStatus(null, null)).isEqualTo(FrameStatus.NOT_START);
        assertThat(FrameStatus.getStatus(new Pin(10), null)).isEqualTo(FrameStatus.STRIKE);
        assertThat(FrameStatus.getStatus(new Pin(8), new Pin(2))).isEqualTo(FrameStatus.SPARE);
        assertThat(FrameStatus.getStatus(new Pin(5), null)).isEqualTo(FrameStatus.NOT_END);
        assertThat(FrameStatus.getStatus(new Pin(0), new Pin(0))).isEqualTo(FrameStatus.MISS);
        assertThat(FrameStatus.getStatus(new Pin(5), new Pin(0))).isEqualTo(FrameStatus.MISS);
    }

    @Test
    public void toViewTest() {
        assertThat(FrameStatus.toView(new Pin(10), null)).isEqualTo("X  ");
        assertThat(FrameStatus.toView(new Pin(8), new Pin(2))).isEqualTo("8|/");
        assertThat(FrameStatus.toView(new Pin(5), null)).isEqualTo("5  ");
        assertThat(FrameStatus.toView(new Pin(5), new Pin(0))).isEqualTo("5|-");
        assertThat(FrameStatus.toView(new Pin(0), new Pin(0))).isEqualTo("-|-");
    }
}
