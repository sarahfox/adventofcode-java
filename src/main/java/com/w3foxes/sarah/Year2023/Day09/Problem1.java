package com.w3foxes.sarah.Year2023.Day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    /**
     * Mirage Maintenance
     * https://adventofcode.com/2023/day/9
     */
    public static void main(String[] args) throws IOException {
        List<Sequence> sequences = new ArrayList<>();

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the race data
            for (String line; (line = br.readLine()) != null;) {
                sequences.add(new Sequence(line));
            }
        }

        long sumPredictions = sequences.stream().mapToLong(Sequence::getPrediction).sum();
        long sumPreviousPredictions = sequences.stream().mapToLong(Sequence::getPrevious).sum();

        System.out.println("Sum of predictions: " + sumPredictions);
        System.out.println("Sum of previous predictions: " + sumPreviousPredictions);
    }
}
