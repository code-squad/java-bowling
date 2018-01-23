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

/*    @Test
    public void toViewTest() {
        assertThat(FrameStatus.toView(new Pin(10), null)).isEqualTo("X  ");
        assertThat(FrameStatus.toView(new Pin(8), new Pin(2))).isEqualTo("8|/");
        assertThat(FrameStatus.toView(new Pin(5), null)).isEqualTo("5  ");
        assertThat(FrameStatus.toView(new Pin(5), new Pin(0))).isEqualTo("5|-");
        assertThat(FrameStatus.toView(new Pin(0), new Pin(0))).isEqualTo("-|-");
    }*/
}
