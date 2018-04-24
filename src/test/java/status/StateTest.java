package status;

import frame.Frame;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class StateTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void ready테스트() {
        String result = frame.state.displayText();
        Assert.assertThat(null, is(result));
    }
}
