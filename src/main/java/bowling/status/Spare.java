package bowling.status;

/**
 * @author sangsik.kim
 */
public class Spare implements Status {
    private int first;
    private int second;

    public Spare(int first, int second) {
        if (first + second > 10) {
            throw new IllegalArgumentException("쓰러진 핀의 갯수가 올바르지 않습니다.");
        }
        this.first = first;
        this.second = second;
    }

    @Override
    public Status bowl(int pin) {
        throw new IllegalArgumentException("이미 투구를 완료하였습니다.");
    }

    @Override
    public String getScore() {
        return this.first == 0 ? "-|/" : this.first + "|/";
    }
}
