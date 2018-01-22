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
}
