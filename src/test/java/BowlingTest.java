import org.junit.Test;

import bowling.BowlingUser;
import bowling.BowlingUtils;
import bowling.GameView;
import bowling.Input;
import bowling.Output;
import bowling.Score;

import static bowling.BowlingUtils.MIN_SCORE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingTest {

    @Test
    public void 플레이어_이름이_세글자일때_대문자로_변환되는가() {
        String originalName = "kyj";
        String upperName = "KYJ";
        BowlingUser bowlingUser = BowlingUser.registed(Input.generate(originalName).getName());

        assertEquals(upperName, bowlingUser.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_이름이_세글자가_아닐때_에러를_발생시키는가() {
        BowlingUser.registed(Input.generate("dddo").getName());
    }

    @Test
    public void 입력된_점수가_1부터_10사이인가() {
        Score score1 = Score.in(Input.generate("3").getScore());
        assertTrue((MIN_SCORE <= score1.get()) && (score1.get() <= BowlingUtils.MAX_SCORE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력된_점수가_1부터_10사이가_아닐때_에러를_발생시키는가() {
        Score score2 = Score.in(Input.generate("11").getScore());
        assertFalse(MIN_SCORE <= score2.get() && score2.get() <= BowlingUtils.MAX_SCORE);
    }

    @Test
    public void 기본_라인_표기가_올바른가() {
        assertEquals("|  NAME  |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |", Output.topLine());
    }

    @Test
    public void 이름을_입력받고_초기_게임화면이_올바르게_생성되는가() {
        BowlingUser bowlingUser = BowlingUser.registed(Input.generate("kyj").getName());
        assertEquals("|  KYJ  |      |      |      |      |      |      |      |      |      |      |", GameView.generate(bowlingUser).get());
    }

    @Test
    public void 입력받은_점수에_따른_반환값이_올바른가() {

    }

    @Test
    public void 다음_라운드가_존재하는가() {

    }

    @Test
    public void 하나의_프레임에서_두번칠_경우_더한_값이_10이하인가() {

    }
}
