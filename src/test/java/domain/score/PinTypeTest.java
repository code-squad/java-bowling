package domain.score;

import org.junit.Test;

import static domain.score.PinType.GUTTER;
import static domain.score.PinType.NONE;
import static domain.score.PinType.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

public class PinTypeTest {

    @Test
    public void valueOf_거터() throws Exception {
        assertThat(PinType.valueOf(new Pin(0))).isEqualTo(GUTTER);
    }

    @Test
    public void valueOf_STRIKE() throws Exception {
        assertThat(PinType.valueOf(new Pin(10))).isEqualTo(STRIKE);
    }

    @Test
    public void valueOf_NONE() throws Exception {
        assertThat(PinType.valueOf(new Pin(1))).isEqualTo(NONE);
        assertThat(PinType.valueOf(new Pin(9))).isEqualTo(NONE);
    }

    @Test
    public void getDisplay() throws Exception {
        assertThat(STRIKE.getDisplay()).isEqualTo("X");
        assertThat(GUTTER.getDisplay()).isEqualTo("-");
    }

    @Test
    public void isDisplay() throws Exception {
        assertThat(STRIKE.isDisplay()).isTrue();
        assertThat(GUTTER.isDisplay()).isTrue();
        assertThat(NONE.isDisplay()).isFalse();
    }

}