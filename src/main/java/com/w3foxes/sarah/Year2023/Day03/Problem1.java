package com.w3foxes.sarah.Year2023.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Problem1 {
    /**
     * Gear Ratios
     * https://adventofcode.com/2023/day/3
     *
     */
    public static void main(String[] args) throws IOException {
        long total = 0;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the part schematic
            int rowNumber = 0;
            Schematic schematic = new Schematic();
            for (String line; (line = br.readLine()) != null;) {
                schematic.readLine(rowNumber, line);
                rowNumber++;
            }

            // Check all the part numbers
            List<PartNumber> partNumbers = schematic.getPartNumbers();
            for (PartNumber partNumber : partNumbers) {
                List<Coordinate> adjacentCoords = partNumber.getAdjacentCoordinates();
                boolean hasAdjacentSymbol = adjacentCoords.stream().anyMatch(ac -> schematic.hasSymbol(ac));

                // If they're next to a symbol, add the number to the total
                if (hasAdjacentSymbol) {
                    total += partNumber.getPartNumber();
                }
            }

        }

        System.out.println("Total: " + total);
    }

}
