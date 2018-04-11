package domain;

public class NormalFrame extends Frame {
    private FirstThrow firstThrow;
    private SecondThrow secondThrow;

    public NormalFrame() {
        this.firstThrow = new FirstThrow();
        this.secondThrow = new SecondThrow();
    }

    public void updateFirstThrow(int pinsKnocked) { //toString보다 먼저 실행 됨
        firstThrow.updateScore(pinsKnocked);
    }

    public void updateSecondThrow(int pinsKnocked) { //toString 이후에 실행 됨
        secondThrow.updateScore(firstThrow.countPinsStanding(), pinsKnocked);
    }

    public boolean isStrike() {
        return firstThrow.countPinsStanding() == 0;
    }

    @Override
    public String toString(){
        return firstThrow.toString() + secondThrow.toString();
    }
}