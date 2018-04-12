import domain.BowlingGame;
import domain.Frame;
import domain.LastFrame;
import domain.NormalFrame;
import org.junit.Test;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BowlingMainTest {
    @Test
    public void autoTest() {
        final int UNPLAYED = -1;

        List<Frame> frames = Arrays.asList(new NormalFrame(10, UNPLAYED, 1),
                new NormalFrame(10, UNPLAYED, 2),
                new NormalFrame(0, 7, 3),
                new NormalFrame(4, 0, 4),
                new NormalFrame(5, 5, 5),
                new NormalFrame(10, UNPLAYED, 6),
                new NormalFrame(7, 3, 7),
                new NormalFrame(8, 2, 8),
                new NormalFrame(9, 1, 9),
                new LastFrame(1, 3, 10, 10));

        ResultView.printStatus(frames, "HTW", 0);
        ResultView.printStatus(frames, "HTW", 10);
    }
}
