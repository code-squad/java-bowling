package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FrameTest {

    Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void calculate_total_score_at_one_frame() {
        frame.trying(1);
        frame.trying(6);
        assertThat(frame.getFrameScore(), is(Score.of(7)));
    }

    @Test
    public void should_send_endMessage_when_Strike_true() {
        frame.trying(10);
        assertThat(frame.isFrameEnd(), is(true));
    }

    @Test
    public void should_send_endMessage_when_Strike_false() {
        frame.trying(0);
        assertThat(frame.isFrameEnd(), is(false));
    }

    @Test
    public void should_send_endMessage_when_try_second_true() {
        frame.trying(1);
        frame.trying(1);
        assertThat(frame.isFrameEnd(), is(true));
    }

    @Test
    public void should_send_strikeMessage_when_Strike_true() {
        frame.trying(10);
        assertThat(frame.isStrike(), is(true));
    }

    @Test
    public void should_send_strikeMessage_when_Strike_false() {
        frame.trying(1);
        assertThat(frame.isStrike(), is(false));
    }

    @Test
    public void should_send_strikeMessage_when_Spare_true() {
        frame.trying(2);
        frame.trying(8);
        assertThat(frame.isSpare(), is(true));
    }

    @Test
    public void should_send_strikeMessage_when_Spare_false() {
        frame.trying(1);
        frame.trying(8);
        assertThat(frame.isSpare(), is(false));
    }

    @Test
    public void toStringTest_when_normal_case() {
        frame.trying(1);
        frame.trying(8);
        assertThat(frame.toString(), is("1|8"));
    }

    @Test
    public void toStringTest_when_normal_spare() {
        frame.trying(3);
        frame.trying(7);
        assertThat(frame.toString(), is("3|/"));
    }

    @Test
    public void toStringTest_when_normal_strike() {
        frame.trying(10);
        assertThat(frame.toString(), is("X  "));
    }
}
