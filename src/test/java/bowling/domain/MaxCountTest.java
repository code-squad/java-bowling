package bowling.domain;

import bowling.domain.number.MaxCount;
import org.junit.Test;

public class MaxCountTest {
    @Test
    public void 최대_max_pin_count() {
        int exceptionCount = 11;
        for (int i = 0; i < exceptionCount; i++) {
            new MaxCount(i);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void 최대_max_pin_count_예외처리() {
        int exceptionCount = 11;
        new MaxCount(exceptionCount);
    }
}
