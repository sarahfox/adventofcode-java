package com.w3foxes.sarah.Year2023.Day04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ScratchcardTest {
    @Test
    public void testNewScratchcard() {
        Scratchcard s = new Scratchcard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");

        assertEquals(1, s.getGameNumber());

        Set<Integer> winningNumbers = s.getWinningNumbers();
        assertEquals(5, winningNumbers.size());
        assertTrue(winningNumbers.contains(41));
        assertTrue(winningNumbers.contains(48));
        assertTrue(winningNumbers.contains(83));
        assertTrue(winningNumbers.contains(86));
        assertTrue(winningNumbers.contains(17));

        Set<Integer> yourNumbers = s.getYourNumbers();
        assertEquals(8, yourNumbers.size());
        assertTrue(yourNumbers.contains(83));
        assertTrue(yourNumbers.contains(86));
        assertTrue(yourNumbers.contains(6));
        assertTrue(yourNumbers.contains(31));
        assertTrue(yourNumbers.contains(17));
        assertTrue(yourNumbers.contains(9));
        assertTrue(yourNumbers.contains(48));
        assertTrue(yourNumbers.contains(53));
    }

    @ParameterizedTest
    @CsvSource({ "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53,8",
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19,2",
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1,2",
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83,1",
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36,0",
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11,0" })
    public void testGetScore(String input, String expectedScore) {
        Scratchcard s = new Scratchcard(input);
        assertEquals(expectedScore, "" + s.getScore());
    }

    @ParameterizedTest
    @CsvSource({ "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53,4",
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19,2",
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1,2",
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83,1",
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36,0",
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11,0" })
    public void testGetNumMatches(String input, String expectedScore) {
        Scratchcard s = new Scratchcard(input);
        assertEquals(expectedScore, "" + s.getNumMatches());
    }

    @Test
    public void testNumCopies() {
        Scratchcard s = new Scratchcard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        assertEquals(1, s.getNumCopies());
        s.addCopy();
        s.addCopy();
        s.addCopy();
        assertEquals(4, s.getNumCopies());
    }
}
