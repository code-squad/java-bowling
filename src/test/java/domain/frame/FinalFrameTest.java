package domain.frame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class FinalFrameTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성테스트() {
        new FinalFrame(11);
    }

    @Test
    public void isComplete테스트() {
        assertThat(new FinalFrame(0).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(0).bowl(1).isComplete()).isEqualTo(true);
        assertThat(new FinalFrame(0).bowl(10).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(0).bowl(10).bowl(10).isComplete()).isEqualTo(true);
    
        assertThat(new FinalFrame(8).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(8).bowl(1).isComplete()).isEqualTo(true);
    
        assertThat(new FinalFrame(1).bowl(9).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(1).bowl(9).bowl(10).isComplete()).isEqualTo(true);
    
        assertThat(new FinalFrame(10).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(2).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(2).bowl(8).isComplete()).isEqualTo(true);
        assertThat(new FinalFrame(10).bowl(10).isComplete()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(10).bowl(10).isComplete()).isEqualTo(true);
    }

    @Test
    public void isFinalFrame테스트() {
        assertThat(new FinalFrame(8).isFinalFrame()).isEqualTo(true);
        assertThat(new FinalFrame(10).isFinalFrame()).isEqualTo(true);
        assertThat(new FinalFrame(8).bowl(1).isFinalFrame()).isEqualTo(true);
        assertThat(new FinalFrame(1).bowl(9).bowl(10).isFinalFrame()).isEqualTo(true);
    }
    
    @Test
    public void score테스트() {
        assertThat(new FinalFrame(0).bowl(1).getScore().getScore()).isEqualTo(1);
        assertThat(new FinalFrame(0).bowl(10).bowl(10).getScore().getScore()).isEqualTo(20);

        assertThat(new FinalFrame(8).bowl(1).getScore().getScore()).isEqualTo(9);

        assertThat(new FinalFrame(1).bowl(9).bowl(10).getScore().getScore()).isEqualTo(20);

        assertThat(new FinalFrame(10).bowl(2).bowl(8).getScore().getScore()).isEqualTo(20);
        assertThat(new FinalFrame(10).bowl(10).bowl(10).getScore().getScore()).isEqualTo(30);
    
        assertFalse(new FinalFrame(1).getScore().getScoreFlag());
        assertFalse(new FinalFrame(10).getScore().getScoreFlag());
        assertFalse(new FinalFrame(10).bowl(1).getScore().getScoreFlag());
    }
}
