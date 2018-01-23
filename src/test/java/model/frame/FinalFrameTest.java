package model.frame;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class FinalFrameTest {
    private Frame finalFrame;

    @Before
    public void setUp() {
        finalFrame = Frame.of(10);
    }

    @Test
    public void 스페어인경우_다쳤는가() {
        finalFrame.bowl(5);
        finalFrame.bowl(5);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(10);
        assertThat(finalFrame.isFinished()).isTrue();
    }

    @Test
    public void 스트라이크인경우_다쳤는가() {
        finalFrame.bowl(10);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(4);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(4);
        assertThat(finalFrame.isFinished()).isTrue();
    }

    @Test
    public void 모두_스트라이크인경우_다쳤는가() {
        finalFrame.bowl(10);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(10);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(10);
        assertThat(finalFrame.isFinished()).isTrue();
    }

    @Test
    public void 스트라이크_다음_스페어인경우_다쳤는가() {
        finalFrame.bowl(10);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(2);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(8);
        assertThat(finalFrame.isFinished()).isTrue();
    }

    @Test
    public void 미스인경우_다쳤는가() {
        finalFrame.bowl(2);
        assertThat(finalFrame.isFinished()).isFalse();

        finalFrame.bowl(4);
        assertThat(finalFrame.isFinished()).isTrue();
    }
}