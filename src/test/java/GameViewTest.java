import bowling.domain.BowlingUser;
import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;
import bowling.view.GameView;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals("|  KYJ  |  X   |", gameView.reflectView(frame));
    }

    @Test
    public void 미스일때_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(0)));
        assertEquals("|  KYJ  |  -   |", gameView.reflectView(frame));
    }

    @Test
    public void 숫자일때_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(4)));
        assertEquals("|  KYJ  |  4   |", gameView.reflectView(frame));
    }

    @Test
    public void 스페어일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(3)));
        gameView.reflectView(frame);
        assertEquals("|  KYJ  |  3|/ |", gameView.reflectView(frame.nextRound(Score.in(of(7)))));
    }

    @Test
    public void 두번쨰_숫자입력까지_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(4)));
        gameView.reflectView(frame);
        assertEquals("|  KYJ  |  4|4 |", gameView.reflectView(frame.nextRound(Score.in(of(4)))));
    }

    @Test
    public void 첫번쨰_미스일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(0)));
        gameView.reflectView(frame);
        assertEquals("|  KYJ  |  -|4 |", gameView.reflectView(frame.nextRound(Score.in(of(4)))));
    }

    @Test
    public void 두번쨰_미스일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(4)));
        gameView.reflectView(frame);
        assertEquals("|  KYJ  |  4|- |", gameView.reflectView(frame.nextRound(Score.in(of(0)))));
    }

    @Test
    public void 거터일떄_뷰가_올바른가() {
        NormalFrame frame = NormalFrame.generate(Score.in(of(0)));
        gameView.reflectView(frame);
        assertEquals("|  KYJ  |  -|- |", gameView.reflectView(frame.nextRound(Score.in(of(0)))));
    }

    @Test
    public void frame_리스트로_연속된_뷰를_그리는가() {
        NormalFrame frame1 = NormalFrame.generate(Score.in(of(10)));
        assertEquals("|  KYJ  |  X   |", gameView.reflectView(frame1));
        NormalFrame frame2 = NormalFrame.generate(Score.in(of(10)));
        assertEquals("|  KYJ  |  X   |  X   |", gameView.reflectView(frame2));
    }

    @Test
    public void 파이널_프레임에서_뷰가_올바른가() {
        FinalFrame frame = FinalFrame.generate(Score.in(of(10)));
        assertEquals("  X   |", gameView.reflectFinalView(frame));
    }

    @Test
    public void 파이널_프레임에서_연속된_뷰가_올바른가() {
        FinalFrame frame = FinalFrame.generate(Score.in(of(10)));
        assertEquals("  X   |", gameView.reflectFinalView(frame));
        assertEquals("  X|X |", gameView.reflectFinalView(frame.nextRound(Score.in(of(10)))));
    }

    @Test
    public void 파이널_프레임에서_연속된_뷰가_올바른가2() {
        FinalFrame frame = FinalFrame.generate(Score.in(of(10))); //finalScoreType 생성?
        assertEquals("  X   |", gameView.reflectFinalView(frame));
        assertEquals("  X|4 |", gameView.reflectFinalView(frame.nextRound(Score.in(of(4)))));
    }
}
