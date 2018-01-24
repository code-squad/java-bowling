package bowling.domain.frame;

import bowling.domain.frame.element.Element;
import bowling.domain.score.Score;

public interface Frame {
    String FIRST_SCORE = "first";
    String SECOND_SCORE = "second";
    String THIRD_SCORE = "third";
    int FINAL_FRAME = 10;

    boolean isEnd();

    Frame nextRound(Score score);

    String result();

    Element getElement();
}
