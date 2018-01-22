package bowling.domain;

/**
 * Created by KH on 2018-01-22.
 */
public class BowlingGame {
    private String player;
    private Frames frames;

    public BowlingGame(String player) {
        this.player = player;
        this.frames = new Frames();
    }

    public String printView() {
        StringBuilder sb = new StringBuilder("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n");
        sb.append("|  ").append(player).append(" |")
                .append(frames.printFrames());

        return sb.toString();
    }
}
