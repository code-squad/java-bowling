import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import score.Playing;

public class PlayingTest {
    private Playing playing;

    @Before
    public void setUp() {
        playing = new Playing();
    }

    @Test
    public void 첫번째투구() {
        int num = playing.shot(6);
        assertEquals(6, num);
    }

    @Test
    public void 스트라이크() {
        int num = playing.shot(10);
        assertEquals(10, num);
    }

    @Test
    public void 두번째투구() {
        int num = playing.secondshot(6, 3);
        assertEquals(3, num);
    }

    @Test
    public void 스페어() {
        int num = playing.secondshot(7, 3);
        assertEquals(3, num);
    }
}
