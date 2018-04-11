import domain.BowlingGame;
import domain.Frame;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

public class BowlingMain {
    private static final int MAX_FRAME_NO = 10;
    private static final int UNPLAYED = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = InputView.getName(scanner);

        BowlingGame bowlingGame = new BowlingGame(name);
        List<Frame> frames = bowlingGame.createFrame();
        ResultView.printStatus(frames, name, UNPLAYED);

        for (int index = 1; index <= MAX_FRAME_NO; index++) {
            Frame frame = frames.get(index-1);
            while (!frame.isEnd()) {
                frame.getThrowing(InputView.getThrowing(scanner, frame));
                ResultView.printStatus(frames, name, index);
            }
        }
        scanner.close();
    }
}
