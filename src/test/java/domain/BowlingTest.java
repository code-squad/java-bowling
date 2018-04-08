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
    public void should_add_new_Frame_when_appropriate_trying() {
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

    @Test
    public void should_add_10th_frame_when_10th_turn() {
        Round round = new Round();
        round.trying(1); // game start 1st frame
        round.trying(2); // frame end
        round.trying(4); // 2nd frame add
        round.trying(6); // frame end, spare
        round.trying(10); // 3rd frame add, strike, frame end
        round.trying(10); // 4th frame add, strike, frame end
        round.trying(10); // 5th frame add, strike, frame end
        round.trying(10); // 6th frame add, strike, frame end
        round.trying(10); // 7th frame add, strike, frame end
        round.trying(10); // 8th frame add, strike, frame end
        round.trying(10); // 9th frame add, strike, frame end
        assertThat(round.getRoundFrames().get(9), is(new LastFrame()));
    }
}
