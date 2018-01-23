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
}
