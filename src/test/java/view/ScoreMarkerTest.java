package view;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreMarkerTest {

    @Test
    public void markPlayerName() {
        String playerName = ScoreMarker.markPlayerName("name");
        assertEquals("name", playerName);
    }

    @Test
    public void markFrameNumber() {
        String frameNumber = ScoreMarker.markFrameNumber(5);
        assertEquals("05", frameNumber);
    }

    @Test
    public void markNumbers() {
        String number = ScoreMarker.markNumbers(5, 4);
        assertEquals("5|4", number);
    }

    @Test
    public void markSpare() {
        String spare = ScoreMarker.markSpare(9);
        assertEquals("9|/", spare);
    }

    @Test
    public void markStrike() {
        String strike = ScoreMarker.markStrike();
        assertEquals("X  ", strike);
    }

    @Test
    public void markBonusNumber() {
        String bonus = ScoreMarker.markBonusNumber(8);
        assertEquals("|8", bonus);
    }

    @Test
    public void markEmpty() {
        String empty = ScoreMarker.markEmpty();
        assertEquals(" ", empty);
    }

    @Test
    public void markSeparator() {
        String separator = ScoreMarker.markSeparator();
        assertEquals("|", separator);
    }
}