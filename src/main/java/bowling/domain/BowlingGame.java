package bowling.domain;

public class BowlingGame {
    private static final String TOP_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n";

    private String player;
    private Frames frames;
    private int round;

    public BowlingGame(String player) {
        this.player = player;
        this.frames = new Frames();
        this.round = 0;
    }

    public String printView() {
        StringBuilder sb = new StringBuilder(TOP_MESSAGE);
        sb.append("|  ")
                .append(player)
                .append(" |")
                .append(frames.printFrames());

        return sb.toString();
    }

    public CurrentInfo getCurrentInfo() {
        return new CurrentInfo(player, round);
    }

    public void rollBowlingBall(CurrentInfo currentInfo, Pin fellPin) {
        frames.rollBowlingBall(currentInfo, fellPin);
        tryRoundUp(currentInfo);
    }

    private void tryRoundUp(CurrentInfo currentInfo) {
        if(frames.isCurrentFrameEnd(currentInfo))
            round++;
    }
}
