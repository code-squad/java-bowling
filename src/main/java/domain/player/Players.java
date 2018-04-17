package domain.player;

import domain.frame.result.Board;
import domain.frame.result.Boards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {
    private List<Player> players;
    private int currentPlayerIdx;
    private int currentFrameNum;

    public Players(List<Player> players) throws IllegalArgumentException {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("1명 이상은 플레이해야합니다.");
        }
        this.players = players;
        currentPlayerIdx = 0;
        currentFrameNum = 1;
    }

    public void roll(int num) throws IllegalArgumentException {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.roll(num);

        currentPlayerIdx = changePlayerIdx(currentPlayer);
        currentFrameNum = calcFrameNum();
    }

    private int changePlayerIdx(Player currentPlayer) {
        if (currentPlayer.isFinishFrame(currentFrameNum)) {
            return (currentPlayerIdx + 1) % players.size();
        }
        return currentPlayerIdx;
    }

    private int calcFrameNum() {
        int lastPlayerIdx = players.size() - 1;
        Player lastPlayer = players.get(lastPlayerIdx);
        if (currentPlayerIdx == lastPlayerIdx && lastPlayer.isFinishFrame(currentFrameNum)) {
            return currentFrameNum + 1;
        }
        return currentFrameNum;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }

    public boolean isFinish() {
        return players.stream().allMatch(Player::isFinish);
    }

    public Boards getBoards() {
        Map<Player, Board> boards = new HashMap<>();
        players.forEach(player -> boards.put(player, player.getBoard()));
        return new Boards(boards);
    }
}
