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
    public void isEndTest() {
        assertThat(FrameStatus.isEnd(FrameStatus.NOT_END)).isFalse();
        assertThat(FrameStatus.isEnd(FrameStatus.NOT_START)).isFalse();
        assertThat(FrameStatus.isEnd(FrameStatus.STRIKE)).isTrue();
        assertThat(FrameStatus.isEnd(FrameStatus.SPARE)).isTrue();
        assertThat(FrameStatus.isEnd(FrameStatus.MISS)).isTrue();
    }
}
