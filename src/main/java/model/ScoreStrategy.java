package model;

import java.util.ArrayList;
import java.util.List;

public class ScoreStrategy {
    private Integer numberOfNextTrials;
    private List<BowlingScore> queueToCalculate;

    public ScoreStrategy() {
        queueToCalculate = new ArrayList();
    }

    public Integer calculateNextTrial(Score thisScore) {
        if (numberOfNextTrials == null){
            numberOfNextTrials = 0;
        }

        if (thisScore.equals(Score.STRIKE)) {
            numberOfNextTrials += 2;
            return numberOfNextTrials;
        }
        if (thisScore.equals(Score.SPARE)) {
            numberOfNextTrials += 1;
            return numberOfNextTrials;
        }
        if (numberOfNextTrials > 0) {
            numberOfNextTrials--;
        }
        return numberOfNextTrials;
    }

    public Boolean hasMoreNextTrial(){
        if (numberOfNextTrials == null){
            return true;
        }
        if (!numberOfNextTrials.equals(0)){
            return true;
        }
        return false;
    }

    public Integer calculateUtilNow(Frame currentFrame) {
        if (currentFrame.hasStrikeOrSpare()){
            queueToCalculate.add(currentFrame.getScore());
            return 0;
        }
        if (numberOfNextTrials == 0){
            if (!queueToCalculate.isEmpty()) {
                Integer result = queueToCalculate.get(0).calculateWithNextFrame(currentFrame);
                queueToCalculate.remove(0);
                queueToCalculate.add(currentFrame.getScore());
                return result;
            }
            return currentFrame.addFirstAndSecond();
        }
        queueToCalculate.add(currentFrame.getScore());
        return 0;
    }

    public boolean stillCanCalculate() {
        System.out.println(queueToCalculate);
        return !queueToCalculate.isEmpty() && !queueToCalculate.get(0).hasStrikeOrSpare();
    }
}
