package com.w3foxes.sarah.Year2023.Day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem1 {
    /**
     * Cosmic Expansion
     * https://adventofcode.com/2023/day/11
     */
    public static void main(String[] args) throws IOException {
        GalaxyMap galaxyMap = new GalaxyMap();

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the galaxy data
            for (String line; (line = br.readLine()) != null;) {
                galaxyMap.readLine(line);
            }
        }

        galaxyMap.expandEmptyRowsAndColumns(1000000 - 1 );
        long sumShortestPaths = galaxyMap.calculateSumOfShortestPaths();

        System.out.println("Sum of shortest paths: " + sumShortestPaths);
    }
   
}
