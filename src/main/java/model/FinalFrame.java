package model;

public class FinalFrame extends Frame {
    @Override
    public Integer addFirstAndSecond() {
        if (super.hasAllScore()) {
            return addFirstAndSecondOfScore();
        }
        return addOnlyFirst();
    }
}
