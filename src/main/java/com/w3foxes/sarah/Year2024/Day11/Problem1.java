package com.w3foxes.sarah.Year2024.Day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {
    
    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        List<Long> stones = iterateStones(lines.get(0), 25);

        System.out.println(stones.size());
    }

    public static List<Long> iterateStones(String line, int numIterations){
        // Parse the numbers into longs, then pass it to the other method to handle
        String[] inputs = line.split("\\s+");
        List<Long> stones = new ArrayList<>();
        for(String s : inputs){
            stones.add(Long.parseLong(s));
        }

        return iterateStones(stones, numIterations);
    }

    public static List<Long> iterateStones(List<Long> stones, int numIterations){
        List<Long> input = stones;
        List<Long> output = new ArrayList<>();

        for(int i = 1; i <= numIterations; i++){
            output = new ArrayList<>();
            // Apply rules to each input stone, add to the output
            for(Long stone : input){
                if(stone == 0){
                    output.add(1l);
                }
                else if(("" + stone).length() % 2 == 0){
                    String stoneString = "" + stone;
                    String leftHalf = stoneString.substring(0, stoneString.length() / 2);
                    String rightHalf = stoneString.substring(stoneString.length() / 2);
                    output.add(Long.parseLong(leftHalf));
                    output.add(Long.parseLong(rightHalf));
                }
                else {
                    output.add(stone * 2024);
                }
            }
            // Make the input for the next round the output of this round
            input = output;
        }

        return output;
    }
}
