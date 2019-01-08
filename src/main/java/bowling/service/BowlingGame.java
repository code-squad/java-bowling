package bowling.service;

import bowling.domain.Pin;
import bowling.domain.Player;
import bowling.domain.service.BowlingService;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Player> players;

    public BowlingGame() {
        this.players = new ArrayList<>();
        initPlayer();
    }

    private void initPlayer() {
        final int playerCount = InputView.initPlayerCount();
        for (int i=0; i<playerCount; i++)
            this.players.add(Player.of(InputView.initPlayer()));
    }

    public void start() {
        for (Player player : players)
            playGame(player);
    }

    private void playGame(Player player) {
        final String playerName = player.getPlayer();
        final BowlingService bowlingService = player.getBowlingService();

        while (!bowlingService.isFinishedGame()) {
            int falledPin = InputView.initBowlFrame(playerName, bowlingService.getFrameNumber());
            bowlingService.bowl(Pin.of(falledPin));

            playerBoard();
        }
    }

    private void playerBoard() {
        OutputView.printHeader();

        for (Player player : players) {
            OutputView.printState(player.getPlayer(), player.getBowlingService().getSymbolResult());
            OutputView.printScore(player.getBowlingService().getAccumulatedScoreResult());
        }
    }
}
