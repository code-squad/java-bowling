package bowling.domain.state;

import bowling.domain.Pin;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpareTest {
    private Spare spare;

    @Before
    public void init() {
        spare = new Spare(new Pin(8), new Pin(2));
    }

    @Test
    public void bowlTest() {
        assertThat(spare.bowlBall(null)).isEqualTo(spare);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(spare.isFrameEnd()).isTrue();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(spare.toFrameView()).isEqualTo("8|/");
    }
}
