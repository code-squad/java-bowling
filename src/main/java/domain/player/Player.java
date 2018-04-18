package domain.player;

import domain.frame.Frames;
import domain.frame.result.Board;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Player {
    private PlayerName name;
    private Frames frames;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
        frames = new Frames();
    }

    public static boolean isDuplicateName(List<Player> players) {
        return PlayerName.isDuplicateName(players.stream().map(player -> player.name).collect(toList()));
    }

    public void roll(int num) throws IllegalArgumentException {
        frames.roll(num);
    }

    public boolean isFinish() {
        return frames.isFinish();
    }

    public Board getBoard() {
        return frames.getBoard();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isFinishFrame(int frameNum) {
        return frames.isFinishFrame(frameNum);
    }

    public boolean isSameName(String checkName) {
        return name.isSameName(checkName);
    }

    @Override
    public boolean equals(Object otherPlayer) {
        if (this == otherPlayer) return true;
        if (otherPlayer == null || getClass() != otherPlayer.getClass()) return false;
        Player player = (Player) otherPlayer;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
