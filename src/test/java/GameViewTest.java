import org.junit.Before;
import org.junit.Test;

import bowling.domain.BowlingUser;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;
import bowling.view.GameView;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;

public class GameViewTest {
    private GameView gameView;

    @Before
    public void init() {
        gameView = GameView.generate(BowlingUser.registed(of("kyj")));
    }
    @Test
    public void 스트라이크일때_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(10)));
        assertEquals("|  KYJ  |  X   |", gameView.firstReflectScore(frame));
    }

    @Test
    public void 미스일때_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(0)));
        assertEquals("|  KYJ  |  -   |", gameView.firstReflectScore(frame));
    }

    @Test
    public void 숫자일때_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(4)));
        assertEquals("|  KYJ  |  4   |", gameView.firstReflectScore(frame));
    }

    @Test
    public void 스페어일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(3)));
        gameView.firstReflectScore(frame);
        assertEquals("|  KYJ  |  3|/ |", gameView.nextReflectScore(frame.nextRound(Score.in(of(7)))));
    }

    @Test
    public void 두번쨰_숫자입력까지_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(4)));
        gameView.firstReflectScore(frame);
        assertEquals("|  KYJ  |  4|4 |", gameView.nextReflectScore(frame.nextRound(Score.in(of(4)))));
    }

    @Test
    public void 첫번쨰_미스일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(0)));
        gameView.firstReflectScore(frame);
        assertEquals("|  KYJ  |  -|4 |", gameView.nextReflectScore(frame.nextRound(Score.in(of(4)))));
    }

    @Test
    public void 두번쨰_미스일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(4)));
        gameView.firstReflectScore(frame);
        assertEquals("|  KYJ  |  4|- |", gameView.nextReflectScore(frame.nextRound(Score.in(of(0)))));
    }

    @Test
    public void 거터일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(0)));
        gameView.firstReflectScore(frame);
        assertEquals("|  KYJ  |  -|- |", gameView.nextReflectScore(frame.nextRound(Score.in(of(0)))));
    }
}
