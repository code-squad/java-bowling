import domain.Player;
import view.InputView;

import static view.InputView.getPinNum;

/*
    1. 사용자정의예외로 바꿀 것 : RuntimeException
    2. 점수판 출력 만들기
    3. Frames 없애고 진행해보기 : Frames 없이 nextFrame에 요청하는 방식으로 이뤄지는건가?
 */
public class BowlingMain {

    public static void main(String[] args) {
        Player player = InputView.getPlayer();
        while (!player.isFinish()) {
            doGame(player);
        }
    }

    private static void doGame(Player player) {
        try {
            player.roll(getPinNum(player.getCurrentFrameNum()));
            /*
                FrameResults results = player.makeResults();
                OutputView.printResult(results); 결과 객체를 넘겨야해
            */
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            doGame(player);
        }
    }
}
