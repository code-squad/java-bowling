package bowling.domain.service;

import bowling.domain.*;
import bowling.domain.frame.Frame;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class BowlingService {

    private static final int MAX_FRAME = 10;
    private Frame[] frames;
    private Frame frame;

    public BowlingService() {
        this.frames = new Frame[MAX_FRAME];
        this.frame = Frame.of();
    }

    public void bowl(Pin pin) {
        if (!isFinishedGame()) {
            Frame nextFrame = frame.bowl(pin);
            frames[frame.getFrameNumber()-1] = frame;
            this.frame = nextFrame;
        }
    }

    public boolean isFinishedGame() {
        return frame.isFinished() && frame.getFrameNumber() == 10;
    }

    public int getFrameNumber() {
        return frame.getFrameNumber();
    }

    public SymbolResult getSymbolResult() {
        return SymbolResult.of(Arrays.stream(frames)
                .filter(Objects::nonNull)
                .map(Frame::getSymbol)
                .collect(Collectors.toList()));
    }

    private List<Frame> getFrameList() {
        return Arrays.stream(frames)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public ScoreResult getAccumulatedScoreResult() {
        List<Frame> frameList = getFrameList();
        List<Score> accumulatedBonusScore = accumulateBonusScore(frameList);
        List<Score> accumulateTotalScore = accumulateTotalScore(accumulatedBonusScore);

        return ScoreResult.of(accumulateTotalScore);
    }

    private List<Score> accumulateBonusScore(List<Frame> frames) {
        List<Score> accumulatedBonusScore = new ArrayList<>();

        for (int i=0; i<frames.size(); i++) {
            Frame frame = frames.get(i);
            Score score = frame.getScore();

            LinkedList<Pin> nextPins = getNextPins(frame.getFrameNumber() + 1);

            if (score.getLeftBonus() > nextPins.size())
                continue;

            while (score.isAddable() && !nextPins.isEmpty())
                score = score.addBonusScore(nextPins.pollFirst());

            accumulatedBonusScore.add(score);
        }

        if (MAX_FRAME == frames.size() && MAX_FRAME > accumulatedBonusScore.size())
            accumulatedBonusScore.add(frames.get(MAX_FRAME - 1).getScore());

        return accumulatedBonusScore;
    }

    private LinkedList<Pin> getNextPins(int nextFrameNumber) {
        return getFrameList().stream()
                .filter(frame -> frame.getFrameNumber() >= nextFrameNumber)
                .flatMap(frame1 -> frame1.getPins().stream())
                .collect(toCollection(LinkedList::new));
    }

    private List<Score> accumulateTotalScore(List<Score> scores) {
        for (int i=1; i<scores.size(); i++)
            scores.set(i, scores.get(i-1).add(scores.get(i)));

        return scores;
    }
}
