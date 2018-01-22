package model;

public class FinalFrame extends Frame{
    public FinalFrame(){
        super(10);
    }

    @Override
    public String toString() {
        Frame curr = this;
        StringBuilder builder = new StringBuilder();
        while(curr.getNextFrame() != null){
            builder.append(this.roundScore.toString()).append("|");
            curr = curr.getNextFrame();
        }
        return builder.toString();
    }

    @Override
    public boolean isFinal(){
        return this.roundScore.isFinished();
    }
}
