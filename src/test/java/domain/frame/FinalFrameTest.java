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
    public void canScore테스트() {
        assertThat(new FinalFrame(0).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(0).bowl(1).canScore()).isEqualTo(true);
        assertThat(new FinalFrame(0).bowl(10).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(0).bowl(10).bowl(10).canScore()).isEqualTo(true);
        
        assertThat(new FinalFrame(8).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(8).bowl(1).canScore()).isEqualTo(true);
        
        assertThat(new FinalFrame(1).bowl(9).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(1).bowl(9).bowl(10).canScore()).isEqualTo(true);
        
        assertThat(new FinalFrame(10).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(2).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(2).bowl(8).canScore()).isEqualTo(true);
        assertThat(new FinalFrame(10).bowl(10).canScore()).isEqualTo(false);
        assertThat(new FinalFrame(10).bowl(10).bowl(10).canScore()).isEqualTo(true);
    }

    @Test
    public void score테스트() {
        assertThat(new FinalFrame(0).bowl(1).score()).isEqualTo(1);
        assertThat(new FinalFrame(0).bowl(10).bowl(10).score()).isEqualTo(20);

        assertThat(new FinalFrame(8).bowl(1).score()).isEqualTo(9);

        assertThat(new FinalFrame(1).bowl(9).bowl(10).score()).isEqualTo(20);

        assertThat(new FinalFrame(10).bowl(2).bowl(8).score()).isEqualTo(20);
        assertThat(new FinalFrame(10).bowl(10).bowl(10).score()).isEqualTo(30);
    }
}
