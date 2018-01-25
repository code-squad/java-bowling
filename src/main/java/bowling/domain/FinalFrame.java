package bowling.domain;

import bowling.type.ScoreType;

import java.util.ArrayList;

public class FinalFrame extends Frame {

    FinalFrame() {
        this.scores = new ArrayList<>();
    }

    @Override
    boolean hasNext() {
        long count = scores.stream()
                .filter(s -> s.is(ScoreType.STRIKE) || s.is(ScoreType.SPARE))
                .count();

        return scores.size() < 2 || count > 0 && scores.size() < 3;
    }

    @Override
    void validate(int no) {
        int count = (int)scores.stream()
                .filter(s -> s.is(ScoreType.STRIKE) || s.is(ScoreType.SPARE))
                .count();

        int max = Score.RANGE_MAX * (count + 1);

        if(Score.sum(scores) + no > max){
            throw new IllegalArgumentException("입력한 스코어가 잘못되었습니다.");
        }
    }
}
