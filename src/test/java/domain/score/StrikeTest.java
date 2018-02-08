package domain.score;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StrikeTest {

    private State strike;

    @Before
    public void setUp() throws Exception {
        strike = new Strike();
    }

    @Test
    public void toString_STRIKE() throws Exception {
        assertThat(strike.toString()).isEqualTo("X");
    }

    @Test
    public void getTotalScore_XXX() {
        strike.bowl(Pin.TEN);
        strike.bowl(Pin.TEN);
        assertThat(strike.getTotalScore().isPresent()).isTrue();
        assertThat(strike.getTotalScore().get()).isEqualTo(30);
    }

    @Test
    public void getTotalScore_SPARE() {
        strike.bowl(new Pin(3));
        strike.bowl(new Pin(7));
        assertThat(strike.getTotalScore().isPresent()).isTrue();
        assertThat(strike.getTotalScore().get()).isEqualTo(20);
    }

    @Test
    public void getTotalScore_MISS() {
        strike.bowl(new Pin(3));
        strike.bowl(new Pin(2));
        assertThat(strike.getTotalScore().isPresent()).isTrue();
        assertThat(strike.getTotalScore().get()).isEqualTo(15);
    }

    @Test(expected = IllegalStateException.class)
    public void getTotalScore_더이상bowl할수없는경우() {
        strike.bowl(new Pin(3));
        strike.bowl(new Pin(2));
        strike.bowl(new Pin(2));
    }

    @Test
    public void getTotalScore_XX() {
        strike.bowl(Pin.TEN);
        assertThat(strike.getTotalScore().isPresent()).isFalse();
    }
}