package domain;

import domain.pitch.Pitch;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PitchTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성테스트() {
        new Pitch(5, 6);
    }

    @Test
    public void getRemainPinCount테스트() {
        assertThat(new Pitch(10, 7).getRemainPinCount()).isEqualTo(3);
    }

    @Test
    public void isClear테스트() {
        assertThat(new Pitch(10, 10).isClear()).isEqualTo(true);
        assertThat(new Pitch(10, 9).isClear()).isEqualTo(false);
    }
    
    @Test
    public void getStatus테스트() {
        assertThat(new Pitch(10, 0).getStatus()).isEqualTo(PlayStatus.GUTTER);
        assertThat(new Pitch(5, 0).getStatus()).isEqualTo(PlayStatus.MISS);
        assertThat(new Pitch(10, 10).getStatus()).isEqualTo(PlayStatus.STRIKE);
        assertThat(new Pitch(5, 5).getStatus()).isEqualTo(PlayStatus.SPARE);
        assertThat(new Pitch(10, 1).getStatus()).isEqualTo(PlayStatus.NONE);
        assertThat(new Pitch(5, 1).getStatus()).isEqualTo(PlayStatus.OPEN);
    }
    
    @Test
    public void getDisplayValue테스트() {
        assertThat(new Pitch(10, 0).getDisplayValue()).isEqualTo(PlayStatus.GUTTER.getDisplayFormat());
        assertThat(new Pitch(5, 0).getDisplayValue()).isEqualTo(PlayStatus.MISS.getDisplayFormat());
        assertThat(new Pitch(10, 10).getDisplayValue()).isEqualTo(PlayStatus.STRIKE.getDisplayFormat());
        assertThat(new Pitch(5, 5).getDisplayValue()).isEqualTo(PlayStatus.SPARE.getDisplayFormat());
        assertThat(new Pitch(10, 1).getDisplayValue()).isEqualTo("1");
        assertThat(new Pitch(5, 1).getDisplayValue()).isEqualTo("1");
    }
}
