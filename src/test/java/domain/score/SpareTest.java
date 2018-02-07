package domain.score;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpareTest {

    private State spare;

    @Before
    public void setUp() throws Exception {
        spare = new Spare(new Pin(7), new Pin(3));
    }

    @Test
    public void getTotalScore() throws Exception {
        assertThat(spare.getTotalScore().isPresent()).isFalse();
    }

    @Test
    public void getTotalScore_X() throws Exception {
        spare.bowl(Pin.TEN);
        assertThat(spare.getTotalScore().isPresent()).isTrue();
        assertThat(spare.getTotalScore().get()).isEqualTo(20);

    }

    @Test
    public void getTotalScore_7() throws Exception {
        spare.bowl(new Pin(7));
        assertThat(spare.getTotalScore().isPresent()).isTrue();
        assertThat(spare.getTotalScore().get()).isEqualTo(17);
    }

    @Test(expected = IllegalStateException.class)
    public void getTotalScore_더이상bowl할수없는경우() throws Exception {
        spare.bowl(new Pin(7));
        spare.bowl(new Pin(7));
    }
}