package domain.score;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FirstBowlTest {
    private FirstBowl firstBowl;

    @Before
    public void setUp() throws Exception {
        firstBowl = new FirstBowl(new Pin(7));
    }

    @Test
    public void bowl_스페어인경우() throws Exception {
        State state = firstBowl.bowl(new Pin(3));
        assertThat(state.getType() == PinType.SPARE).isTrue();
    }

    @Test
    public void bowl_스페어가아닌경우() throws Exception {
        State state = firstBowl.bowl(new Pin(2));
        assertThat(state.getType() == PinType.SPARE).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void bowl_10이넘는경우() throws Exception {
        firstBowl.bowl(new Pin(4));
    }
}