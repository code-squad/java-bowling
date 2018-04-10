package domain;

import view.Score;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Score> scores;

    public BowlingGame(String playerName) {
        this.scores = initializeScores(playerName);
    }

    private static List<Score> initializeScores(String playerName) {
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(playerName));
        return scores;
    }

    public void updateScores(int throwScore, int throwCount) { //throwCount = 0; throwCount < 21;
        for (Score score : scores) {
            score.updateScore(throwScore, throwCount);
        }
    }

    public void startGame(){

    }
}
