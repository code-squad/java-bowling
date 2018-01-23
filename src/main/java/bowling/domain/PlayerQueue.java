package bowling.domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PlayerQueue {
    private Deque<Player> playerQueue;

    public PlayerQueue(List<Player> players) {
        playerQueue = new LinkedList<>(players);
    }

    public Player getCurrentPlayer() {
        return playerQueue.peek();
    }

    public Player getPreviousPlayer() {
        return playerQueue.peekLast();
    }

    public void rotate() {
        Player player = playerQueue.poll();
        player.frameNoUpdate();
        playerQueue.add(player);
    }
}
