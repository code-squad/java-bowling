package saru.view;

import saru.domain.*;

import java.util.List;

public class BowlingOutput {
    private ScoreBoard scoreBoard;
    private List<Frame> frames;
    private User user;

    public BowlingOutput(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.frames = scoreBoard.getFrames();
        this.user = scoreBoard.getUser();
    }

    String getFrameResult(int frameIndex) {

        return "";
    }

    public void printScore() {
        String userName = user.getName();

        System.out.printf(
                "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n"
        );

        /*
        for문을 이용해 구현해 본다.
        for문을 돌면서 출력해야할 문자열을 StringBuilder에 저장해 본다.
         */
    }
}
