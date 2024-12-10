package com.w3foxes.sarah.Year2023.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem2 {
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

            // Check all the gear symbols
            List<Coordinate> gearCoordinates = schematic.getGearSymbols();
            Map<Coordinate, PartNumber> partNumberMap = schematic.getPartNumberMap();
            for (Coordinate gearCoordinate : gearCoordinates) {
                System.out.println("Checking gear coordinate: " + gearCoordinate.x + ", " + gearCoordinate.y);
                Set<Integer> adjacentParts = new HashSet<>();
                
                // Check the adjacent coordinates and see if they're parts there
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(gearCoordinate.x == 100 && gearCoordinate.y == 1){
                            System.out.println("Looking for part at: " + (gearCoordinate.x + i) + ", " + (gearCoordinate.y + j));
                        }
                        PartNumber found = partNumberMap.get(new Coordinate(gearCoordinate.x + i, gearCoordinate.y + j));
                        if(found != null){
                            if(gearCoordinate.x == 100 && gearCoordinate.y == 1){
                            System.out.println("Found one part: " + found.getPartNumber());
                            }
                            adjacentParts.add(found.getPartNumber());
                        }
                    }
                }

                // If there are two part numbers found, multiply them together, then add them to the total
                if(adjacentParts.size() == 2){
                    total += adjacentParts.stream().reduce(1, (a, b) -> a * b);
                }
                else {
                    System.out.println("No adjacent parts found");
                }
            }

        }

        System.out.println("Total: " + total);
    }

}
