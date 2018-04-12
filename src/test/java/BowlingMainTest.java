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
        final int UNPLAYED = -99;
        Scanner scanner = new Scanner("10");

        List<Frame> frames = Arrays.asList(new NormalFrame(1, 9,1 ),
                new NormalFrame(2, 8, 2),
                new NormalFrame(3, 7, 3),
                new NormalFrame(4, 6, 4),
                new NormalFrame(5, 5, 5),
                new NormalFrame(6, 4, 6),
                new NormalFrame(7, 3, 7),
                new NormalFrame(8, 2, 8),
                new NormalFrame(9, 1, 9),
                new LastFrame(10));

        ResultView.printStatus(frames, "HTW", 0);
        Frame frame = frames.get(9);
        while (!frame.isEnd()) {
            frame.getThrowing(InputView.getThrowing(scanner, frame));
            ResultView.printStatus(frames, "HTW", 10);
        }
    }
}
