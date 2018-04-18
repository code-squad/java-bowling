package saru.view;

import saru.domain.ScoreBoard;
import saru.domain.User;

import java.util.Scanner;

public class BowlingInput {
    private static final int MAX_THROW_NUM = 10;

    public User getUserInput() {
        String userName = getUserName();
        User user;

        try {
            user = User.of(userName);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getUserInput();
        }

        return user;
    }

    private String getUserName() {
        System.out.println("플레이어 이름은(3 english letters)?: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getThrowNum(ScoreBoard scoreBoard) {
        System.out.printf("%d프레임 투구 : ", scoreBoard.getNowFrameIndex() + 1);

        return getThrowNum();
    }

    private int getThrowNum() {
        int throwNum = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            throwNum = checkValidThrow(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getThrowNum();
        }

        return throwNum;
    }

    private int checkValidThrow(int throwNum) {
        if (throwNum < 0 || throwNum > MAX_THROW_NUM) {
            throw new IllegalArgumentException("잘못된 투구수 입력");
        }

        return throwNum;
    }
}
