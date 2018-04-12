import domain.Player;
import domain.frame.Frame;
import view.InputView;

import static view.InputView.getPinNum;

public class BowlingMain {

    public static void main(String[] args) {
        Player player = InputView.getPlayer();
        while (!player.isFinish()) {
            doGame(player);
        }
    }

    private static void doGame(Player player) {
        try {
            //결과 가져가야해
            player.roll(getPinNum(player.getCurrentFrameNum()));


            //OutputView.printResult(player); 여긴 결과 객체를 넘겨야해 : 결과 원천 데이터 저장 객체와 결과 저장 객체는 달라야해
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            doGame(player);
        }
    }
}
