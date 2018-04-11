import domain.BowlingGame;
import domain.Frame;
import org.junit.Test;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

public class BowlingMainTest {
    @Test
    public void autoTest() {
        Scanner scanner = new Scanner("10");
        BowlingGame bowlingGame = new BowlingGame("HTW");
        List<Frame> frames = bowlingGame.createFrame();
        ResultView.printStatus(frames, "HTW", 0);

        for (int index = 0; index < 10; index++) {
            Frame frame = frames.get(index);
            while (!frame.isEnd()) {
                frame.getThrowing(InputView.getThrowing(scanner, frame));
                ResultView.printStatus(frames, "HTW", index);
            }
        }

    }
}
