package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pin {
    public static final int MAX_COUNT = 10;
    public static final int MIN_COUNT = 0;
    private List<Shoot> shoots;

    public Pin() {
        this.shoots = new ArrayList<>();
    }

    private void checkValidInput(Shoot shoot) {
        if (getScoreSum() + shoot.getFallenPinCount() > getLimitOfSum())
            throw new IllegalArgumentException();
    }

    private int getLimitOfSum() {
        return MAX_COUNT * (getScoreSum() / MAX_COUNT + 1);
    }

    public boolean isStrike() {
        if (shoots.size() == 0)
            return false;

        return getScoreSum(1) == MAX_COUNT;
    }

    public boolean isSpare() {
        if (isStrike())
            return false;

        if (shoots.size() < 2)
            return false;

        return getScoreSum(2) == MAX_COUNT;
    }

    public int size() {
        return shoots.size();
    }

    public void add(Shoot shoot) {
        checkValidInput(shoot);

        shoots.add(shoot);
    }

    public int getScoreSum() {
        return shoots.stream()
                .mapToInt(Shoot::getFallenPinCount)
                .sum();
    }

    public int getScoreSum(int count) {
        if (count > shoots.size())
            throw new IllegalArgumentException();

        int result = 0;

        for (int i = 0; i < count; i++) {
            result += shoots.get(i).getFallenPinCount();
        }

        return result;
    }

    @Override
    public String toString() {
        String str = shoots.stream()
                .map(Shoot::toString)
                .collect(Collectors
                        .joining("|"));
        if (isSpare()) {
            return str.substring(0, 2) + "/" + str.substring(3);
        }

        return str;
    }
}
