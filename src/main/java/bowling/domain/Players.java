package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Players implements Printable {
    private final List<Player> players;
    private Player currentPlayer;

    public Players(List<String> playerNames) {
        this.players = createPlayers(playerNames);
        this.currentPlayer = players.get(0);
    }

    private static List<Player> createPlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        return players;
    }

    public boolean allPlayersAreDone() {
        return players
                .stream()
                .allMatch(Player::hasPlayedAllBowls);
    }

    public String getPlayerName() {
        return currentPlayer.getPlayerName();
    }

    private void changeCurrentPlayer() {
        int maxIndex = players.size() - 1;
        int currentIndex = players.indexOf(currentPlayer);
        if (currentIndex == maxIndex) {
            currentPlayer = players.get(0);
            return;
        }
        currentPlayer = players.get(currentIndex + 1);
    }

    public void bowl(int pins) {
        currentPlayer.bowl(pins);
        if (currentPlayer.turnIsOver()) {
            changeCurrentPlayer();
        }
    }

    @Override
    public String printScoreBoard() {
        StringBuilder builder = new StringBuilder();
        for (Player player : players) {
            builder.append(player.convertStatusToPrintable());
            builder.append("\n");
            builder.append(player.convertScoreToPrintable());
            builder.append("\n");
        }
        return builder.toString();
    }
}