package com.w3foxes.sarah.Year2023.Day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem1 {
    /**
     * Pipe Maze
     * https://adventofcode.com/2023/day/10
     */
    public static void main(String[] args) throws IOException {
        SnakeMap snakeMap = new SnakeMap();

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the race data
            for (String line; (line = br.readLine()) != null;) {
                snakeMap.readLine(line);
            }
        }

        long farthestPointSteps = snakeMap.walkToFarthestPoint();
        long loopInsides = snakeMap.countLoopInsides();

        System.out.println("Number of steps: " + farthestPointSteps);
        System.out.println("Number inside loop: " + loopInsides);
    }
}
