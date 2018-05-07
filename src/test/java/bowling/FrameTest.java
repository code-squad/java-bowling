package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author sangsik.kim
 */
public class FrameTest {

    @Test
    public void ready() {
        Frame frame = new Frame();

        assertThat(frame.status(), is("Ready"));
    }

    @Test
    public void miss() {
        Frame frame = new Frame();

        frame.bowl(5);
        frame.bowl(2);

        assertThat(frame.status(), is("Miss"));
    }

    @Test
    public void strike() {
        Frame frame = new Frame();

        frame.bowl(10);

        assertThat(frame.status(), is("Strike"));
    }

    @Test
    public void spare() {
        Frame frame = new Frame();

        frame.bowl(5);
        frame.bowl(5);

        assertThat(frame.status(), is("Spare"));
    }

    @Test
    public void gutter() {
        Frame frame = new Frame();

        frame.bowl(0);

        assertThat(frame.status(), is("Gutter"));
    }
}
