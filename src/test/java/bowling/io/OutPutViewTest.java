package bowling.io;

import bowling.domain.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutPutViewTest {
    @Test
    public void name() {
        OutPutView.printScoreSheetGuideLine();
        OutPutView.printPlayerScoreSheet(new Player(new Name("abc"), new ScoreSheet()));
    }
}