package bowling.domain.Util;

import bowling.domain.Frame;

import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    private final List<Frame> frames;

    public ScoreCalculator(List<Frame> frames) {
        this.frames = frames;
    }

    public List<Integer> calculateScores() {
        List<Integer> scores = new ArrayList<>();
        for (Frame frame : frames) {
            int currentFrame = frames.indexOf(frame);
            scores.add(frame.calculateFrameScore(frames, currentFrame));
        }
        return scores;
    }

    /*
        진행순서:
        1) 이름 입력
        2) 투구 값 입력
        3) 해당 투구 값 업데이트
        4) 합계 계산
        5) 프린트
        6) 반복

     */
}