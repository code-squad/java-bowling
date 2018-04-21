package bowling.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShotTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void 핀은_10개를_초과할_수_없다() {
        thrown.expect(IllegalArgumentException.class);

        new Shot(11);
    }
}