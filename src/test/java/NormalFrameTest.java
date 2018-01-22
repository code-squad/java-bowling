import model.frame.NormalFrame;
import org.junit.Before;
import org.junit.Test;

public class NormalFrameTest {
    private NormalFrame normalFrame;

    @Before
    public void setUp() {
        normalFrame = new NormalFrame(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수값_들어올때_error_쓰로잉() {
        normalFrame.bowl(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 점수가_10이상이_들어왔을때_error_스로잉() {
        normalFrame.bowl(4);
        normalFrame.bowl(8);
    }
}
