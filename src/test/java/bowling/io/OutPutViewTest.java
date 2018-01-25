package bowling.io;

import bowling.domain.*;
import bowling.domain.frame.ScoreSheet;
import org.junit.Test;

public class OutPutViewTest {
    @Test
    public void name() {
        Player abc = new Player(new Name("abc"), new ScoreSheet());
        play(abc);
        Player zxc = new Player(new Name("zxc"), new ScoreSheet());
        play(zxc);
    }

    private void play(Player player) {
        OutPutView.printScoreSheetGuideLine();
        OutPutView.printPlayerScoreSheet(player);
        System.out.println();
        while(player.needToRoll()) {
            player.roll();
            OutPutView.printScoreSheetGuideLine();
            OutPutView.printPlayerScoreSheet(player);
            System.out.println();
        }
    }
}