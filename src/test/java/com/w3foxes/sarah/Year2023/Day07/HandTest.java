package com.w3foxes.sarah.Year2023.Day07;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HandTest {
    @ParameterizedTest
    @CsvSource({ "33332,FOUR_OF_A_KIND",
            "77888,FULL_HOUSE",
            "32T3K,ONE_PAIR",
            "KTJJT,FOUR_OF_A_KIND",
            "QQQJA,FOUR_OF_A_KIND",
            "AAAAA,FIVE_OF_A_KIND",
            "JJJJJ,FIVE_OF_A_KIND",
            "J2345,ONE_PAIR",
            "J234J,THREE_OF_A_KIND" })
    public void testGetHandType(String input, String expectedHandType) {
        Hand h = new Hand(input);
        assertEquals(expectedHandType, "" + h.getHandType());
    }
}
