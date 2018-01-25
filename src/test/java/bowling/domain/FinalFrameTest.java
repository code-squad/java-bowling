package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {
    private FinalFrame finalFrame;
    @Before
    public void setUp() throws Exception {
        finalFrame = new FinalFrame();

    }

    @Test
    public void hasNext() {
        finalFrame.marking(9);
        assertThat(finalFrame.hasNext()).isTrue();

        finalFrame.marking(0);
        assertThat(finalFrame.hasNext()).isFalse();
    }

    @Test
    public void hasNext_스트라이크() {
        finalFrame.marking(10);
        assertThat(finalFrame.hasNext()).isTrue();

        finalFrame.marking(2);
        assertThat(finalFrame.hasNext()).isTrue();

        finalFrame.marking(5);
        assertThat(finalFrame.hasNext()).isFalse();
    }

    @Test
    public void hasNext_스페어() {
        finalFrame.marking(9);
        assertThat(finalFrame.hasNext()).isTrue();

        finalFrame.marking(1);
        assertThat(finalFrame.hasNext()).isTrue();

        finalFrame.marking(10);
        assertThat(finalFrame.hasNext()).isFalse();
    }

}