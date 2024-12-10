package com.w3foxes.sarah.Year2023.Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    /**
     * Clumsy Crucible
     * https://adventofcode.com/2023/day/17
     */
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the spring data
            for (String line; (line = br.readLine()) != null;) {
                lines.add(line);
            }
        }

        CityGrid city = new CityGrid(lines);
        System.out.println("Shortest path: " + city.findShortestPath());
     }

}
