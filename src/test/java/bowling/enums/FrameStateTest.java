package bowling.enums;

import bowling.domain.Pin;
import org.junit.Test;

import static bowling.enums.FrameState.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameStateTest {
    @Test
    public void FrameStatusTest() {
        assertThat(FrameState.getStatus(null, null)).isEqualTo(NOT_END);
        assertThat(FrameState.getStatus(new Pin(10), null)).isEqualTo(STRIKE);
        assertThat(FrameState.getStatus(new Pin(8), new Pin(2))).isEqualTo(SPARE);
        assertThat(FrameState.getStatus(new Pin(5), null)).isEqualTo(NOT_END);
        assertThat(FrameState.getStatus(new Pin(0), new Pin(0))).isEqualTo(MISS);
        assertThat(FrameState.getStatus(new Pin(5), new Pin(0))).isEqualTo(MISS);
    }

    @Test
    public void isEndTest() {
        assertThat(NOT_END.isEnd()).isFalse();
        assertThat(STRIKE.isEnd()).isTrue();
        assertThat(SPARE.isEnd()).isTrue();
        assertThat(MISS.isEnd()).isTrue();
    }
}
