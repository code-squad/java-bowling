package model;

public class BowlingScore {
    private Score firstScore;
    private Score secondScore;

    public BowlingScore() {
    }

    public BowlingScore(Score firstScore) {
        this.firstScore = firstScore;
    }

    public void addNewScore(Score secondScore) {
        this.secondScore = secondScore;
    }

    @Override
    public String toString() {
        if (secondScore == null){
            return Score.of(firstScore) + "   ";
        }

        return Score.of(firstScore) + "|" + Score.of(secondScore) + " ";
    }

    public boolean hasAnyScore() {
        return firstScore != null;
    }

    public boolean isItOverAndHasNextFrame(Integer numberOfFrame) {
        if (numberOfFrame.equals(10)){
            if (firstScore.equals(Score.STRIKE) || firstScore.equals(Score.STRIKE)){
                return true;
            }
            if (secondScore != null && secondScore.equals(Score.SPARE)) {
                return true;
            }

            return false;
        }
        if (firstScore.equals(Score.STRIKE)){
            return true;
        }
        if (secondScore != null){
            return true;
        }
        return false;
    }

    public boolean isItOver(Integer numberOfFrame) {
        if (numberOfFrame >= 10 && hasAnyScore()){
            if (firstScore.equals(Score.STRIKE)){
                return false;
            }
            if (secondScore != null){
                if (secondScore.equals(Score.STRIKE) || secondScore.equals(Score.SPARE)){
                    return false;
                }
                return true;
            }
        }

        return false;
    }

}
