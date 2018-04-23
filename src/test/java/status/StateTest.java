package status;

import frame.Frame2;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StateTest {
    @Test
    public void 스트라이크() {
        Frame2 frame2 = new Frame2();
        String result = frame2.bowl(10).displayText();
        Assert.assertThat("X", is(result));
    }

    @Test
    public void ready테스트() {
        Frame2 frame2 = new Frame2();
        String result = frame2.state.displayText();
        Assert.assertThat(null, is(result));
    }

    @Test
    public void 스페어테스트() {
        Frame2 frame2 = new Frame2();
        frame2.bowl(8);
        String result =frame2.state.bowl(2).displayText();
        Assert.assertThat("/", is(result));
    }

    @Test
    public void 미싱테스트() {
        Frame2 frame2 = new Frame2();
        frame2.bowl(5);
        String result = frame2.state.bowl(4).displayText();
        Assert.assertThat("5|4", is(result));
    }
}
