package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Round {

    private static final int MAX_FRAME = 10;
    private List<Frame> roundFrames;

    private Round() {
        roundFrames = new ArrayList<>(MAX_FRAME);
        roundFrames.add(NormalFrame.of());
    }

    public static Round of() {
        return new Round();
    }

    public void trying(final int score) {
        presentFrameTry(score);
        assignCalculableToFrame();
        System.out.println("현재 나는 "+score+"점을 "+(roundFrames.size())+"프레임에 넣었고 계산을 해야할까? : " + presentFrame().getCalculateStatus());
        if (roundFrames.size() != 1 && presentFrame().isCalculationDo()) {
            roundFrames = forloopBackward(roundFrames);
            roundFrames = forloopForward(roundFrames);
        }
        if (isPresentFrameEnd()) {
            System.out.println("프레임 더할거야");
            addNextFrame();
        }
    }

    public List<Frame> forloopBackward(List<Frame> roundFrames) {
        int size = roundFrames.size();
        for (int i = 1; i < size; i++) {
            System.out.println((size - i + 1) + "프레임이 " + (size - (i + 1) + 1) + "프레임에게 자신의 정보를 넘긴다.");
            this.roundFrames.get(size - (i + 1)).isGivenMessageFromPresentFrameGaveVersion(this.roundFrames.get(size - i));
        }
        return roundFrames;
    }

    public List<Frame> forloopForward(List<Frame> roundFrames) {
        int size = roundFrames.size();
        for (int i = size; i > 1; i--) {
            System.out.println(size - i + 1 + "번째 프레임이 " + (size - i + 1 + 1) + "프레임에게 자신의 정보를 넘긴다");
            this.roundFrames.get(size - i + 1).isGivenMessageFromBeforeFrameGaveVersion(this.roundFrames.get(size - i));
        }
        return roundFrames;
    }

    private void assignCalculableToFrame() {
        if (isRoundEnd()) {
            roundFrames.get(roundFrames.size() - 1).changeCalculationStatusToDo();
            return;
        }
        if (roundFrames.size() == 1) {
            presentFrame().assignCalculableState();
            return;
        }
        presentFrame().assignCalculableState(roundFrames.get(roundFrames.size() - 2));
    }

    private void presentFrameTry(final int score) {
        presentFrame().trying(score);
    }

    private boolean isPresentFrameEnd() {
        return presentFrame().isFrameEnd();
    }

    private void addNextFrame() {
        if (roundFrames.size() == MAX_FRAME - 1) {
            roundFrames.add(LastFrame.of());
            return;
        }
        if (roundFrames.size() != MAX_FRAME) {
            roundFrames.add(NormalFrame.of());
        }
    }

    public boolean isRoundEnd() {
        return roundFrames.size() == MAX_FRAME && isPresentFrameEnd();
    }

    public int getFrameNumber() {
        return roundFrames.size();
    }

    public List<Frame> getRoundFrames() {
        return Collections.unmodifiableList(roundFrames);
    }

    private Frame presentFrame() {
        return roundFrames.get(roundFrames.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return Objects.equals(roundFrames, round.roundFrames);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roundFrames);
    }

}
