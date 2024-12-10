package com.w3foxes.sarah.Year2023.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem2 {

    /**
     * Cube Conundrum
     * https://adventofcode.com/2023/day/2
     *
     */
    public static void main(String[] args) throws IOException {
        long total = 0;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            for (String line; (line = br.readLine()) != null;) {
                // For each line, read in the game and round information
                Game game = new Game(line);

                // Get the power of the game and add it to the running total
                total += game.getPower();
            }
        }

        System.out.println("Total: " + total);
    }

}
