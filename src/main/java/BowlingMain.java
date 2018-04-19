import domain.Frame;
import domain.NormalFrame;
import domain.Player;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingMain {
    public static void main(String[] args) {
        final int MAX_FRAME_NO = 10;

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(InputView.getUserName(scanner));
        List<Frame> frames = new ArrayList<>();
        ResultView.printFrames(frames, player.getName());

        Frame frame = new NormalFrame(1);
        frames.add(frame);
        for (int index = 1; index < MAX_FRAME_NO + 1; index++) {
            do {
                frame.throwing(InputView.getThrowing(scanner, index));
                ResultView.printFrames(frames, player.getName());
            } while (!frame.isEnd());
            if (index != MAX_FRAME_NO) {
                frame.createScore(); // 다음 프레임이 생성되기 전 호출
                frame = frame.next();
                frames.add(frame);
            }
        }
    }
}