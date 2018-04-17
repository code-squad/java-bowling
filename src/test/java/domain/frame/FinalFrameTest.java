package domain.frame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {
    @Test
    public void isComplete테스트() {
        assertThat(new FinalFrame(10, 10).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(10, 10).bowl(2).isComplete()).isEqualTo(true);
        assertThat(new FinalFrame(10, 1).bowl(9).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(10, 2).bowl(8).bowl(3).isComplete()).isEqualTo(true);
        assertThat(new FinalFrame(10, 1).bowl(2).isComplete()).isEqualTo(true);
    }
}
