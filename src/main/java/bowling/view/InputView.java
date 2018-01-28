package bowling.view;

import bowling.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PLAYER_SPLITTER = ",";

    public static List<Player> getPlayer(String player) {
        List<String> players = Arrays.asList(player.split(PLAYER_SPLITTER));

        return players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static int getPin(String pin) {
        return Integer.parseInt(pin);
    }
}
