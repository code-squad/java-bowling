package bowling.domain;

import bowling.domain.Score.Roll;
import bowling.domain.frame.FinalFrame;
import bowling.domain.number.Pins;
import bowling.io.OutPutView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FinalFrameTest {
    @Test
    public void 프레임_준비_Final_Score_스패어_거터_2개_까지만_add() {
        FinalFrame strike = new FinalFrame().add(new Roll(new Pins(10)));
        assertEquals(OutPutView.frameFormat("X"), strike.toString());
        FinalFrame strikeStrike = strike.add(new Roll(new Pins(10)));
        assertEquals(OutPutView.frameFormat("X|X"), strikeStrike.toString());
        FinalFrame strikeStrikeStrike = strike.add(new Roll(new Pins(10)));
        assertEquals(OutPutView.frameFormat("X|X|X"), strikeStrikeStrike.toString());

        FinalFrame gutter = new FinalFrame().add(new Roll(new Pins(0)));
        FinalFrame gutterSpare = gutter.add(new Roll(new Pins(10)));
        assertEquals(OutPutView.frameFormat("-|/"), gutterSpare.toString());
        FinalFrame gutterSpareGutter = gutterSpare.add(new Roll(new Pins(0)));
        assertEquals(OutPutView.frameFormat("-|/|-"), gutterSpareGutter.toString());

        FinalFrame two = new FinalFrame().add(new Roll(new Pins(2)));
        FinalFrame twoSpare = two.add(new Roll(new Pins(8)));
        assertEquals(OutPutView.frameFormat("2|/"), twoSpare.toString());
        FinalFrame twoSpareEight = twoSpare.add(new Roll(new Pins(8)));
        assertEquals(OutPutView.frameFormat("2|/|8"), twoSpareEight.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 프레임_준비_Final_Score_Strike_add_스패어가_아닐시_보너스_지급_없음() {
        FinalFrame strike = new FinalFrame().add(new Roll(new Pins(10)));
        assertEquals(OutPutView.frameFormat("X"), strike.toString());
        FinalFrame strikeStrike = strike.add(new Roll(new Pins(0)));
        assertEquals(OutPutView.frameFormat("X|-"), strikeStrike.toString());
        FinalFrame illegalArgumentException = strike.add(new Roll(new Pins(10)));
    }
}