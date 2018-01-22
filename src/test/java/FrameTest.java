import model.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FrameTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수값_들어올때_error_쓰로잉() {
        frame.bowl(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 점수가_10이상이_들어왔을때_error_스로잉() {
        frame.bowl(4);
        frame.bowl(8);
    }

    @Test
    public void getScoreStrikeTest() {
        frame.bowl(10);
        frame.bowl(6);
        frame.bowl(2);

        assertThat(frame.getRoundScore()).isEqualTo(18);
    }

    @Test
    public void multipleStrikeTest() {
        frame.bowl(10);
        frame.bowl(10);
        frame.bowl(10);
        frame.bowl(9);
        assertThat(frame.getRoundScore()).isEqualTo(30);
    }

}
