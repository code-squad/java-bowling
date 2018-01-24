package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BallTest {
    private Shoot shoot;
    @Before
    public void setUp() {
        shoot = new Shoot(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validNumberCheck() {
        shoot = new Shoot(11);
    }

    @Test
    public void gutterStringTest() {
        shoot = new Shoot(0);

        assertThat(shoot.toString()).isEqualTo("-");
    }

    @Test
    public void strikeStringTest() {
        shoot = new Shoot(10);

        assertThat(shoot.toString()).isEqualTo("X");
    }
}
