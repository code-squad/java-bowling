package domain.frame;

import domain.Player;
import domain.TestScoreBoard;
import domain.TestStrategy;
import domain.score.Score;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalFrameTest {

    private Player testPlayer;

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        testPlayer = new Player("KKJ", new TestStrategy());
        game = new BowlingGame(testPlayer, new TestScoreBoard());
    }

    @Test
    public void playNextFrame_10번째프레임_스트라이크() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new Score(new Score(10)), 10);

        Optional<Frame> next = finalFrame.playNextFrame(game);
        assertThat(next.isPresent()).isTrue();
        assertThat(next.get().frameNo).isEqualTo(11);
        assertThat(next.get().score.isSpare()).isTrue();
    }

    @Test
    public void playNextFrame_10번째프레임_스페어() throws Exception {
        Score t = new Score(new Score(7));
        t.addSecond(new Score(3));
        FinalFrame finalFrame = new FinalFrame(t, 10);

        Optional<Frame> next = finalFrame.playNextFrame(game);
        assertThat(next.isPresent()).isTrue();
        assertThat(next.get().frameNo).isEqualTo(11);
        assertThat(next.get().score.isSpare()).isFalse();
    }

    @Test
    public void playNextFrame_12번째프레임_스트라이크() throws Exception {
        FinalFrame finalFrame = new FinalFrame(new Score(new Score(10)), 12);

        Optional<Frame> next = finalFrame.playNextFrame(game);
        assertThat(next.isPresent()).isFalse();
    }

}