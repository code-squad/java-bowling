package domain.frame;

public interface Frame {
    /*
    TODO
    - TotalScore 만들기 : 횟수가 주어지고, 그만큼 채워나가는데 채워나가는건 각 프레임이 어떻게 채울건지는 알아서
 */
    String addScore(int score) throws IllegalArgumentException;

    boolean isFinish();

    String convertScore(int score);
}
