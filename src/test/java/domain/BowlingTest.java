package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest {

    @Test
    public void calculate_total_score_by_1_frame() {
        Frame frame = new Frame();
        frame.putFisrtTryPoint(4);
        frame.putFisrtTryPoint(1);
        assertThat(frame.totalNumber(), is(5));
    }
}
