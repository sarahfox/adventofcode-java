package com.w3foxes.sarah.Year2023.Day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2 {
    /**
     * If You Give A Seed A Fertilizer
     * https://adventofcode.com/2023/day/5
     *
     */
    public static void main(String[] args) throws IOException {
        long lowestLocation = -1;
        Map<String, AlmanacMap> almanacMaps = new HashMap<>();
        AlmanacMap currentMap = null;
        List<SeedRange> seedList = null;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the almanac data
            for (String line; (line = br.readLine()) != null;) {
                if (line.isEmpty()) {
                    continue;
                }
                if (line.contains(("seeds:"))) {
                    seedList = readSeedList(line);
                } else if (line.contains(("-to-"))) {
                    if (currentMap != null) {
                        almanacMaps.put(currentMap.from, currentMap);
                    }
                    // Start a new map
                    currentMap = new AlmanacMap(line);
                } else {
                    // Read in a map line
                    currentMap.addRange(line);
                }
            }
            if (currentMap != null) {
                almanacMaps.put(currentMap.from, currentMap);
            }

            // Now that we've got the data go through the seed list and figure out the
            // locations
            for (SeedRange seed : seedList) {
                for (long i = 0; i < seed.rangeLength; i++) {
                    long currentLocation = findSeedLocation(seed.getSeedNum() + i, almanacMaps);
                    if (lowestLocation == -1 || currentLocation < lowestLocation) {
                        lowestLocation = currentLocation;
                    }
                }
            }
        }

        System.out.println("Lowest location: " + lowestLocation);
    }

    public static List<SeedRange> readSeedList(String line) {
        List<SeedRange> seeds = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(line.replace("seeds: ", ""), " ", false);
        while (st.hasMoreTokens()) {
            long seedNum = Long.parseLong(st.nextToken());
            long rangeLength = Long.parseLong(st.nextToken());
            seeds.add(new SeedRange(seedNum, rangeLength));
        }

        return seeds;
    }

    public static long findSeedLocation(long seedNum, Map<String, AlmanacMap> almanacMaps) {
        String mapName = "seed";
        long converted = seedNum;
        while (!mapName.equals("location")) {
            AlmanacMap currentMap = almanacMaps.get(mapName);
            converted = currentMap.convertPoint(converted);
            mapName = currentMap.to;
        }

        return converted;
    }
}