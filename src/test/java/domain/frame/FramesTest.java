package domain.frame;

import domain.score.Pin;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FramesTest {

    private Frames frames;

    private NormalFrame spare;

    private NormalFrame strike;

    private NormalFrame miss;

    @Before
    public void setUp() throws Exception {
        frames = new Frames();

        spare = new NormalFrame(new Pin(8));
        spare.bowl(new Pin(2));

        strike = new NormalFrame(new Pin(10));

        miss = new NormalFrame(new Pin(7));
        miss.bowl(new Pin(2));
    }

    @Test
    public void getUpdateScoreResult_스트라이크후첫번째시도() throws Exception {
        frames.updateFrame(strike);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |");

        frames.updateFrame(new NormalFrame(new Pin(7)));
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |");
    }

    @Test
    public void getUpdateScoreResult_스트라이크후미스() throws Exception {
        frames.updateFrame(strike);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |");

        frames.updateFrame(miss);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |19  |28  |");
    }

    @Test
    public void getUpdateScoreResult_스트라이크후스페어() throws Exception {
        frames.updateFrame(strike);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |");

        frames.updateFrame(spare);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |20  |");
    }

    @Test
    public void getUpdateScoreResult_스트라이크후스페어후첫번째시도() throws Exception {
        frames.updateFrame(strike);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |");

        frames.updateFrame(spare);
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |20  |");

        frames.updateFrame(new NormalFrame(new Pin(7)));
        assertThat(frames.getUpdateScoreResult()).isEqualTo("|      |20  |37  |");

    }
}