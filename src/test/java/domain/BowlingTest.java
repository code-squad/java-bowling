package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest {

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
    public void should_send_frameChange_message_when_appropriate_trying() {
        Round round = new Round();
        round.trying(1);
        round.trying(5); // frame end
        round.trying(6); // new frame add
        round.trying(0); // frame end
        round.trying(3); // new frame add
        round.trying(7); // spare, frame end
        round.trying(10); // new frame add, strike, frame end
        assertThat(round.getRoundFrames().size(), is(5));
    }
}
