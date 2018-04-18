package saru.view;

import saru.domain.*;

import java.util.List;

public class BowlingOutput {
    private List<Frame> frames;
    private User user;

    public BowlingOutput(ScoreBoard scoreBoard) {
        this.frames = scoreBoard.getFrames();
        this.user = scoreBoard.getUser();
    }

    public void printScore() {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("|%6s", user.getName()));

        for (int i = 0; i < frames.size(); i++) {
            String str = String.format("|%6s", frames.get(i));
            stringBuilder.append(str);
        }
        stringBuilder.append("|");

        System.out.println(stringBuilder.toString());
    }
}