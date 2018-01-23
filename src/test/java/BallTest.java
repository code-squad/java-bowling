import model.Ball;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BallTest {
    private Ball ball;
    @Before
    public void setUp() {
        ball = new Ball(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validNumberCheck() {
        ball = new Ball(11);
    }

    @Test
    public void gutterStringTest() {
        ball = new Ball(0);

        assertThat(ball.toString()).isEqualTo("-");
    }

    @Test
    public void strikeStringTest() {
        ball = new Ball(10);

        assertThat(ball.toString()).isEqualTo("X");
    }
}
