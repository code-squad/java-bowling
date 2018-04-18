package domain.frame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성테스트() {
        new FinalFrame(11);
    }

    @Test
    public void isComplete테스트() {
        assertThat(new FinalFrame(10).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(2).isComplete()).isEqualTo(true);
        assertThat(new FinalFrame(1).bowl(9).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(2).bowl(8).bowl(3).isComplete()).isEqualTo(true);
        assertThat(new FinalFrame(1).bowl(2).isComplete()).isEqualTo(true);
    }

    @Test
    public void isPinRemained테스트() {
        assertThat(new FinalFrame(9).isPinRemained()).isEqualTo(true);
        assertThat(new FinalFrame(10).isPinRemained()).isEqualTo(false);

        assertThat(new FinalFrame(1).bowl(2).isPinRemained()).isEqualTo(true);
        assertThat(new FinalFrame(1).bowl(9).isPinRemained()).isEqualTo(false);

        assertThat(new FinalFrame(10).bowl(2).isPinRemained()).isEqualTo(true);
        assertThat(new FinalFrame(10).bowl(10).isPinRemained()).isEqualTo(false);
        assertThat(new FinalFrame(2).bowl(8).bowl(3).isPinRemained()).isEqualTo(true);
        assertThat(new FinalFrame(2).bowl(8).bowl(10).isPinRemained()).isEqualTo(false);
    }
    
    @Test
    public void isFinalFrame테스트() {
        assertThat(new FinalFrame(8).isFinalFrame()).isEqualTo(true);
        assertThat(new FinalFrame(10).isFinalFrame()).isEqualTo(true);
        assertThat(new FinalFrame(8).bowl(1).isFinalFrame()).isEqualTo(true);
        assertThat(new FinalFrame(1).bowl(9).bowl(10).isFinalFrame()).isEqualTo(true);
    }
    
    @Test
    public void hasThirdPitch테스트() {
        assertThat(((FinalFrame)new FinalFrame(1).bowl(2)).hasThirdPitch()).isEqualTo(false);
        assertThat(((FinalFrame)new FinalFrame(1).bowl(9).bowl(2)).hasThirdPitch()).isEqualTo(true);
        assertThat(((FinalFrame)new FinalFrame(1).bowl(9).bowl(10)).hasThirdPitch()).isEqualTo(true);
        assertThat(((FinalFrame)new FinalFrame(10).bowl(10)).hasThirdPitch()).isEqualTo(false);
        assertThat(((FinalFrame)new FinalFrame(10).bowl(1).bowl(2)).hasThirdPitch()).isEqualTo(true);
        assertThat(((FinalFrame)new FinalFrame(10).bowl(1).bowl(9)).hasThirdPitch()).isEqualTo(true);
    }
}
