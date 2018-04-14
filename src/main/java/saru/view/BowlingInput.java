package saru.view;

import saru.domain.ScoreBoard;

import java.util.Scanner;

public class BowlingInput {
    private ScoreBoard scoureBoard;

    public BowlingInput(ScoreBoard scoreBoard) {
        this.scoureBoard = scoreBoard;
    }

    public int getUserInput() {
        System.out.printf("%d프레임 투구 : ", scoureBoard.getNowFrameIndex());
        Scanner scanner = new Scanner(System.in);

        int result = scanner.nextInt();

        return result;
    }
}
