package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PinTest {

    @Test(expected = IllegalArgumentException.class)
    public void Pin_음수() throws Exception {
        new Pin(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Pin_10보다큰수() throws Exception {
        new Pin(11);
    }

    @Test
    public void minus() throws Exception {
        Pin p1 = new Pin(8);
        assertThat(p1.minus(new Pin(3))).isEqualTo(new Pin(5));
        assertThat(p1.minus(new Pin(8))).isEqualTo(new Pin(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void minus_음수인경우() throws Exception {
        Pin p1 = new Pin(8);
        p1.minus(new Pin(9));
    }

    @Test
    public void add() throws Exception {
        Pin p1 = new Pin(4);
        assertThat(p1.add(new Pin(4))).isEqualTo(new Pin(8));
        assertThat(p1.add(new Pin(6))).isEqualTo(new Pin(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_합이10보다큰경우() throws Exception {
        Pin p1 = new Pin(5);
        p1.add(new Pin(6));
    }

}