package bowling.view;

import bowling.domain.Score;
import bowling.domain.ScoreResult;
import bowling.domain.Symbol;
import bowling.domain.SymbolResult;

import java.util.List;

public class OutputView {

    private static final String NAME = "|  NAME  |";
    private static final String SPACE_BAR = "   |";
    private static final String BAR = "|";
    private static final int MAX_FRAME = 10;

    private OutputView() {}

    public static void printHeader() {
        StringBuilder sb = new StringBuilder(NAME);

        for (int i=1; i<=MAX_FRAME; i++) {
            sb.append(formattedString(String.valueOf(i)));
            sb.append(SPACE_BAR);
        }
        System.out.println(sb);
    }

    public static void printState(String player, SymbolResult symbolResult) {
        StringBuilder sb = new StringBuilder(BAR);
        sb.append(formattedString(player));
        sb.append(SPACE_BAR);

        final List<Symbol> symbols = symbolResult.getSymbols();
        for (Symbol symbol : symbols) {
            sb.append(formattedString(symbol.getSymbol()));
            sb.append(SPACE_BAR);
        }
        formattedSpace(sb, MAX_FRAME - symbols.size());

        System.out.println(sb);
    }

    public static void printScore(ScoreResult scoreResult) {
        StringBuilder sb = new StringBuilder(BAR);
        sb.append(formattedString(""));
        sb.append(SPACE_BAR);

        final List<Score> scores = scoreResult.getScores();
        for (Score score : scores) {
            sb.append(formattedString(String.valueOf(score.getScore())));
            sb.append(SPACE_BAR);
        }
        formattedSpace(sb, MAX_FRAME - scores.size());

        System.out.println(sb);
    }

    private static void formattedSpace(StringBuilder stringBuilder, int spaceCount) {
        for (int i=0; i<spaceCount; i++) {
            stringBuilder.append(formattedString(""));
            stringBuilder.append(SPACE_BAR);
        }
    }

    private static String formattedString(String in) {
        return String.format("%5s", in);
    }
}
