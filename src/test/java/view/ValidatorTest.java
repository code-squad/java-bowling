package view;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void isValidName_Three_Letters() {
        assertEquals("Jae", Validator.validateName("Jae"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidName_Less_Than_Three_Letters() {
        Validator.validateName("JP");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidName_Greater_Than_Three_Letters() {
        Validator.validateName("Pobi");
    }

    @Test
    public void isValidNumber() {
        assertEquals(10, Validator.validateScore("10"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidNumber_Not_A_Number() {
        Validator.validateScore("A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidNumber_Over_Max_Score() {
        Validator.validateScore("11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidNumber_Under_Min_Score() {
        Validator.validateScore("0");
    }
}