package domain;

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
    public void markNone() {
        String none = ScoreMarker.markNone();
        assertEquals(" ", none);
    }

    @Test
    public void markNumber() {
        String number = ScoreMarker.markNumber(8);
        assertEquals("8", number);
    }

    @Test
    public void markSpare() {
        String spare = ScoreMarker.markSpare();
        assertEquals("/", spare);
    }

    @Test
    public void markStrike() {
        String strike = ScoreMarker.markStrike();
        assertEquals("X", strike);
    }

    @Test
    public void markSeparator() {
        String separator = ScoreMarker.markFrameSeparator();
        assertEquals("|", separator);
    }
}