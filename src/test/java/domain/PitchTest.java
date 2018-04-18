package domain;

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
}
