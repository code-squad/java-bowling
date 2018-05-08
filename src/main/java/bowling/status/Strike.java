package bowling.status;

/**
 * @author sangsik.kim
 */
public class Strike extends FinishedStatus implements Status {

    @Override
    public Status bowl(int pin) {
        throw new IllegalArgumentException("이미 투구를 완료하였습니다.");
    }

    @Override
    public String getScore() {
        return "X";
    }
}
