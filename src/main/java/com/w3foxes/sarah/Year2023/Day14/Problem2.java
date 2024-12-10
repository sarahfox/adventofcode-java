package com.w3foxes.sarah.Year2023.Day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    /**
     * Parabolic Reflector Dish
     * https://adventofcode.com/2023/day/14
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

        Dish d = new Dish(lines);
        d.spinCycle(1000000000);

        System.out.println("Weight: " + d.calculateWeightOnNorthSide());
    }

}
