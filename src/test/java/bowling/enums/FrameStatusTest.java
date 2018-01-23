package bowling.enums;

import bowling.domain.Pin;
import org.junit.Test;

import static bowling.enums.FrameStatus.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameStatusTest {
    @Test
    public void FrameStatusTest() {
        assertThat(FrameStatus.getStatus(null, null)).isEqualTo(NOT_START);
        assertThat(FrameStatus.getStatus(new Pin(10), null)).isEqualTo(STRIKE);
        assertThat(FrameStatus.getStatus(new Pin(8), new Pin(2))).isEqualTo(SPARE);
        assertThat(FrameStatus.getStatus(new Pin(5), null)).isEqualTo(NOT_END);
        assertThat(FrameStatus.getStatus(new Pin(0), new Pin(0))).isEqualTo(MISS);
        assertThat(FrameStatus.getStatus(new Pin(5), new Pin(0))).isEqualTo(MISS);
    }

    @Test
    public void isEndTest() {
        assertThat(FrameStatus.isEnd(NOT_END)).isFalse();
        assertThat(FrameStatus.isEnd(NOT_START)).isFalse();
        assertThat(FrameStatus.isEnd(STRIKE)).isTrue();
        assertThat(FrameStatus.isEnd(SPARE)).isTrue();
        assertThat(FrameStatus.isEnd(MISS)).isTrue();
    }
}
