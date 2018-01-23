package bowling.util;

import bowling.domain.Pin;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PinUtilTest {
    @Test()
    public void getNumOfPinTest() {
        assertThat(PinUtil.getNumOfPin(new Pin(10))).isEqualTo(10);
        assertThat(PinUtil.getNumOfPin(null)).isEqualTo(-1);
    }

    @Test
    public void finalFrameViewTest() {
        assertThat(PinUtil.frameView(new Pin(10), null)).isEqualTo("X ");
        assertThat(PinUtil.frameView(new Pin(8), new Pin(2))).isEqualTo("8/");
        assertThat(PinUtil.frameView(new Pin(5), null)).isEqualTo("5 ");
        assertThat(PinUtil.frameView(new Pin(5), new Pin(0))).isEqualTo("5-");
        assertThat(PinUtil.frameView(new Pin(0), new Pin(0))).isEqualTo("--");
    }

    @Test
    public void toViewTest() {
        assertThat(PinUtil.toView(new Pin(10))).isEqualTo("X");
        assertThat(PinUtil.toView(new Pin(0))).isEqualTo("-");
        assertThat(PinUtil.toView(new Pin(8))).isEqualTo("8");
        assertThat(PinUtil.toView(new Pin(5), new Pin(5))).isEqualTo("/");
    }
}
