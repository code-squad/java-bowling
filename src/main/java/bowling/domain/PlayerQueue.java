package bowling.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerQueue {
    private Queue<Player> playerQueue;

    public PlayerQueue(List<Player> players) {
        inputValidationCheck(players);

        playerQueue = new LinkedList<>(players);
    }

    private void inputValidationCheck(List<Player> players) {
        if(players == null || players.isEmpty())
            throw new IllegalArgumentException("Invalid input for queue");
    }

    public Player getCurrentPlayer() {
        return playerQueue.peek();
    }

    public void rotate() {
        Player player = playerQueue.poll();
        player.frameNoUpdate();
        playerQueue.add(player);
    }
}
