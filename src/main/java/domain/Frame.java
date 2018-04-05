package domain;

public class Frame {
    private Scores scores = new Scores();

    /* 점수기록들을 add하면서 리턴할 수도 있음 */
    public void addScore(int score) throws IllegalArgumentException {
        scores.addScore(score);

        if (isFinish()) {
            // Frame 상태 변경이 들어가야함 Scores 체크해보고(2가지 - 10점인가 아니면 2개 충족되었나
            //물어보고 상태변경하도록 명령할 것인가? 아니면 알아서 체크해서 상태변경할건가?
        }
    }

    /* Frame 상태 넣어주기 */
    public boolean isFinish() {
        return scores.isLimitSize();
    }
}
