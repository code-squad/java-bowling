package view;

import domain.Player;
import domain.PlayerName;
import utils.InputUtils;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Player getPlayer() {
        System.out.println("플레이어 이름은 (" + PlayerName.LENGTH + " english letters)?");
        try {
            return new Player(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }

    /*  TODO : 프레임 몇번째인지 알아야함 - 프레임에 물어보던가(몇번째 프레임이냐? index와 다르니깐 안에서 로직처리하고 결과값만 받아서) */
    public static int getScore() {
        System.out.println("번째 프레임 투구 : ");
        try {
            return InputUtils.convertToNumber(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getScore();
        }
    }
}
