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
    public void 스트라이크() {
        State strike = frame.bowl(10);
        assertEquals(strike instanceof Strike, true);
    }

    @Test
    public void ready테스트() {
        String result = frame.state.displayText();
        Assert.assertThat(null, is(result));
    }

    @Test
    public void 스페어테스트() {
        frame.bowl(8);
        State spare = frame.state.bowl(2);
        assertEquals(spare instanceof Spare, true);
    }

    @Test
    public void 미싱테스트() {
        frame.bowl(5);
        State miss = frame.state.bowl(4);
        assertEquals(miss instanceof Miss, true);
    }
}
