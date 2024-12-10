package com.w3foxes.sarah.Year2023.Day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2 {
    /**
     * Wait For It
     * https://adventofcode.com/2023/day/6
     *
     */
    public static void main(String[] args) throws IOException {
        List<Long> raceTimes = new ArrayList<>();
        List<Long> raceDistances = new ArrayList<>();
        int total = 1;

        // Find the data file and read it in
        try (InputStream is = Problem1.class.getResourceAsStream("Problem1Input.txt");
                InputStreamReader isReader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isReader);) {

            // Read in the race data
            for (String line; (line = br.readLine()) != null;) {
                if(line.contains("Time:")){
                    StringTokenizer st1 = new StringTokenizer(line.replace("Time:", "").replace(" ", ""), " ", false);
                    while(st1.hasMoreTokens()){
                        raceTimes.add(Long.parseLong(st1.nextToken()));
                    }
                }
                else if(line.contains("Distance:")){
                    StringTokenizer st2 = new StringTokenizer(line.replace("Distance:", "").replace(" ", ""), " ", false);
                    while(st2.hasMoreTokens()){
                        raceDistances.add(Long.valueOf(st2.nextToken()));
                    }
                }
            }
        }
 
        for(int i = 0; i< raceTimes.size(); i++){
            Long raceTime = raceTimes.get(i);
            Long raceDistance = raceDistances.get(i);
            total *= calculateWaysToBeat(raceTime, raceDistance);
        }

        System.out.println("Total: " + total);
    }    

    public static Long calculateWaysToBeat(long time, long record){
        // Max distance is at 1/2 * time
        // How to calculate other times to beat the record?
        // I just can't figure out an equation for this, but going step-by-step is going to be way too long
        // How about a binary search to figure out the endpoints, the subtract to get the range?
        long guess = time / 2;
        long lowerEndpoint = searchLowRange(0, guess, time, record);
        long upperEndpoint = searchHighRange(guess, time, time, record);

        System.out.println("Low: " + lowerEndpoint + " High: " + upperEndpoint);
        return upperEndpoint - lowerEndpoint + 1;
    }

    public static long searchLowRange(long lowerBound, long upperBound, long time, long record){
        if(lowerBound == upperBound){
            return lowerBound;
        }
        else if(lowerBound + 1 == upperBound){
            // 2 options left, one has to be > than the record
            long lowDistance = lowerBound * time - lowerBound * lowerBound;
            if(lowDistance > record){
                return lowerBound;
            }
            else {
                return upperBound;
            }
        }
        else {
            long guess = (lowerBound + upperBound) / 2;
            long guessDistance = (guess * time - guess * guess);
            if(guessDistance > record ){
                return searchLowRange(lowerBound, guess, time, record);
            }
            else {
                return searchLowRange(guess, upperBound, time, record);
            }
        }
    }

 public static long searchHighRange(long lowerBound, long upperBound, long time, long record){
        if(lowerBound == upperBound){
            return lowerBound;
        }
        else if(lowerBound + 1 == upperBound){
            // 2 options left, one has to be > than the record
            long upperDistance = upperBound * time - upperBound * upperBound;
            if(upperDistance > record){
                return upperDistance;
            }
            else {
                return lowerBound;
            }
        }
        else {
            long guess = (lowerBound + upperBound) / 2;
            long guessDistance = (guess * time - guess * guess);
            if(guessDistance <= record){
                return searchHighRange(lowerBound, guess, time, record);
            }
            else {
                return searchHighRange(guess, upperBound, time, record);
            }
        }
    }
}
