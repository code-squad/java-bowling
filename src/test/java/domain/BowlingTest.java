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
        assertThat(frame.getScore(), is(7));
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
    public void calculate_total_count_by_2nd_frame_normal_case() {
        Frame firstFrame = new Frame();
        firstFrame.trying(1);
        firstFrame.trying(8);

        Frame secondFrame = new Frame();
        secondFrame.trying(1);
        secondFrame.trying(8);

        secondFrame.updateScore(firstFrame);
        assertThat(secondFrame.getUpdatedScore(), is(18));
    }

    @Test
    public void calculate_total_count_by_2nd_frame_1st_spare_case() {
        Frame firstFrame = new Frame();
        firstFrame.trying(1);
        firstFrame.trying(9);

        Frame secondFrame = new Frame();
        secondFrame.trying(1);
        secondFrame.trying(8);

        secondFrame.updateScore(firstFrame);
        assertThat(secondFrame.getUpdatedScore(), is(20));
    }

    @Test
    public void calculate_total_count_by_2nd_frame_1st_strike_case() {
        Frame firstFrame = new Frame();
        firstFrame.trying(10);

        Frame secondFrame = new Frame();
        secondFrame.trying(1);
        secondFrame.trying(8);

        secondFrame.updateScore(firstFrame);
        assertThat(secondFrame.getUpdatedScore(), is(28));
    }

}
