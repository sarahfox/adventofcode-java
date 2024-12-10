package com.w3foxes.sarah.Year2023.Day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1 {
    /**
     * Wait For It
     * https://adventofcode.com/2023/day/6
     *
     */
    public static void main(String[] args) throws IOException {
        List<Integer> raceTimes = new ArrayList<>();
        List<Integer> raceDistances = new ArrayList<>();
        int total = 1;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the race data
            for (String line; (line = br.readLine()) != null;) {
                if(line.contains("Time:")){
                    StringTokenizer st1 = new StringTokenizer(line.replace("Time:", ""), " ", false);
                    while(st1.hasMoreTokens()){
                        raceTimes.add(Integer.parseInt(st1.nextToken()));
                    }
                }
                else if(line.contains("Distance:")){
                    StringTokenizer st2 = new StringTokenizer(line.replace("Distance:", ""), " ", false);
                    while(st2.hasMoreTokens()){
                        raceDistances.add(Integer.parseInt(st2.nextToken()));
                    }
                }
            }
        }

        for(int i = 0; i< raceTimes.size(); i++){
            int raceTime = raceTimes.get(i);
            int raceDistance = raceDistances.get(i);
            total *= calculateWaysToBeat(raceTime, raceDistance);
        }

        System.out.println("Total: " + total);
    }    

    public static int calculateWaysToBeat(int time, int record){
        int waysToBeat = 0;

        // Max distance is at 1/2 * time
        // How to calculate other times to beat the record?
        // I just can't figure out an equation for this, go step-by-step from the max and check each
        int guess = time / 2;
        while ((guess * time - guess * guess) > record){
            waysToBeat++;
            guess++;
        }
        // And then go down from the max
        guess = time / 2 - 1;
        while ((guess * time - guess * guess) > record){
            waysToBeat++;
            guess--;
        }

        return waysToBeat;
    }
}
