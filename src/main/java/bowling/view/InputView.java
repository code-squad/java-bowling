package bowling.view;

import bowling.domain.Pin;
import bowling.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String PLAYER_SPLITTER = ",";

    public static List<Player> getPlayer() {
        System.out.print("플레이어 이름은(3 english letters)? : ");

        List<String> players = Arrays.asList(sc.nextLine().split(PLAYER_SPLITTER));

        return players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static Pin getPin() {
        return new Pin(Integer.parseInt(sc.nextLine()));
    }
}
