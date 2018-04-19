package bowling.domain.frame;

import bowling.domain.status.Status;

public interface Frame {

    void bowl(int pins);

    int calculateAdditionalScore(Status prevFrameStatus);
}
