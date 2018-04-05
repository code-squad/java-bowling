import domain.Frames;
import domain.Player;
import view.InputView;

public class BowlingMain {

    public static void main(String[] args) {
        //Frames가 Player를 가지고 있을 것인지, Player가 Frames를 가지고 있을 것인지 아니면 꼭 가져있어야하나
        Player player = InputView.getPlayer();
        Frames frames = new Frames();
        while (!frames.isFinish()) {
            //여기를 메소드로 변경해서 try - catch문 분리할 수 있겠음
            int score = InputView.getScore(frames.getTurnNumber());
            frames.recordScore(score);
        }

    }
}
