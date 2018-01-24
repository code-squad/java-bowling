package domain.frame;

import domain.Player;
import domain.TestScoreBoard;
import domain.TestStrategy;
import domain.score.Score;
import domain.score.TotalScore;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NormalFrameTest {

    private TotalScore totalScore;

    private Player testPlayer;

    @Before
    public void setUp() throws Exception {
        totalScore = new TotalScore(new Score(10));
        testPlayer = new Player(new TestStrategy(), new TestScoreBoard());
    }

    @Test
    public void nextFrame_9번째프레임() throws Exception {
        NormalFrame frame = new NormalFrame(totalScore, 9);

        Frame next = frame.nextFrame(totalScore);
        assertThat(next instanceof FinalFrame).isTrue();
    }

    @Test
    public void nextFrame() throws Exception {
        NormalFrame frame = new NormalFrame(totalScore, 8);

        Frame next = frame.nextFrame(totalScore);
        assertThat(next instanceof NormalFrame).isTrue();
    }

    @Test
    public void playNext_첫번째시도후두번째시도() throws Exception {
        NormalFrame frame = new NormalFrame(totalScore, 8);

        Frame next = frame.playNext(testPlayer);
        assertThat(next.totalScore.isSpare()).isTrue();
    }

    @Test
    public void playNextFirstScore_첫번째시도() throws Exception {
        NormalFrame frame = new NormalFrame(totalScore, 8);

        Frame next = frame.playNextFirstScore(testPlayer);
        assertThat(next.totalScore.isSpare()).isFalse();
    }
}