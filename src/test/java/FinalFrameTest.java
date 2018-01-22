import model.FinalFrame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {
    private FinalFrame finalFrame;

    @Before
    public void setUp() {
        finalFrame = new FinalFrame();
    }

    @Test
    public void 더_던질수있는지_테스트() {
        assertThat(finalFrame.isAbleToPlay()).isTrue();
    }
}
