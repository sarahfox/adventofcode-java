package com.w3foxes.sarah.Year2023.Day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    /**
     * Hot Springs
     * https://adventofcode.com/2023/day/12
     */
    public static void main(String[] args) throws IOException {
        List<SpringData> springData = new ArrayList<>();
        
        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the spring data
            for (String line; (line = br.readLine()) != null;) {
                springData.add(new SpringData(line));
            }
        }

        long sum = springData.stream().mapToLong(SpringData::findNumberOfArrangements).reduce(Long::sum).getAsLong();

        System.out.println("Sum of # of possible solutions: " + sum);
    }
   

}
