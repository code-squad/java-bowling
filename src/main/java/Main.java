import domain.Player;

import static view.InputView.getPlayer;

public class Main {
    public static void main(String[] args) {
        Player player = getPlayer();

        player.playBowling();
    }
}
