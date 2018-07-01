package bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pins implements Presentable {
    private static final int MAX_PINS = 10;
    private List<Integer> knockDowns = new ArrayList<>(2);

    public void knockDown(Pins pins) {
        knockDown(pins.getKnockDownPins());
    }

    void knockDown(int pins) {
        if (isKnockDownAll()) {
            // TODO 클라이언트에 할 수 없음을 알려야 함
            return;
        }

        if (pins >= getRemainPins()) {
            pins = getRemainPins();
        }

        knockDowns.add(pins);
    }

    public boolean isKnockDownAll() {
        return MAX_PINS == getKnockDownPins();
    }

    public int getKnockDownPins() {
        return knockDowns.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    static int getMaxPins() {
        return MAX_PINS;
    }

    @Override
    public String getSymbol() {
        List<String> symbols;

        if (knockDowns.size() == 1 && isKnockDownAll()) {
            return "X";
        }

        symbols = knockDowns.stream()
                .map(knockDown -> knockDown == 0 ? "-" : String.valueOf(knockDown))
                .collect(Collectors.toList());

        if (symbols.size() == 2 && isKnockDownAll()) {
            symbols.set(1, "/");
        }

        return String.join("|", symbols);
    }

    private int getRemainPins() {
        return MAX_PINS - getKnockDownPins();
    }
}
