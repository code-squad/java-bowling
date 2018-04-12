package domain;

import org.junit.Before;
import org.junit.Test;

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
        assertThat(round.getRoundFrames().get(9), is(LastFrame.of()));
    }

    @Test
    public void should_send_true_message_when_round_end() {
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
        round.trying(10); // 10th frame add, strike
        round.trying(10); // 10th frame add, strike, bonus 1
        round.trying(10); // 10th frame add, strike, bonus 2, frame end, round end
        assertThat(round.isRoundEnd(), is(true));
    }

    @Test
    public void should_send_false_message_when_round_not_end_() {
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
        round.trying(10); // 10th frame add, strike
        round.trying(10); // strike, bonus 1, not round end
        assertThat(round.isRoundEnd(), is(false));
    }

    @Test
    public void calculate_do_donot_no_spare_strike() {
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DO));
    }

    @Test
    public void calculate_do_donot_spare() {
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(9); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
    }

    @Test
    public void calculate_do_donot_strike() {
        round.trying(10); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
    }

    @Test // 수정해야함.
    public void calculate_do_donot_strike_and_normal() {
        round.trying(10); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(2); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DO));
    }

    @Test
    public void calculate_do_donot_spare_and_normal() {
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(9); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(1); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(5); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DO));
    }

    @Test
    public void calculate_do_donot_spare_and_spare() {
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(9); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(2); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(8); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DONOT));
    }

    @Test
    public void calculate_do_donot_spare_and_strike() {
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DO));
        round.trying(9); // 2frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(10); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DONOT));
    }

    @Test
    public void calculate_do_donot_strike_and_strike() {
        round.trying(10); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(10); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
    }

    @Test
    public void calculate_do_donot_strike_and_spare() {
        round.trying(10); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(1); // 1frame
        assertThat(round.getRoundFrames().get(0).getCalculateStatus(), is(CalculateStatus.DONOT));
        round.trying(9); // 2frame
        assertThat(round.getRoundFrames().get(1).getCalculateStatus(), is(CalculateStatus.DONOT));
    }
}
