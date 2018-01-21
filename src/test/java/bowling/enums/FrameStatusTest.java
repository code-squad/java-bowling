package bowling.enums;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameStatusTest {
    @Test
    public void FrameStatusTest() {
        assertThat(FrameStatus.valueOf(-1, -1)).isEqualTo(FrameStatus.NOT_START);
        assertThat(FrameStatus.valueOf(10, -1)).isEqualTo(FrameStatus.STRIKE);
        assertThat(FrameStatus.valueOf(8, 2)).isEqualTo(FrameStatus.SPARE);
        assertThat(FrameStatus.valueOf(5, -1)).isEqualTo(FrameStatus.NOT_END);
        assertThat(FrameStatus.valueOf(0, 0)).isEqualTo(FrameStatus.MISS);
        assertThat(FrameStatus.valueOf(5, 0)).isEqualTo(FrameStatus.MISS);
    }
}
