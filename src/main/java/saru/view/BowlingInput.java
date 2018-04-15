package saru.view;

import saru.domain.ScoreBoard;
import saru.domain.User;

import java.util.Scanner;

public class BowlingInput {
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
        Scanner scanner = new Scanner(System.in);

        int result = scanner.nextInt();

        return result;
    }
}
