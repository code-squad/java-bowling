import domain.Player;
import view.InputView;

public class BowlingMain {

    public static void main(String[] args) {
        Player player = InputView.getPlayer();

        //Frames가 Player를 가지고 있을 것인지, Player가 Frames를 가지고 있을 것인지
        //받아온 점수를 프레임즈에 전달해서 스코어 add해주기, 예외가 발생했을 경우 add되지않고 프로세스 다시 진행되도록 하기
    }
}
