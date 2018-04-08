package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LastFrameTest {

    @Test
    public void last_frame_should_send_end_message_when_try_second_and_no_bonus() {
        Frame lastFrame = new LastFrame();
        lastFrame.trying(1);
        lastFrame.trying(3);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void should_send_not_end_when_spare_at_last_frame() {
        Frame lastFrame = new LastFrame();
        lastFrame.trying(3);
        lastFrame.trying(7);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void should_send_not_end_when_strike_at_last_frame() {
        Frame lastFrame = new LastFrame();
        lastFrame.trying(10);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void should_send_end_when_after_3_sequence_strike() {
        Frame lastFrame = new LastFrame();
        lastFrame.trying(10);
        lastFrame.trying(10);
        lastFrame.trying(10);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void should_send_end_when_after_spare_and_one_try_bonus() {
        Frame lastFrame = new LastFrame();
        lastFrame.trying(3);
        lastFrame.trying(7);
        lastFrame.trying(10);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

}
