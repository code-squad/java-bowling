package bowling.domain;

import bowling.domain.Utils.Validator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void validateName_Over_3_Letters() {
        Validator.validateName("POBI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateName_Under_3_Letters() {
        Validator.validateName("HI");
    }

    @Test
    public void isValidScore_Strike() {
        assertTrue(Validator.isValidScore(10, 10));
    }

    @Test
    public void isValidScore_Spare() {
        assertTrue(Validator.isValidScore(2, 2));
    }

    @Test
    public void isValidScore_Zero() {
        assertTrue(Validator.isValidScore(0, 10));
    }

    @Test
    public void isValidScore_Over_10() {
        assertFalse(Validator.isValidScore(11, 10));
    }

    @Test
    public void isValidScore_Under_0() {
        assertFalse(Validator.isValidScore(-1, 10));
    }

    @Test
    public void isValidScore_More_Than_Pins_Standing() {
        assertFalse(Validator.isValidScore(5, 4));
    }
}