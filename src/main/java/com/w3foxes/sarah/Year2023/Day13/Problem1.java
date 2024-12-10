package com.w3foxes.sarah.Year2023.Day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    /**
     * Point of Incidence
     * https://adventofcode.com/2023/day/13
     */
    public static void main(String[] args) throws IOException {
        List<ReflectionMap> mapData = new ArrayList<>();
        ReflectionMap currentMap = null;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the spring data
            for (String line; (line = br.readLine()) != null;) {
                if(currentMap == null){
                    currentMap = new ReflectionMap();
                }

                if(line.isBlank() || line.isEmpty()){
                    mapData.add(currentMap);
                    currentMap = new ReflectionMap();
                }
                else {
                    currentMap.readLine(line);
                }
            }
            mapData.add(currentMap);
        }

        long total = 0;
        for(ReflectionMap map : mapData){
            System.out.println("Reflection: " + map.findReflection());
            total += map.findReflection();
        }

        long sum = mapData.stream().mapToLong(ReflectionMap::findReflection).reduce(Long::sum).getAsLong();
        long smudgedSum = mapData.stream().mapToLong(ReflectionMap::findSmudgedReflection).reduce(Long::sum).getAsLong();

        System.out.println("Sum of reflection indexes: " + sum);
        System.out.println("Totalling another way: " + total);
        System.out.println("Smudged sum: " + smudgedSum);
    }

}
