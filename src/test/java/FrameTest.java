import model.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수값_들어올때_error_쓰로잉() {
        frame.setBallOne(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 점수가_10이상이_들어왔을때_error_스로잉() {
        frame.setBallOne(4);
        frame.setBallTwo(8);
    }

    @Test
    public void isStrikeTest() {
        frame.setBallOne(10);
        assertThat(frame.isStrike()).isTrue();
    }

    @Test
    public void 스페어인지_테스트() {
        frame.setBallOne(8);
        frame.setBallTwo(2);
        assertThat(frame.isSpare()).isTrue();
    }

}
