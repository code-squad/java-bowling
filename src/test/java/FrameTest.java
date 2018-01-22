import model.Frame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    @Test()
    public void 값이유효한지확인한다() {
        Frame frame = new Frame();
        assertThat(frame.isValidNumber(-1)).isEqualTo(false);
    }

    @Test
    public void isStrikeTest() {
        Frame frame = new Frame();
        frame.setBallOne(10);
        assertThat(frame.isStrike()).isEqualTo(true);
    }
}
