package domain;

import org.junit.Before;
import org.junit.Test;

import static domain.status.CalculateStatus.ADDITION_NOT_COMPLETE;
import static domain.status.CalculateStatus.NOT_YET;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoundTest {

    private Round round;

    @Before
    public void setUp() {
        round = Round.of();
    }

    @Test
    public void should_add_new_Frame_when_appropriate_trying() {
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
    public void should_add_10th_frame_when_9th_frame_end() {
        for (int i = 0; i < 18; i++) {
            round.trying(1);
        }
        assertThat(round.getRoundFrames().get(9), is(LastFrame.of()));
    }

    @Test
    public void should_send_true_message_when_round_end() {
        for (int i = 0; i < 20; i++) {
            round.trying(1);
        }
        assertThat(round.isRoundEnd(), is(true));
    }

    @Test
    public void should_send_false_message_when_round_not_end_() {
        for (int i = 0; i < 19; i++) {
            round.trying(1);
        }
        assertThat(round.isRoundEnd(), is(false));
    }

    @Test
    public void calculate_do_donot_spare_and_spare() {
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(NOT_YET));
    }

    @Test
    public void calculate_do_donot_spare_and_strike() {
        round.trying(1); // 1frame
        round.trying(9); // 1frame
        round.trying(10); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(ADDITION_NOT_COMPLETE));
    }

    @Test
    public void calculate_do_donot_strike_and_strike() {
        round.trying(10); // 1frame
        round.trying(10); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(NOT_YET));
    }

    @Test
    public void calculate_do_donot_strike_and_spare() {
        round.trying(10); // 1frame
        round.trying(1); // 1frame
        round.trying(9); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(NOT_YET));
    }

    @Test
    public void calculate_do_donot_last_frame_case_normal() {
        round.trying(10); // 1frame
        round.trying(10); // 2frame
        round.trying(10); // 3frame
        round.trying(10); // 4frame
        round.trying(10); // 5frame
        round.trying(10); // 6frame
        round.trying(10); // 7frame
        round.trying(10); // 8frame
        round.trying(10); // 9frame
        round.trying(1); // 10frame
        assertThat(round.getRoundFrames().get(9).getCalculateStatus(), is(NOT_YET));
    }

    @Test
    public void calculate_do_donot_last_frame_case_spareBonus() {
        round.trying(10); // 1frame
        round.trying(10); // 2frame
        round.trying(10); // 3frame
        round.trying(10); // 4frame
        round.trying(10); // 5frame
        round.trying(10); // 6frame
        round.trying(10); // 7frame
        round.trying(10); // 8frame
        round.trying(10); // 9frame
        round.trying(1); // 10frame
        round.trying(9); // 10frame
        assertThat(round.getRoundFrames().get(9).getCalculateStatus(), is(NOT_YET));
    }

    @Test
    public void calculate_do_donot_last_frame_case_strikeBonus() {
        round.trying(10); // 1frame
        round.trying(10); // 2frame
        round.trying(10); // 3frame
        round.trying(10); // 4frame
        round.trying(10); // 5frame
        round.trying(10); // 6frame
        round.trying(10); // 7frame
        round.trying(10); // 8frame
        round.trying(10); // 9frame
        round.trying(10); // 10frame
        assertThat(round.getRoundFrames().get(9).getCalculateStatus(), is(NOT_YET));
        round.trying(1); // 10frame
        assertThat(round.getRoundFrames().get(9).getCalculateStatus(), is(NOT_YET));
    }

    @Test
    public void calculate_total_score() {
        round.trying(1);
        round.trying(2);
        assertThat(round.getRoundFrames().get(0).getTotalScore(), is(3));
    }

    @Test
    public void calculate_total_score2() {
        round.trying(1);
        round.trying(2);
        round.trying(3);
        round.trying(4);
        assertThat(round.getRoundFrames().get(1).getTotalScore(), is(10));
    }

    @Test
    public void calculate_total_score3() {
        round.trying(1);
        round.trying(9);
        round.trying(4);
        round.trying(4);
        assertThat(round.getRoundFrames().get(0).getTotalScore(), is(14));
        assertThat(round.getRoundFrames().get(1).getTotalScore(), is(22));
    }

    @Test
    public void calculate_total_score4() {
        round.trying(10);
        round.trying(3);
        round.trying(4);
        assertThat(round.getRoundFrames().get(0).getTotalScore(), is(17));
        assertThat(round.getRoundFrames().get(1).getTotalScore(), is(24));
    }

    @Test
    public void calculate_total_score5() {
        round.trying(10);
        round.trying(10);
        round.trying(4);
        round.trying(4);
        assertThat(round.getRoundFrames().get(0).getTotalScore(), is(28));
        assertThat(round.getRoundFrames().get(1).getTotalScore(), is(46));
        assertThat(round.getRoundFrames().get(2).getTotalScore(), is(54));
    }

    @Test
    public void calculate_total_score6() {
        round.trying(10);
        round.trying(1);
        round.trying(9);
        round.trying(4);
        round.trying(5);
        round.trying(1);
        round.trying(2);
        assertThat(round.getRoundFrames().get(0).getTotalScore(), is(20));
        assertThat(round.getRoundFrames().get(1).getTotalScore(), is(34));
        assertThat(round.getRoundFrames().get(2).getTotalScore(), is(43));
        assertThat(round.getRoundFrames().get(3).getTotalScore(), is(46));
    }

    @Test
    public void calculate_total_score7() {
        round.trying(1);
        round.trying(3);
        round.trying(10);
        round.trying(10);
        round.trying(10);
        round.trying(2);
        round.trying(3);
        assertThat(round.getRoundFrames().get(0).getTotalScore(), is(4));
        assertThat(round.getRoundFrames().get(1).getTotalScore(), is(34));
        assertThat(round.getRoundFrames().get(2).getTotalScore(), is(59));
        assertThat(round.getRoundFrames().get(3).getTotalScore(), is(74));
        assertThat(round.getRoundFrames().get(4).getTotalScore(), is(79));
    }

    @Test
    public void calculate_total_score_perfectGame() {
        for (int i = 0; i < 12; i++) {
            round.trying(10);
        }
        assertThat(round.getRoundFrames().get(9).getTotalScore(), is(300));
    }

}
