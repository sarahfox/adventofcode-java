package com.w3foxes.sarah.Year2024.Day01;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {
    
    public static void main( String[] args ) throws IOException
    {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        
        long total = processLines(lines);
        System.out.println("Total: " + total);
    }

    public static long processLines(List<String> lines){
        long total = 0;
        PriorityQueue<Long> q1 = new PriorityQueue<>();
        PriorityQueue<Long> q2 = new PriorityQueue<>();

        for(String line : lines){
            String[] parts = line.split("\\s+");
            assert(parts.length == 2);

            q1.add(Long.parseLong(parts[0]));
            q2.add(Long.parseLong(parts[1]));
        }

        Long left = q1.poll();
        Long right = q2.poll();
        while(left != null && right != null){
            total += Math.abs(right - left);

            left = q1.poll();
            right = q2.poll();
        }

        return total;
    }
}
