package com.w3foxes.sarah.Year2024.Day01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
        public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        long total = calculateSimilarity(lines);
        System.out.println("Total: " + total);
    }

    public static long calculateSimilarity(List<String> lines){
        long total = 0;
        List<Long> left = new ArrayList<>();
        Map<Long, Long> right = new HashMap<>();

        for(String line : lines){
            String[] parts = line.split("\\s+");
            assert(parts.length == 2);

            left.add(Long.parseLong(parts[0]));
            Long rightNum = Long.parseLong(parts[1]);
            if(right.containsKey(rightNum)){
                right.put(rightNum, right.get(rightNum) + 1);
            }
            else {
                right.put(rightNum, 1l);
            }
        }

        for(Long leftNum : left){
            Long rightCount = right.getOrDefault(leftNum, 0l);
            total += leftNum * rightCount;
        }

        return total;
    }
}
