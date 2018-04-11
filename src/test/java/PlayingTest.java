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
    public void 랜덤숫자생성() {
        assertNotNull(playing.makeRandomNum());
    }
    @Test
    public void 첫번째투구() {
        playing.shot(playing.makeRandomNum());
    }

    @Test
    public void 스트라이크() {
        playing.shot(10);
    }

    @Test
    public void 두번째투구() {
        playing.secondshot(3);
    }

    @Test
    public void 스페어() {
        playing.secondshot(10);
    }
}
