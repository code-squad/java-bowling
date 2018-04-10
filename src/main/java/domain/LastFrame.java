package domain;

import static view.ScoreMarker.*;

public class LastFrame extends Frame {
    private Integer thirdThrow;

    public boolean updateFrame(int throwScore) {
        if (frameNotPlayed()) {
            firstThrow = throwScore;
            return true;
        }
        if (secondThrowNotPlayed() && !isStrike()) {
            secondThrow = throwScore;
            return true;
        }
        if (isStrike() || isSpare()) {
            thirdThrow = throwScore;
            return true;
        }
        return false;
    }

    private boolean bonusIsStrike(){
        return thirdThrow == 10;
    }

    @Override
    public String toString() {






        if(frameNotPlayed()){

        }
        if(secondThrowNotPlayed()){

        }
        if(isStrike() && bonusIsStrike()){

        }
        if(isStrike() && !bonusIsStrike()){

        }
        if(isSpare() && bonusIsStrike()){

        }
        if(isStrike() && !bonusIsStrike()){

        }
        if()







        if(frameNotPlayed()){
            return markEmpty();
        }
        if(secondThrowNotPlayed() && !isStrike()){

        }
        if (isStrike() && thirdThrow == STRIKE) {
            return markStrike()
                    + markSeparator()
                    + markEmpty()
                    + markSeparator()
                    + markStrike();
        }
        if (isStrike()) {
            return markStrike()
                    + markSeparator()
                    + markEmpty()
                    + markBonusNumber(thirdThrow);
        }
        if (isSpare()) {
            return markSpare(firstThrow)
                    + markBonusNumber(thirdThrow);
        }
        return markNumber(firstThrow, secondThrow)
                + markSeparator();
    }
}