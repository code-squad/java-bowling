package bowling.view;

import bowling.domain.Player;

import java.util.List;

public class ScoreBoard {
    private final Player player;

    public ScoreBoard(BowlingGame game) {
        this.player = game.getPlayer();
    }

    //TODO: 플레이어 객체에게 스트라이크/스페어/보통점수 인지 물어보고 그에 해당하는 마크 생성.
    public void print

    //TODO: 플레이어 객체에게 종합점수 물어보고, 프린트.. 스트라이크면 다음 두번까지 대기. 스페어면 다음 한번.
    public void printScoreBoard() {
        StringBuilder builder = new StringBuilder();
        for (int frameNumber = 0; frameNumber < 9; frameNumber++) {
            int firstScore = player.getScoreOnFrame(frameNumber);
            boolean isStrike = player.isStrikeOnFrame(frameNumber);
            if (score == 10 && isStrike) {
                builder.append("X");
            }
            if (score == 10) {
                builder.append().append("/");
            }
        }
        List<Integer> scores = game.calculateFrameScore();
    }
}
