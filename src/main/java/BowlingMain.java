import domain.frame.Frames;
import domain.Player;
import view.InputView;

public class BowlingMain {

    public static void main(String[] args) {
        //Frames가 Player를 가지고 있을 것인지, Player가 Frames를 가지고 있을 것인지 아니면 꼭 가져있어야하나
        Player player = InputView.getPlayer();
        Frames frames = new Frames();
        while (!frames.isFinish()) {
            doGame(frames);
        }
    }

    public static void doGame(Frames frames) {
        try {
            int score = InputView.getScore(frames.getCurrentFrameNum());
            frames.recordScore(score);
        } catch (IllegalArgumentException e) {
            doGame(frames);
        }
    }
}
