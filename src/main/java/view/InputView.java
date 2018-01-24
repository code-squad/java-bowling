package view;

import java.util.Scanner;

public class InputView {
    public static String inputName() {
        System.out.println("플레이어의 이름을 입력해 주세요.(영문 3글자)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Integer inputNumberOfPins(Integer num) {
        System.out.println(num + "프레임 투구: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
