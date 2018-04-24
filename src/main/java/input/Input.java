package input;

import java.util.Scanner;

public class Input {
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("플레이어 이름은(3 english letters)?: ");
        return scanner.next();
    }

    public static Integer inputNum(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(i + "프레임 투구 : ");
        return scanner.nextInt();
    }
}
