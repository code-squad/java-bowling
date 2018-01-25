package bowling.domain;

import bowling.type.ScoreType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frame {
    List<Score> scores;

    Frame(){
        this.scores = new ArrayList<>();
    }

    boolean hasNext(){
        long count = scores.stream()
                .filter(s -> s.is(ScoreType.STRIKE))
                .count();

        return count <= 0 && scores.size() < 2;
    }

    void marking(int no){
        validate(no);

        if(!hasNext()){
            throw new IllegalStateException("현재 프레임은 스코어를 마킹할 수 없습니다.");
        }

        scores.add(new Score(Score.match(this.scores, no), no));
    }

    void validate(int no){
        if(Score.sum(scores) + no > Score.RANGE_MAX){
            throw new IllegalArgumentException("입력한 스코어가 잘못되었습니다.");
        }
    }

    String result(){
        return String.join("|", scores.stream()
                .map(Score::express)
                .collect(Collectors.toList()));
    }
}
