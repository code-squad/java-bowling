package bowling.domain.state;

import bowling.domain.Pin;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MissTest {
    private Miss miss;

    @Before
    public void init() {
        miss = new Miss(new Pin(5), new Pin(3));
    }

    @Test
    public void bowlTest() {
        assertThat(miss.bowlBall(null)).isEqualTo(miss);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(miss.isFrameEnd()).isTrue();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(miss.toFrameView()).isEqualTo("5|3");
    }

    @Test
    public void isCalculableTest() {
        assertThat(miss.isCalculable()).isTrue();
    }
}
