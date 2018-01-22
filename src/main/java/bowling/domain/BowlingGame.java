package bowling.domain;

public class BowlingGame {
    private String player;
    private Frames frames;
    private int round;

    public BowlingGame(String player) {
        this.player = player;
        this.frames = new Frames();
        this.round = 0;
    }

    public String printView() {
        StringBuilder sb = new StringBuilder("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n");
        sb.append("|  ")
                .append(player)
                .append(" |")
                .append(frames.printFrames());

        return sb.toString();
    }
}
