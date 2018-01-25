package bowling.io;

import bowling.domain.Name;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Pins;

import java.util.Scanner;

public class InputView {
    public static Name playerName() {
        System.out.println("플레이어 이름은(3 english letters)?:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while(!isName(name)) {
            System.out.println("플레이어 이름은(3 english letters)?:");
            name = scanner.nextLine();
        }
        return new Name(name);
    }

    public static boolean isName(String name) {
        return name.matches("[a-zA-Z]{1,3}");
    }

    private static boolean isNumeric(String number) {
        return number.matches("^[0-9]{1,2}$");
    }

    public static Pins userPinDownCount(MaxCount limit, int frameNumber) {
        System.out.print(frameNumber + "프레임 투구 : ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while(!isNumeric(number) || Integer.parseInt(number) > limit.toInteger()) {
            System.out.println(limit+"보다 클 수 없습니다.");
            number = scanner.nextLine();
        }
        return new Pins(Integer.parseInt(number));
    }
}