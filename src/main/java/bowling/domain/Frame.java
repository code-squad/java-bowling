package bowling.domain;

public interface Frame {
    boolean isEnd();

    Frame nextRound(Score score);

    String result();
}
