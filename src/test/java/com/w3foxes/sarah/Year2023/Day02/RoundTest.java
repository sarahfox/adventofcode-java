package com.w3foxes.sarah.Year2023.Day02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @Test
    public void testCreateRound() {
        String round1Data = " 12 blue, 6 red";
        String round2Data = " 1 blue, 1 green, 15 red";

        Round round1 = new Round(round1Data);
        Round round2 = new Round(round2Data);

        assertEquals(2, round1.ballCounts.size());
        assertEquals(3, round2.ballCounts.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 green, 6 blue, 1 red", "2 green, 1 blue, 4 red", "2 blue, 3 red"})
    public void testIsPossible_trueCase(String input) {
        Round round = new Round(input);
        assertTrue(round.isPossible());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 red, 15 blue, 3 green", "18 green, 8 blue", "36 red"})
    public void testIsPossible_falseCase(String input) {
        Round round = new Round(input);
        assertFalse(round.isPossible());
    }


}
