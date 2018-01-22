package domain.frame;

import domain.CustomPlayStrategy;
import domain.Player;
import domain.Referee;
import domain.ScoreBoard;
import domain.score.FirstScore;
import domain.score.SecondScore;
import domain.score.TotalScore;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusFrameTest {

    private Referee referee;

    private ScoreBoard scoreBoard;

    @Before
    public void setUp() throws Exception {
        scoreBoard = new ScoreBoard(new Player("TEST"));
        referee = new Referee(new CustomPlayStrategy(new FirstScore(3),
                                                     new SecondScore(3, 7)), scoreBoard);
    }

    @Test
    public void playNextFrame_1번째보너스프레임STRIKE() throws Exception {
        TotalScore totalScore = new TotalScore(new FirstScore(10));
        BonusFrame bonusFrame = new BonusFrame(totalScore, 11);

        assertThat(bonusFrame.playNextFrame(referee).isPresent()).isTrue();
        Frame nextFrame = bonusFrame.playNextFrame(referee).get();
        assertThat(nextFrame.totalScore.isNeedAdditionalScore()).isTrue();
    }

    @Test
    public void playNextFrame_1번째보너스프레임SPARE() throws Exception {
        TotalScore totalScore = new TotalScore(5, 5);
        BonusFrame bonusFrame = new BonusFrame(totalScore, 11);

        assertThat(bonusFrame.playNextFrame(referee).isPresent()).isTrue();
        Frame nextFrame = bonusFrame.playNextFrame(referee).get();
        assertThat(nextFrame.totalScore.isNeedAdditionalScore()).isFalse();
    }

    @Test
    public void playNextFrame_1번째보너스프레임MISS() throws Exception {
        TotalScore totalScore = new TotalScore(4, 5);
        BonusFrame bonusFrame = new BonusFrame(totalScore, 11);

        assertThat(bonusFrame.playNextFrame(referee).isPresent()).isFalse();
    }

    @Test
    public void playNextFrame_2번째보너스프레임은더이상진행하지않음() throws Exception {
        BonusFrame bonusFrame = new BonusFrame(new TotalScore(new FirstScore(10)), 12);

        assertThat(bonusFrame.playNextFrame(referee).isPresent()).isFalse();
    }
}