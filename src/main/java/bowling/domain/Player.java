package bowling.domain;

import bowling.domain.service.BowlingService;

public class Player {

    private String player;
    private BowlingService bowlingService;

    private Player(String player) {
        this.player = player;
        this.bowlingService = new BowlingService();
    }

    public static Player of(String player) {
        return new Player(player);
    }

    public String getPlayer() {
        return player;
    }

    public BowlingService getBowlingService() {
        return bowlingService;
    }
}
