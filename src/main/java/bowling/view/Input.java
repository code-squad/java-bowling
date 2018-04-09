package bowling.view;

import java.util.Scanner;

public class Input {

    public static String inputName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("플레이어 이름은(3 english letters)?: ");
        return scan.next();
    }

    public static int inputPinNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("프레임 투구 : ");
        return scan.nextInt();
    }
}
