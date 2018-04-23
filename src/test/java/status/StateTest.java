package status;

import frame.Frame;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class StateTest {
    @Test
    public void 스트라이크() {
        Frame frame = new Frame();
        String result = frame.bowl(10).displayText();
        Assert.assertThat("X", is(result));
    }

    @Test
    public void ready테스트() {
        Frame frame = new Frame();
        String result = frame.state.displayText();
        Assert.assertThat(null, is(result));
    }

    @Test
    public void 스페어테스트() {
        Frame frame = new Frame();
        frame.bowl(8);
        String result = frame.state.bowl(2).displayText();
        Assert.assertThat("/", is(result));
    }

    @Test
    public void 미싱테스트() {
        Frame frame = new Frame();
        frame.bowl(5);
        String result = frame.state.bowl(4).displayText();
        Assert.assertThat("5|4", is(result));
    }
}
