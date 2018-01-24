package model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PinTest {
    @Test(expected = IllegalArgumentException.class)
    public void checkValidInputTest() {
        Pin pin = new Pin();

        Shoot firstShoot = new Shoot(2);
        Shoot secondShoot = new Shoot(9);

        pin.add(firstShoot);
        pin.add(secondShoot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidInputTestForFinal() {
        Pin pin = new Pin();

        Shoot firstShoot = new Shoot(10);
        Shoot secondShoot = new Shoot(9);
        Shoot thirdShoot = new Shoot(3);

        pin.add(firstShoot);
        pin.add(secondShoot);
        pin.add(thirdShoot);
    }

    @Test
    public void checkValidInputTestForFinal() {
        Pin pin = new Pin();

        Shoot firstShoot = new Shoot(10);
        Shoot secondShoot = new Shoot(5);
        Shoot thirdShoot = new Shoot(3);

        pin.add(firstShoot);
        pin.add(secondShoot);
        pin.add(thirdShoot);

        assertThat(pin.getScoreSum()).isEqualTo(18);
    }
}