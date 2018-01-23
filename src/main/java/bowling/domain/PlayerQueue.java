package bowling.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerQueue {
    private Queue<Player> playerQueue;

    public PlayerQueue(List<Player> players) {
        playerQueue = new LinkedList<>(players);
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
