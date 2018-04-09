package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest {

    @Test
    public void should_send_true_message_when_round_end() {
        Round round = Round.of();
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
        Round round = Round.of();
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

}
