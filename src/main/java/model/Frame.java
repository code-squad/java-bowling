package model;

public class Frame {
    private int[] frameScores;
    public Frame() {
        frameScores = new int[2];
    }

    public boolean isValidNumber(int number){
        if(number > 10 || number < 0) return false;
        return true;
    }


    public void setBallOne(int i) {
        frameScores[0] = i;
    }

    public boolean isStrike(){
        return frameScores[0] == 10;
    }
}
