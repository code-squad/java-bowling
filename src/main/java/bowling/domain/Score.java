package bowling.domain;

import bowling.type.ScoreType;

import java.util.List;

public class Score {
    public static final int RANGE_MIN = 0;
    public static final int RANGE_MAX = 10;

    private ScoreType type;
    private int score;

    Score(ScoreType type, int score){
        if(RANGE_MIN > score || score > RANGE_MAX){
            throw new IllegalArgumentException("입력한 스코어가 잘못되었습니다.");
        }

        this.type = type;
        this.score = score;
    }

    boolean is(ScoreType type){
        return this.type == type;
    }

    String express(){
        return String.format(type.getExpression(), score);
    }

    static int sum(List<Score> cur){
        return cur.stream()
                .mapToInt(s -> s.score)
                .sum();
    }

    static ScoreType match(List<Score> cur, int no){
        if(no == RANGE_MIN){
            return ScoreType.GUTTER;
        }

        if(cur.size() != 0 && sum(cur) + no == RANGE_MAX){
            return ScoreType.SPARE;
        }

        if(no == RANGE_MAX){
            return ScoreType.STRIKE;
        }

        return ScoreType.MISS;
    }

}
