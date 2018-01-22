package bowling.domain;

import java.text.MessageFormat;

public class CurrentInfo {
    private static final String CURRENT_STATUS_FORMAT = "{0}프레임 투구 : ";
    private String currentPlayer;
    private int currentRound;

    CurrentInfo(String currentPlayer, int currentRound) {
        this.currentRound = currentRound;
        this.currentPlayer = currentPlayer;
    }

    public String showCurrentStatus() {
        return MessageFormat.format(CURRENT_STATUS_FORMAT, currentRound);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentInfo that = (CurrentInfo) o;

        if (currentRound != that.currentRound) return false;
        return currentPlayer != null ? currentPlayer.equals(that.currentPlayer) : that.currentPlayer == null;
    }

    @Override
    public int hashCode() {
        int result = currentPlayer != null ? currentPlayer.hashCode() : 0;
        result = 31 * result + currentRound;
        return result;
    }
}
