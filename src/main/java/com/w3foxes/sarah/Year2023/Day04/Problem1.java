package com.w3foxes.sarah.Year2023.Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem1 {
    /**
     * Scratchcards
     * https://adventofcode.com/2023/day/4
     *
     */
    public static void main(String[] args) throws IOException {
        long total = 0;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the list of scratchcards
            for (String line; (line = br.readLine()) != null;) {
                Scratchcard s = new Scratchcard(line);

                // Figure out the points scored by each one
                // Add it to the total
                total += s.getScore();
            }
        }

        System.out.println("Total: " + total);
    }

}
