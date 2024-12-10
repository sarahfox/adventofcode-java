package com.w3foxes.sarah.Year2023.Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    /**
     * The Floor Will Be Lava
     * https://adventofcode.com/2023/day/16
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

        List<Long> numLights = new ArrayList<>();
        // For each possible entry point, see how many lights light up
        for(int i = 0; i < lines.get(0).length(); i++){
            EnergyGrid grid = new EnergyGrid(lines);
            grid.lightUp(i, 0, BeamDirection.DOWN);
            numLights.add(grid.countLightedSquares());
        }
        for(int i = 0; i < lines.get(0).length(); i++){
            EnergyGrid grid = new EnergyGrid(lines);
            grid.lightUp(i, lines.size() - 1, BeamDirection.UP);
            numLights.add(grid.countLightedSquares());
        }
        for(int i = 0; i < lines.size(); i++){
            EnergyGrid grid = new EnergyGrid(lines);
            grid.lightUp(0, i, BeamDirection.RIGHT);
            numLights.add(grid.countLightedSquares());
        }
        for(int i = 0; i < lines.size(); i++){
            EnergyGrid grid = new EnergyGrid(lines);
            grid.lightUp(lines.get(0).length() - 1, i, BeamDirection.LEFT);
            numLights.add(grid.countLightedSquares());
        }

        System.out.println("Lighted squares: " + numLights.stream().max(Long::compare));
    }

}
