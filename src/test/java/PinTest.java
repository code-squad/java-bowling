import domain.Pin;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PinTest {

    /**
     * 1. 스트라이크 체크
     * 2. 총 넘어진 핀 개수 체크
     * 3. 보너스 롤 존재유무
     */
    @Test
    public void 스트라이크체크() {
        Pin firstRoll = new Pin(10);
        assertEquals(true, firstRoll.isStrike());
    }

    @Test
    public void 총넘어진핀개수체크() {
        Pin firstRoll = new Pin(10);
        Pin secondRoll = new Pin(1);

        assertEquals(false, secondRoll.isValid(firstRoll));
    }

    @Test
    public void 보너스롤존재유무() {
        Pin firstRoll = new Pin(1);
        Pin secondRoll = new Pin(9);

        assertEquals(true, secondRoll.isExistBonusRoll(firstRoll));
    }
}
