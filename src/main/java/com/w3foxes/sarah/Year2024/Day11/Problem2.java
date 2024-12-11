package com.w3foxes.sarah.Year2024.Day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {

    static Map<CacheKey, Long> cachedSolutions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        long stoneCount = iterateStones(lines.get(0), 75);

        System.out.println(stoneCount);
    }

    public static long iterateStones(String line, int numIterations) {
        // Parse the numbers into longs, then pass it to the other method to handle
        String[] inputs = line.split("\\s+");
        List<Long> stones = new ArrayList<>();
        for (String s : inputs) {
            stones.add(Long.parseLong(s));
        }

        // We really don't have to iterate the whole list at once. Can just iterate each
        // individual number
        long stoneCount = 0l;
        for (Long stone : stones) {
            stoneCount += iterateStone(stone, numIterations);
        }
        return stoneCount;
    }

    public static long iterateStone(long inputStone, int numIterations){
        CacheKey key = new CacheKey(inputStone, numIterations);
        if(cachedSolutions.containsKey(key)){
            return cachedSolutions.get(key);
        }

        // Redo this as recursion
        // Base case: If we're on the zero-ith step, there's the one input stone, no splitting
        if(numIterations == 0){
            cachedSolutions.put(key, 1l);
            return 1;
        }

        // Now handle the cases where we need to iterate more, depending on the stone
        if(inputStone == 0){
            long result = iterateStone(1, numIterations - 1);
            cachedSolutions.put(key, result);
            return result;
        }
        if(("" + inputStone).length() % 2 == 0){
            String stoneString = "" + inputStone;
            String leftHalf = stoneString.substring(0, stoneString.length() / 2);
            String rightHalf = stoneString.substring(stoneString.length() / 2);
            long result = iterateStone(Long.parseLong(leftHalf), numIterations - 1)
                + iterateStone(Long.parseLong(rightHalf), numIterations - 1);
            cachedSolutions.put(key, result);
            return result;
        }

        long result = iterateStone(inputStone * 2024, numIterations - 1);
        cachedSolutions.put(key, result);
        return result;
    }

    public record CacheKey(long stone, long count) {
    };
}
