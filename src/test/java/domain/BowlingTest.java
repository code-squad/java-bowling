package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest {

    @Test
    public void calculate_total_score_by_1_frame() {
        Frame frame = new Frame();
        int first = 10;
        int second = 2;
        int total = 10;
        frame.tryInning(first, second);
        assertThat(frame.totalScore(), is(total));
    }


}
