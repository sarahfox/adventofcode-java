package com.w3foxes.sarah.Year2023.Day02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    @Test
    public void testCreateGame() {
        String game1Data = "Game 21: 4 green, 10 blue, 5 red; 11 blue, 4 green, 1 red; 3 blue, 3 red, 2 green; 1 red, 11 blue, 6 green; 1 green, 9 blue, 5 red; 7 blue, 5 green";
        String game2Data = "Game 92: 1 green, 9 red; 1 red, 4 blue; 9 red, 2 green; 3 red, 1 blue";

        Game game1 = new Game(game1Data);
        Game game2 = new Game(game2Data);

        assertEquals(21, game1.getGameNumber());
        assertEquals(92, game2.getGameNumber());

        assertEquals(6, game1.getRounds().size());
        assertEquals(4, game2.getRounds().size());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Game 1: 8 green; 5 green, 6 blue, 1 red; 2 green, 1 blue, 4 red; 10 green, 1 red, 2 blue; 2 blue, 3 red",
            "Game 2: 10 blue, 12 red; 8 red; 7 green, 5 red, 7 blue",
            "Game 4: 8 green, 4 blue, 1 red; 3 green; 4 blue, 1 red, 12 green; 5 green, 1 red, 8 blue; 3 green, 5 blue, 1 red" })
    public void testIsPossible_trueCase(String input) {
        Game game = new Game(input);
        assertTrue(game.isPossible());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Game 1: 28 green; 5 green, 6 blue, 1 red; 2 green, 1 blue, 4 red; 10 green, 1 red, 2 blue; 2 blue, 3 red",
            "Game 2: 10 blue, 12 red; 8 red; 7 green, 5 red, 17 blue",
            "Game 4: 8 green, 4 blue, 1 red; 3 green; 4 blue, 1 red, 212 green; 5 green, 1 red, 8 blue; 3 green, 5 blue, 1 red" })
    public void testIsPossible_falseCase(String input) {
        Game game = new Game(input);
        assertFalse(game.isPossible());
    }

    @Test
    public void testGetPower() {
        Game game = new Game("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertEquals(48, game.getPower());

        game = new Game("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        assertEquals(12, game.getPower());

        game = new Game("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        assertEquals(1560, game.getPower());

        game = new Game("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        assertEquals(630, game.getPower());

        game = new Game("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");
        assertEquals(36, game.getPower());
    }
}
