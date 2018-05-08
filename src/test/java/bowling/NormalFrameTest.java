package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author sangsik.kim
 */
public class NormalFrameTest {

    @Test
    public void ready() {
        Frame frame = new NormalFrame();

        assertThat(frame.status(), is("Ready"));
    }

    @Test
    public void miss() {
        Frame frame = new NormalFrame();

        frame.bowl(5);
        frame.bowl(2);

        assertThat(frame.status(), is("Miss"));
    }

    @Test
    public void strike() {
        Frame frame = new NormalFrame();

        frame.bowl(10);

        assertThat(frame.status(), is("Strike"));
    }

    @Test
    public void spare() {
        Frame frame = new NormalFrame();

        frame.bowl(5);
        frame.bowl(5);

        assertThat(frame.status(), is("Spare"));
    }

    @Test
    public void gutter() {
        Frame frame = new NormalFrame();

        frame.bowl(0);

        assertThat(frame.status(), is("Gutter"));
    }
}
