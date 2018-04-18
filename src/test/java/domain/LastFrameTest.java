package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LastFrameTest {

    private Frame lastFrame;

    @Before
    public void setUp() {
        lastFrame = LastFrame.of();
    }

    @Test
    public void frameEnd() {
        lastFrame.trying(3);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd2() {
        lastFrame.trying(3);
        lastFrame.trying(3);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void frameEnd3() {
        lastFrame.trying(4);
        lastFrame.trying(6);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd4() {
        lastFrame.trying(10);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd5() {
        lastFrame.trying(10);
        lastFrame.trying(1);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd6() {
        lastFrame.trying(4);
        lastFrame.trying(6);
        lastFrame.trying(6);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void frameEnd7() {
        lastFrame.trying(10);
        lastFrame.trying(6);
        lastFrame.trying(4);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void frameEnd8() {
        lastFrame.trying(10);
        lastFrame.trying(10);
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd9() {
        lastFrame.trying(10);
        lastFrame.trying(10);
        lastFrame.trying(10);
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

//
//    @Test
//    public void last_frame_should_send_end_message_when_try_second_and_no_bonus() {
//        lastFrame.trying(1);
//        lastFrame.trying(3);
//        assertThat(lastFrame.isFrameEnd(), is(true));
//    }
//
//    @Test
//    public void should_send_not_end_when_spare_at_last_frame() {
//        lastFrame.trying(3);
//        lastFrame.trying(7);
//        assertThat(lastFrame.isFrameEnd(), is(false));
//    }
//
//    @Test
//    public void should_send_not_end_when_strike_at_last_frame_1() {
//        lastFrame.trying(10);
//        assertThat(lastFrame.isFrameEnd(), is(false));
//    }
//
//    @Test
//    public void should_send_not_end_when_strike_at_last_frame_2() {
//        lastFrame.trying(10);
//        lastFrame.trying(10);
//        assertThat(lastFrame.isFrameEnd(), is(false));
//    }
//
//    @Test
//    public void should_send_end_when_after_3_sequence_strike() {
//        lastFrame.trying(10);
//        lastFrame.trying(10);
//        lastFrame.trying(10);
//        assertThat(lastFrame.isFrameEnd(), is(true));
//    }
//
//    @Test
//    public void should_send_end_when_after_spare_and_one_try_bonus() {
//        lastFrame.trying(3);
//        lastFrame.trying(7);
//        lastFrame.trying(10);
//        assertThat(lastFrame.isFrameEnd(), is(true));
//    }
//
//    @Test
//    public void should_return_right_Frame_score_toString_Turkey() {
//        lastFrame.trying(10);
//        lastFrame.trying(10);
//        lastFrame.trying(10);
//        assertThat(lastFrame.toString(), is("X|X|X"));
//    }
//
//    @Test
//    public void should_return_right_Frame_score_toString_normal() {
//        lastFrame.trying(2);
//        lastFrame.trying(3);
//        assertThat(lastFrame.toString(), is("2|3|"));
//    }
//
//    @Test
//    public void should_return_right_Frame_score_toString_Turkey_spareBonus1() {
//        lastFrame.trying(5);
//        lastFrame.trying(5);
//        lastFrame.trying(10);
//        assertThat(lastFrame.toString(), is("5|/|X"));
//    }
//
//    @Test
//    public void should_return_right_Frame_score_toString_Turkey_spareBonus2() {
//        lastFrame.trying(5);
//        lastFrame.trying(5);
//        lastFrame.trying(0);
//        assertThat(lastFrame.toString(), is("5|/|-"));
//    }
//
//    @Test
//    public void should_return_right_Frame_score_toString_Turkey_spareBonus() {
//        lastFrame.trying(5);
//        lastFrame.trying(5);
//        lastFrame.trying(2);
//        assertThat(lastFrame.toString(), is("5|/|2"));
//    }
}
