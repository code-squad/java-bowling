import bowling.domain.Ball;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BallTest {

    @Test(expected = IllegalArgumentException.class)
    public void underPinExceptionTest() {
        Ball test = new Ball(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overPinExceptionTest() {
        Ball test = new Ball(-1);
    }

    @Test
    public void isStrikeTest() {
        Ball test = new Ball(10);
        assertThat(test.isStrike(), is(true));
    }

    @Test
    public void isSpareTest() {
        Ball test = new Ball(5);
        Ball test2 = new Ball(5);
        assertThat(test.isSpare(test2), is(true));
    }
}